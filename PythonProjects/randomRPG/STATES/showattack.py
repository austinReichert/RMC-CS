import pygame
from colors import Color
from STATES.baseState import State


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


class ShowAttack(State):
    def __init__(self, player, enemy, turn):
        super().__init__()
        self.previousState = 'Attack'
        self.nextState = 'Game'
        self.player = player
        self.enemy = enemy
        self.turn = turn

    def getEvent(self, event):
        if event.type == pygame.KEYDOWN:
            self.update()
            self.complete = True

    def draw(self, window):
        window.fill(Color.LIGHTBLUE)
        self.showAction(window, 100, 100, Color.BLUE, self.player, 0, self.fonts['base'])
        self.showAction(window, 100, 200, Color.BLUE, self.enemy, 1, self.fonts['base'])
        _displayText(window, 150, 400, Color.RED, "Press space to continue.", self.fonts['base'])

    def update(self):
        self.turn.turn += 1
        self.clearData()

    def start(self, data):
        self.data = data

    def clearData(self):
        self.data.clear()

    def showAction(self, window, x, y, color, character, number, color2=Color.RED):
        try:
            _displayText(window, x, y, color, "{} used {}!".format(str(character.name), str(self.data[number])),
                         self.fonts['base'])
        except KeyError:
            pass
