import random

from character import Character


class Player(Character):
    _moveOptions = ["simpleStrike", "meditate", "armorShred", "heal", "manaSiphon", "luckyStrike", "sacrificialStrike",
                    "defensiveForm", "quickAttack", "healingStrike", "halfSlash", "healthSteal", "armorConversion",
                    "luckConversion", "heavyStrike", "ultimateStrike", "bigStrike", "cuttingStrike", "chanceStrike"]

    def __init__(self, isHuman=True):
        super().__init__()
        self._isHuman = isHuman
        self.moveSet = self.randomizeMoveset()

    def randomizeMoveset(self):
        moves = []
        for i in range(4):
            moves.append(self._moveOptions[random.randint(0, 18)])
        return moves
