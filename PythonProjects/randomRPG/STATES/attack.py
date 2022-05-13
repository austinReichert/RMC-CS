import pygame
import battle
from STATES.baseState import State
from colors import Color
import abilities


def _displayText(window, x, y, color, text, font):
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def _popOutText(window, x, y, topColor, bottomColor, text, font):
    _displayText(window, x, y, bottomColor, text, font)
    _displayText(window, x + 2, y + 2, topColor, text, font)


def showMoveData(window, x, y, color, move, mainFont, secondFont, number):
    _displayText(window, x, y, color, "{}: {}".format(number, move),
                 mainFont)
    _displayText(window, x, (y + 40), color, "{} MP".format(abilities.manaCosts.costs[str(move)]),
                 secondFont)


def getMove(number, character):
    moves = character.getMoves()
    move = moves[number]
    return move


class Attack(State):
    def __init__(self, player, enemy):
        super().__init__()
        self.previousState = 'Game'
        self.nextState = None
        self.player = player
        self.enemy = enemy
        self.battle = battle

    def getEvent(self, event):
        if self.nextState is not None:
            self.nextState = None
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_1:
                self.completeAction(getMove(0, self.player), 0)
            if event.key == pygame.K_2:
                self.completeAction(getMove(1, self.player), 1)
            if event.key == pygame.K_3:
                self.completeAction(getMove(2, self.player), 2)
            if event.key == pygame.K_4:
                self.completeAction(getMove(3, self.player), 3)
            if event.key == pygame.K_SPACE:
                self.complete = True

    def draw(self, window):
        moves = self.player.getMoves()
        window.fill(Color.LIGHTBLUE)
        _displayText(window, 125, 25, Color.RED, "Press a key to use that ability.", self.fonts['base'])
        showMoveData(window, 150, 75, Color.BLUE, moves[0], self.fonts['subtitle'], self.fonts['tiny'], 1)
        showMoveData(window, 150, 150, Color.BLUE, moves[1], self.fonts['subtitle'], self.fonts['tiny'], 2)
        showMoveData(window, 150, 225, Color.BLUE, moves[2], self.fonts['subtitle'], self.fonts['tiny'], 3)
        showMoveData(window, 150, 300, Color.BLUE, moves[3], self.fonts['subtitle'], self.fonts['tiny'], 4)
        _displayText(window, 150, 400, Color.RED, "Press space to return.", self.fonts['base'])

    def update(self):
        self.nextState = 'ShowAttack'

    def start(self, data):
        self.data = data

    def completeAction(self, move, playerNumber):
        enemyNumber = self.enemy.mainLogic(self.player)
        enemyMove = getMove(enemyNumber, self.enemy)
        if self.player.speed >= self.enemy.speed:
            playerDmg = self.battle.attack(playerNumber, self.player, self.enemy)
            self.saveCharacterAction(self.player.name, move, playerDmg)
            enemyDmg = self.battle.attack(enemyNumber, self.enemy, self.player)
            self.saveCharacterAction(self.enemy.name, enemyMove, enemyDmg)
        else:
            enemyDmg = self.battle.attack(enemyNumber, self.enemy, self.player)
            self.saveCharacterAction(self.enemy.name, enemyMove, enemyDmg)
            playerDmg = self.battle.attack(playerNumber, self.player, self.enemy)
            self.saveCharacterAction(self.player.name, move, playerDmg)
        self.complete = True
        self.update()
        print()

    def saveCharacterAction(self, name, move, dmg):
        self.saveData(name)
        self.saveData(move)
        self.saveData(dmg)
