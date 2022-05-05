import random

from character import Character


class Player(Character):
    _moveOptions = ["simpleStrike", "meditate", "armorShred", "heal", "manaSiphon", "luckyStrike", "sacrificialStrike",
                    "defensiveForm", "quickAttack", "healingStrike", "halfSlash", "healthSteal", "armorConversion",
                    "luckConversion", "heavyStrike", "ultimateStrike", "bigStrike", "cuttingStrike", "chanceStrike"]

    def __init__(self, name, isHuman=True):
        super().__init__()
        self._isHuman = isHuman
        self.name = name
        self._moveSet = self.randomizeMoveset()

    def randomizeMoveset(self):
        moves = []
        while len(moves) < 4:
            toAdd = self._moveOptions[random.randint(0, 18)]
            if toAdd not in moves:
                moves.append(toAdd)
        return moves

    def getMoves(self):
        return self._moveSet
