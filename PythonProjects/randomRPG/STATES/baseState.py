import pygame.font


class State(object):
    def __init__(self):
        self.previousState = None
        self.nextState = None
        self.complete = False
        self.data = {}
        self.fonts = {
            "title": pygame.font.SysFont('Comic Sans MS', 65),
            "subtitle": pygame.font.SysFont('Comic Sans MS', 40),
            "base": pygame.font.SysFont('Comic Sans MS', 30),
            "tiny": pygame.font.SysFont('Comic Sans MS', 20),
            "mini": pygame.font.SysFont('Comic Sans MS', 10)
        }

    def saveData(self, newData):
        self.data = newData

    def getEvent(self, event):
        pass

    def draw(self, window):
        pass

    def update(self):
        pass

    def start(self, data):
        self.data = data
