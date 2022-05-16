import random

import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


def checkBoss(character):
    try:
        if character.isBoss:
            return True
        else:
            return False
    except AttributeError:
        return False


class Game(State):
    def __init__(self, player, enemy, turn):
        super().__init__()
        self.previousState = 'Title'
        self.nextState = 'GameOver'
        self.player = player
        self.enemy = enemy
        self.turn = turn

    def saveData(self, newData):
        self.data[len(self.data)] = newData

    def getEvent(self, event):
        self.checkHP(self.player, self.enemy)
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_1:
                self.nextState = 'Stats'
                self.complete = True
            if event.key == pygame.K_2:
                self.nextState = 'Moves'
                self.complete = True
            if event.key == pygame.K_3:
                self.nextState = 'Attack'
                self.complete = True

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        self.statWindow(window, 25, 220, self.player)
        self.statWindow(window, 375, 40, self.enemy)
        if self.enemy.isBoss:
            _popOutText(window, 450, 0, Color.PURPLE, Color.TEAL, "BOSS", self.fonts['base'])
        self.makeButtons(window)
        _displayText(window, 0, 0, Color.BLACK, "Turn {}".format(self.turn.turn), self.fonts['base'])

    def update(self):
        pass

    def start(self, data):
        self.data = data

    def statWindow(self, window, baseX, baseY, character):
        windowX = 250
        windowY = 135
        pygame.draw.rect(window, Color.GREY, (baseX, baseY, (windowX + 4), (windowY + 2)))
        pygame.draw.rect(window, Color.LIGHTGREY, (baseX, baseY, windowX, windowY))
        _displayText(window, (baseX + 5), (baseY + 5), Color.BLUE, character.name, self.fonts['tiny'])
        _displayText(window, (baseX + 105), (baseY + 5), Color.BLACK, "Level: {}".format(character.level),
                     self.fonts['tiny'])
        _popOutText(window, (baseX + 10), (baseY + 25), Color.RED, Color.BLUE, "HP:", self.fonts['base'])
        _displayText(window, (baseX + 95), (baseY + 30), Color.PURPLE,
                     "{}/{}".format(character.currentHP, character.maxHP), self.fonts['tiny'])
        self.displayBar(window, (baseX + 10), (baseY + 65), (character.currentHP / character.maxHP))
        self.displayBar(window, (baseX + 10), (baseY + 115), (character.currentMP / character.maxMP), Color.BLUE)
        _popOutText(window, (baseX + 10), (baseY + 75), Color.BLUE, Color.PURPLE, "MP:", self.fonts['base'])
        _displayText(window, (baseX + 95), (baseY + 80), Color.PURPLE,
                     "{}/{}".format(character.currentMP, character.maxMP), self.fonts['tiny'])

    def displayBar(self, window, x, y, percent, barColor=Color.RED):
        pygame.draw.rect(window, Color.BLACK, (x, y, 200, 10))
        pygame.draw.rect(window, barColor, (x, y, round(200 * percent), 10))

    def makeButtons(self, window):
        buttonX, buttonY = 100, 375
        self.makeButton(window, buttonX, buttonY, "Stats", "1")
        self.makeButton(window, (buttonX + 150), buttonY, "Moves", "2")
        self.makeButton(window, (buttonX + 300), buttonY, "Attack", "3")

    def makeButton(self, window, x, y, text, key=None):
        pygame.draw.rect(window, Color.GREY, (x, y, 124, 102))
        pygame.draw.rect(window, Color.LIGHTGREY, (x, y, 120, 100))
        _displayText(window, (x + 25), (y + 25), Color.BLUE, text, self.fonts['base'])
        if key is not None:
            pygame.draw.rect(window, Color.GREY, ((x + 50), (y - 10), 24, 22))
            pygame.draw.rect(window, Color.LIGHTGREY, ((x + 50), (y - 10), 20, 20))
            _displayText(window, (x + 55), (y - 15), Color.PURPLE, key, self.fonts['tiny'])

    def checkHP(self, player, enemy):
        if player.currentHP <= 0 and enemy.currentHP <= 0:
            if random.randint(0, 100) < 50:
                self.nextState = 'GameOver'
                self.complete = True
            else:
                self.nextState = 'LevelUp'
                self.complete = True
        elif player.currentHP <= 0:
            self.nextState = 'GameOver'
            self.complete = True
        elif enemy.currentHP <= 0:
            self.nextState = 'LevelUp'
            self.complete = True
