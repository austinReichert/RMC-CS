import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


class LevelUp(State):
    def __init__(self, player, enemy, turn):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = 'Game'
        self.player = player
        self.enemy = enemy
        self.turn = turn
        self.updated = False
        self.stats = self.compareStats()

    def saveData(self, newData):
        self.data[len(self.data)] = newData

    def getEvent(self, event):
        if self.updated is False:
            self.checkUpdated()
            self.stats = self.compareStats()
        if self.updated:
            if event.type == pygame.KEYDOWN:
                self.complete = True
                self.updated = False

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        _displayText(window, 100, 50, Color.PURPLE, "YOU LEVELED UP!", self.fonts['base'])
        _displayText(window, 50, 100, Color.BLUE, "{}'s Luck increased by {}!".format(self.player.name, self.stats[0]), self.fonts['base'])
        _displayText(window, 50, 150, Color.BLUE, "{}'s Attack increased by {}!".format(self.player.name, self.stats[1]), self.fonts['base'])
        _displayText(window, 50, 200, Color.BLUE, "{}'s Defence increased by {}!".format(self.player.name, self.stats[2]), self.fonts['base'])
        _displayText(window, 50, 250, Color.BLUE, "{}'s HP increased by {}!".format(self.player.name, self.stats[3]), self.fonts['base'])
        _displayText(window, 50, 300, Color.BLUE, "{}'s MP increased by {}!".format(self.player.name, self.stats[4]), self.fonts['base'])
        _displayText(window, 150, 400, Color.RED, "Press any key to continue.", self.fonts['base'])

    def update(self):
        self.player.levelUp()
        self.enemy.levelUp(self.player)
        self.turn.turn = 1

    def start(self, data):
        self.data = data

    def compareStats(self):
        if self.updated is True:
            oldStats = [self.player.luck, self.player.attack, self.player.defence, self.player.maxHP, self.player.maxMP]
            self.update()
            newStats = [self.player.luck, self.player.attack, self.player.defence, self.player.maxHP, self.player.maxMP]
            statChanges = []
            for i in range(len(oldStats)):
                statChanges.append(newStats[i] - oldStats[i])
            return statChanges

    def checkUpdated(self):
        if self.enemy.currentHP <= 0:
            self.updated = True
