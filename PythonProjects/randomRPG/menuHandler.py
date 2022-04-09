import pygame
from colors import Color
import enum
import gameHandler


# game states//menus

class Menus(enum.Enum):
    GAMEINIT = 0,
    PLAYGAME = 1,
    PLAYERSTATS = 2,
    PLAYERMOVES = 3,
    PLAYERLEVELUP = 3,
    GAMEOVER = 4


# game functions

def startGame():
    window, clock = initWindow()
    state = Menus.GAMEINIT
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
    if state == Menus.GAMEINIT:
        pass
    elif state == Menus.PLAYGAME:
        pass
    elif state == Menus.PLAYERSTATS:
        pass
    elif state == Menus.PLAYERMOVES:
        pass
    elif state == Menus.PLAYERLEVELUP:
        pass
    elif state == Menus.GAMEOVER:
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
