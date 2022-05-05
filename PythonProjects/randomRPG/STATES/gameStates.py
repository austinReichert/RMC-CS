import pygame
from colors import Color

from STATES.baseState import State


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x+2, y+2, topColor, text, font)


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
        _popOutText(window, 120, 50, Color.RED, Color.BLUE, "RANDOM RPG", self.fonts['title'])
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
        self.statWindow(window, "Player", 25, 220)
        self.statWindow(window, "enemy", 400, 40)
        self.makeButtons(window)

    def update(self):
        pass

    def start(self, data):
        self.data = data

    def statWindow(self, window, name, baseX, baseY):
        windowX = 225
        windowY = 135
        pygame.draw.rect(window, Color.GREY, (baseX, baseY, (windowX + 4), (windowY + 2)))
        pygame.draw.rect(window, Color.LIGHTGREY, (baseX, baseY, windowX, windowY))
        _displayText(window, (baseX + 10), (baseY + 5), Color.BLUE, name, self.fonts['tiny'])
        _popOutText(window, (baseX + 10), (baseY + 25), Color.RED, Color.BLUE, "HP:", self.fonts['base'])
        _displayText(window, (baseX + 95), (baseY + 30), Color.PURPLE, "20/53", self.fonts['tiny'])
        self.displayBar(window, (baseX + 10), (baseY + 65), 200, 100)
        self.displayBar(window, (baseX + 10), (baseY + 115), 200, 134, Color.BLUE)
        _popOutText(window, (baseX + 10), (baseY + 75), Color.BLUE, Color.PURPLE, "MP:", self.fonts['base'])
        _displayText(window, (baseX + 95), (baseY + 80), Color.PURPLE, "20/53", self.fonts['tiny'])

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

    def displayBar(self, window, x, y, empty, full, barColor=Color.RED):
        pygame.draw.rect(window, Color.BLACK, (x, y, empty, 10))
        pygame.draw.rect(window, barColor, (x, y, full, 10))


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


class Attack(State):
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
