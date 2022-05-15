import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


class Stats(State):
    def __init__(self, player):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = None
        self.player = player

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            self.complete = True
            self.data = {}

    def draw(self, window):
        font = self.fonts['base']
        color = Color.BLUE
        window.fill(Color.LIGHTBLUE)
        _popOutText(window, 200, 0, Color.RED, color, "{}s stats".format(self.player.name), self.fonts['subtitle'])
        _displayText(window, 220, 50, color, "LEVEL: {}".format(self.player.level), font)
        _displayText(window, 220, 100, color, "LUCK: {}".format(self.player.luck), font)
        _displayText(window, 220, 150, color, "ATTACK: {}".format(self.player.attack), font)
        _displayText(window, 220, 200, color, "DEFENCE: {}".format(self.player.defence), font)
        _displayText(window, 220, 250, color, "SPEED: {}".format(self.player.speed), font)
        _displayText(window, 220, 300, color, "HP: {}/{}".format(self.player.currentHP, self.player.maxHP), font)
        _displayText(window, 220, 350, color, "MP: {}/{}".format(self.player.currentMP, self.player.maxMP), font)
        _displayText(window, 150, 400, Color.RED, "Press any key to return.", font)

    def start(self, data):
        self.data = data
