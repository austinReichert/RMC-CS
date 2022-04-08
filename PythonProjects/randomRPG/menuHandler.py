import pygame
from colors import Color
from enum import Enum
import gameHandler


# game states//menus

class Menus(Enum):
    gameInit = 0,
    playGame = 1,
    playerStats = 2,
    playerMoves = 3,
    playerLevelUp = 3,
    gameOver = 4


# game functions

def startGame():
    window, clock = initWindow()
    state = Menus.gameInit
    gameLoop(window=window, clock=clock, state=state)


def initWindow():
    pygame.init()
    gameWindow = pygame.display.set_mode((600, 600))
    pygame.display.set_caption("RANDOM RPG")
    timer = pygame.time.Clock()
    return gameWindow, timer


def gameLoop(window, clock, state):
    while True:
        eventDirectory(window, state)
        window.fill(Color.WHITE)
        updateGameStuff(clock)


def eventDirectory(window, state):
    if state == Menus.gameInit:
        pass
    elif state == Menus.playGame:
        pass
    elif state == Menus.playerStats:
        pass
    elif state == Menus.playerMoves:
        pass
    elif state == Menus.playerLevelUp:
        pass
    elif state == Menus.gameOver:
        pass


def updateGameStuff(clock):
    pygame.display.update()
    clock.tick(30)


def drawTextToScreen(text, window, color, x, y, textSize=25):
    font = pygame.font.SysFont('Comic Sans MS', textSize)
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def safeQuit():
    pygame.quit()
    exit(3)
