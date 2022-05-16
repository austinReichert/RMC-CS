import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


class GameOver(State):
    def __init__(self, player, enemy, turn):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = 'Title'
        self.player = player
        self.enemy = enemy
        self.turn = turn
        self.updated = False

    def getEvent(self, event):
        if self.updated is False:
            self.checkUpdated()
        if event.type == pygame.KEYDOWN:
            self.update()

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        _displayText(window, 150, 0, Color.RED, "You DIED!", self.fonts['base'])
        _displayText(window, 150, 50, Color.BLUE, "Level:{}".format(self.player.level), self.fonts['base'])
        _displayText(window, 150, 100, Color.BLUE, "Luck:{}".format(self.player.luck), self.fonts['base'])
        _displayText(window, 150, 150, Color.BLUE, "Attack:{}".format(self.player.attack), self.fonts['base'])
        _displayText(window, 150, 200, Color.BLUE, "Defence:{}".format(self.player.defence), self.fonts['base'])
        _displayText(window, 150, 250, Color.BLUE, "Speed:{}".format(self.player.speed), self.fonts['base'])
        _displayText(window, 150, 300, Color.BLUE, "Max HP:{}".format(self.player.maxHP), self.fonts['base'])
        _displayText(window, 150, 350, Color.BLUE, "Max MP:{}".format(self.player.maxMP), self.fonts['base'])
        _displayText(window, 150, 400, Color.RED, "Press any key to return.", self.fonts['base'])

    def update(self):
        self.updated = False
        self.clearData()
        self.complete = True
        self.resetCharacters()

    def start(self, data):
        self.data = data

    def clearData(self):
        self.data.clear()

    def checkUpdated(self):
        if self.player.currentHP <= 0:
            self.updated = True

    def resetCharacters(self):
        self.player.reset()
        self.enemy.reset()
        self.turn.reset()