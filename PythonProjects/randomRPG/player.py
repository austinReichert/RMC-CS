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
        self._level = 0
        self._luck = self.randomize(1, 6)
        self._attack = self.randomize(3, 6)
        self._defence = self.randomize(1, 3)
        self._speed = self.randomize(1, 5)
        self._maxHP = self.randomize(5, 15)
        self._currentHP = self._maxHP
        self._maxMP = self.randomize(6, 10)
        self._currentMP = self._maxMP
        self._scale = 0

    def levelUp(self):
        self.name = self.name
        self.level = self.level + 1
        self.luck = (self.luck + self.randomize(1, 4)) + self.randomize(round(self.scale/5), self.scale)
        self.attack = (self.attack + self.randomize(1, 4)) + self.randomize(round(self.scale/5), self.scale)
        self.defence = (self.defence + self.randomize(1, 4)) + self.randomize(round(self.scale/5), self.scale)
        self.speed = (self.speed + self.randomize(1, 4)) + self.randomize(round(self.scale/5), self.scale)
        self.maxHP = (self.maxHP + self.randomize(2, 10)) + self.randomize(round(self.scale/5), self.scale)
        self.currentHP = self.maxHP
        self.maxMP = (self.maxMP + self.randomize(1, 4)) + self.randomize(round(self.scale/5), self.scale)
        self.currentMP = self.maxMP

    def randomize(self, minNum, maxNum):
        if maxNum == 0:
            return 0
        elif maxNum <= minNum:
            return minNum
        return random.randrange(minNum, maxNum)

    def randomizeMoveset(self):
        moves = []
        while len(moves) < 4:
            toAdd = self._moveOptions[random.randint(0, 18)]
            if toAdd not in moves:
                moves.append(toAdd)
        return moves

    def getMoves(self):
        return self._moveSet

    def generateMoveset(self):
        self._moveSet = self.randomizeMoveset()