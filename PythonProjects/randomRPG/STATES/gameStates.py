import pygame
from colors import Color

from STATES.baseState import State


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


class Title(State):
    def __init__(self):
        super().__init__()
        self.previousState = None
        self.nextState = 'Game'
        self.complete = False
        self.font = pygame.font.Font(None, 70)
        self.scale = 0

    def saveData(self, newData):
        self.data = newData

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                self.complete = True
                self.saveData(self.scale)
            if event.key == pygame.K_1:
                if self.scale > 0:
                    self.updateScale(-1)
            if event.key == pygame.K_2:
                self.updateScale(1)

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        _displayText(window, 120, 50, Color.BLUE, "RANDOM RPG", self.fonts['title'])
        _displayText(window, 122, 52, Color.RED, "RANDOM RPG", self.fonts['title'])
        _displayText(window, 160, 177, Color.BLUE, "Press Space To Begin", self.fonts['base'])
        _displayText(window, 50, 250, Color.RED, "Press 1 (-) and 2 (+) to set scale amount", self.fonts['base'])
        _displayText(window, 300, 300, Color.BLUE, self.scale, self.fonts['tiny'])

    def updateScale(self, amount):
        self.scale += amount


class Game(State):
    def __init__(self):
        super().__init__()
        self.previousState = 'Title'
        self.nextState = 'GameOver'

    def saveData(self, newData):
        self.data += newData

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_1:
                pass
                # player stats
            if event.key == pygame.K_2:
                pass
                # moves and desc
            if event.key == pygame.K_3:
                pass
                # attack

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)

    def update(self):
        pass

    def start(self, data):
        self.data = data


class Moves(State):
    def __init__(self):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = None


class Stats(State):
    def __init__(self):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = None


class LevelUp(State):
    def __init__(self):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = 'Game'


class GameOver(State):
    def __init__(self):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = 'Title'
