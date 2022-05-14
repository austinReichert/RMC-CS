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


class Moves(State):
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
        window.fill(Color.LIGHTBLUE)
        color = Color.BLUE
        titleFont = self.fonts['base']
        descriptionFont = self.fonts['mini']
        moves = self.player.moveSet
        _popOutText(window, 240, 0, Color.RED, color, self.player.name, self.fonts['base'])
        self.showMoveData(window, 100, 50, color, moves[0], titleFont, descriptionFont, 1)
        self.showMoveData(window, 100, 125, color, moves[1], titleFont, descriptionFont, 2)
        self.showMoveData(window, 100, 200, color, moves[2], titleFont, descriptionFont, 3)
        self.showMoveData(window, 100, 275, color, moves[3], titleFont, descriptionFont, 4)
        _displayText(window, 150, 400, Color.RED, "Press any key to return.", self.fonts['base'])

    def start(self, data):
        self.data = data

    def showMoveData(self, window, x, y, color, move, mainFont, secondFont, number):
        _displayText(window, x, y, color, "{}: {}(MP: {})".format(number, move, abilities.manaCosts.costs[str(move)]), mainFont)
        _displayText(window, x, (y + 40), color, "{}".format(abilities.abilityDescriptions.descriptions[str(move)]), secondFont)
