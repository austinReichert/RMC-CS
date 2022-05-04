import pygame
from STATES import gameStates


class Game(object):
    def __init__(self):
        self.window = pygame.display.set_mode((640, 480))
        pygame.display.set_caption("RANDOM RPG")
        self.clock = pygame.time.Clock()
        self.states = {
            'Title': gameStates.Title(),
            'Game': gameStates.Game(),
            'Moves': gameStates.Moves(),
            'Stats': gameStates.Stats(),
            'LevelUp': gameStates.LevelUp(),
            'GameOver': gameStates.GameOver()
        }
        self.stateName = 'Title'
        self.state = self.states[self.stateName]

    def gameLoop(self):
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    exit()
                self.state.getEvent(event)
                self.draw()
                self.update()
                pygame.display.update()

    def draw(self):
        self.state.draw(self.window)

    def update(self):
        if self.state.complete:
            if self.state.nextState is None:
                self.stateName = self.state.previousState
            else:
                self.stateName = self.state.nextState
            self.state.complete = False
            data = self.state.data
            self.state = self.states[self.stateName]
            self.state.start(data)
