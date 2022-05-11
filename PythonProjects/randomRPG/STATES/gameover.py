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
    def __init__(self, player):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = 'Title'
        self.player = player

    def getEvent(self, event):
        pass

    def draw(self, window):
        pass

    def update(self):
        pass

    def start(self, data):
        self.data = data

    def clearData(self):
        self.data.clear()
