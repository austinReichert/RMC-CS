import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


class Attack(State):
    def __init__(self, player, enemy):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = None
        self.player = player
        self.enemy = enemy

    def saveData(self, newData):
        self.data = newData

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_1:
                pass
            if event.key == pygame.K_2:
                pass
            if event.key == pygame.K_3:
                pass
            if event.key == pygame.K_4:
                pass

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)

    def update(self):
        pass

    def start(self, data):
        self.data = data
