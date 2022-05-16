import pygame

from STATES.baseState import State
from colors import Color


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


class Title(State):
    def __init__(self, player, enemy):
        super().__init__()
        self.previousState = None
        self.nextState = 'Game'
        self.complete = False
        self.font = pygame.font.Font(None, 70)
        self.scale = 0
        self.player = player
        self.enemy = enemy

    def saveData(self, newData):
        self.data = newData

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                self.complete = True
                self.update()
            if event.key == pygame.K_1:
                if self.scale > 0:
                    self.updateScale(-1)
            if event.key == pygame.K_2:
                if self.scale < 2500:
                    self.updateScale(1)
            if event.key == pygame.K_0:
                if self.scale < 2500:
                    self.updateScale(50)

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        _popOutText(window, 100, 50, Color.RED, Color.BLUE, "RANDOM RPG", self.fonts['title'])
        _displayText(window, 150, 177, Color.BLUE, "Press Space To Begin", self.fonts['base'])
        _displayText(window, 50, 250, Color.RED, "Press 1 (-) and 2 (+) to set scale amount", self.fonts['base'])
        _displayText(window, 300, 300, Color.BLUE, self.scale, self.fonts['tiny'])
        _popOutText(window, 250, 350, Color.RED, Color.GREEN, "Made by Austin Reichert", self.fonts['mini'])

    def update(self):
        self.player.scale = self.scale
        self.enemy.scale = self.scale
        self.player.levelUp()
        self.enemy.levelUp(self.player)

    def updateScale(self, amount):
        self.scale += amount
