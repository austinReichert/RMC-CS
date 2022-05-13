import pygame
from colors import Color
from STATES.baseState import State
import abilities


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def passiveManaRegen(player, enemy):
    abilities.passiveMana(player)
    abilities.passiveMana(enemy)


def turnDecay(player, enemy, turn):
    turnAmount = turn.turn
    if turnAmount > 30:
        abilities.turnDecay(player, turnAmount)
        abilities.turnDecay(enemy, turnAmount)


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
        self.showAction(window, 100, 100, 0, 1, 2)
        self.showAction(window, 100, 200, 3, 4, 5)
        _displayText(window, 150, 400, Color.RED, "Press space to continue.", self.fonts['base'])

    def update(self):
        passiveManaRegen(self.player, self.enemy)
        turnDecay(self.player, self.enemy, self.turn)
        self.turn.turn += 1
        self.clearData()

    def start(self, data):
        self.data = data

    def clearData(self):
        self.data.clear()

    def showAction(self, window, x, y, numberName, numberMove, numberData):
        colorA = Color.BLUE
        colorB = Color.RED
        try:
            _displayText(window, x, y, colorA, "{} used {}!".format(self.data[numberName], self.data[numberMove]), self.fonts['base'])
            if self.checkAccuracy(self.data[numberData]):
                _displayText(window, x, (y + 50), colorB,
                             "{} was used for {}!".format(self.data[numberMove], self.data[numberData]),
                             self.fonts['base'])
            else:
                _displayText(window, x, (y + 50), colorB,
                             "{}'s ability missed!".format(self.data[numberMove]),
                             self.fonts['base'])
        except KeyError:
            pass

    def checkAccuracy(self, number):
        if number > 0:
            return True
        else:
            return False
