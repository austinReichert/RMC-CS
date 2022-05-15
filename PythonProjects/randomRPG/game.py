import enemy
import player
import pygame
import turn

from STATES import title, game, moves, stats, attack, showattack, levelup, gameover


class Game(object):
    def __init__(self):
        self.window = pygame.display.set_mode((640, 480))
        pygame.display.set_caption("RANDOM RPG")
        self.clock = pygame.time.Clock()
        self.player = player.Player()
        self.enemy = enemy.Enemy()
        self.turn = turn.Turn()
        self.states = {
            'Title': title.Title(self.player, self.enemy),
            'Game': game.Game(self.player, self.enemy, self.turn),
            'Moves': moves.Moves(self.player),
            'Stats': stats.Stats(self.player),
            'Attack': attack.Attack(self.player, self.enemy),
            'ShowAttack': showattack.ShowAttack(self.player, self.enemy, self.turn),
            'LevelUp': levelup.LevelUp(self.player, self.enemy, self.turn),
            'GameOver': gameover.GameOver(self.player, self.enemy, self.turn)
        }
        self.stateName = 'Title'
        self.state = self.states[self.stateName]

    def gameLoop(self):
        try:
            while True:
                for event in pygame.event.get():
                    if event.type == pygame.QUIT:
                        pygame.quit()
                        exit()
                    self.state.getEvent(event)
                    self.draw()
                    self.update()
                    self.clock.tick(60)
                    pygame.display.update()
        except KeyboardInterrupt:
            pygame.quit()
            exit()

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