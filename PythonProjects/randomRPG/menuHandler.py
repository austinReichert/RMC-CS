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
    PLAYERLEVELUP = 4,
    GAMEOVER = 5


class State(object):
    def __init__(self):
        self._currentState = Menus.GAMEINIT

    @property
    def currentState(self):
        return self._currentState

    @currentState.setter
    def currentState(self, newState):
        self._currentState = newState


# game functions

def initWindow():
    pygame.init()
    gameWindow = pygame.display.set_mode((600, 600))
    pygame.display.set_caption("RANDOM RPG")
    timer = pygame.time.Clock()
    return gameWindow, timer


def startGame():
    window, clock = initWindow()
    state = State()
    eventDirectory(window, state, clock)


def eventDirectory(window, state, clock):
    if state.currentState == Menus.GAMEINIT:
        scale = gameHandler.scaleFactor()
        _gameInitDisplay(window, state, scale, clock)
    elif state.currentState == Menus.PLAYGAME:
        _playGameDisplay(window, state, clock)
    elif state.currentState == Menus.PLAYERSTATS:
        _playerStatsDisplay(window, state, clock)
    elif state.currentState == Menus.PLAYERMOVES:
        _playerMovesDisplay(window, state, clock)
    elif state.currentState == Menus.PLAYERLEVELUP:
        _playerLevelUpDisplay(window, state, clock)
    elif state.currentState == Menus.GAMEOVER:
        _gameOverDisplay(window, state, clock)


def updateGameStuff(clock):
    pygame.display.update()
    clock.tick(30)


def drawTextToScreen(text, window, x, y, color=Color.BLACK, textSize=25):
    font = pygame.font.SysFont('Comic Sans MS', textSize)
    txt = font.render(str(text), True, color)
    window.blit(txt, (x, y))


def safeQuit():
    pygame.quit()
    exit(3)


def _gameInitDisplay(window, state, scale, clock):
    while state.currentState == Menus.GAMEINIT:
        window.fill(Color.LIGHTBLUE)
        drawTextToScreen("RANDOM RPG", window, 100, 20, Color.GREEN, 60)
        drawTextToScreen("RANDOM RPG", window, 103, 25, Color.RED, 60)
        drawTextToScreen("Press space to continue", window, 25, 200, Color.BLACK, 50)
        drawTextToScreen("Press 1 (-) or 2 (+) to edit scaling", window, 100, 375)
        drawTextToScreen(scale.scaleFactor, window, 250, 423, Color.GREEN, 40)
        drawTextToScreen(scale.scaleFactor, window, 253, 425, Color.RED, 40)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    state.currentState = Menus.PLAYGAME
                if event.key == pygame.K_1:
                    if scale.scaleFactor > 0:
                        scale.scaleFactor = scale.scaleFactor - 1
                if event.key == pygame.K_2:
                    scale.scaleFactor = scale.scaleFactor + 1
        updateGameStuff(clock)


def _playGameDisplay(window, state, clock):
    while state == Menus.PLAYGAME:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
        updateGameStuff(clock)


def _playerStatsDisplay(window, state, clock):
    while state == Menus.PLAYERSTATS:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
        updateGameStuff(clock)


def _playerMovesDisplay(window, state, clock):
    while state == Menus.PLAYERMOVES:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
        updateGameStuff(clock)


def _playerLevelUpDisplay(window, state, clock):
    while state == Menus.PLAYERLEVELUP:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
        updateGameStuff(clock)


def _gameOverDisplay(window, state, clock):
    while state == Menus.GAMEOVER:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                safeQuit()
        updateGameStuff(clock)
