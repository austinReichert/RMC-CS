import pygame

from STATES.baseState import State
from colors import Color
import abilities


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
            if event.key == pygame.K_SPACE:
                self.complete = True

    def draw(self, window):
        moves = self.player.getMoves()
        window.fill(Color.LIGHTBLUE)
        _displayText(window, 125, 25, Color.RED, "Press a key to use that ability.", self.fonts['base'])
        self.showMoveData(window, 150, 75, Color.BLUE, moves[0], self.fonts['subtitle'], self.fonts['tiny'], 1)
        self.showMoveData(window, 150, 150, Color.BLUE, moves[1], self.fonts['subtitle'], self.fonts['tiny'], 2)
        self.showMoveData(window, 150, 225, Color.BLUE, moves[2], self.fonts['subtitle'], self.fonts['tiny'], 3)
        self.showMoveData(window, 150, 300, Color.BLUE, moves[3], self.fonts['subtitle'], self.fonts['tiny'], 4)
        _displayText(window, 150, 400, Color.RED, "Press space to return.", self.fonts['base'])

    def update(self):
        pass

    def start(self, data):
        self.data = data

    def showMoveData(self, window, x, y, color, move, mainFont, secondFont, number):
        _displayText(window, x, y, color, "{}: {}".format(number, move),
                     mainFont)
        _displayText(window, x, (y + 40), color, "{} MP".format(abilities.manaCosts.costs[str(move)]),
                     secondFont)