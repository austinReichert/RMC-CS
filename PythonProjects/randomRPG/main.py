import abilities
import menuHandler
from player import Player
from abilities import manaCosts


def unwrap(array):
    print("Level: {} | Luck: {} | Attack: {} | Defence: {} | Speed: {} | MaxHP: {} | CurrentHP: {} | MaxMP: {} | "
          "CurrentMP: {}".format(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7],
                                 array[8]))


menuHandler.startGame()