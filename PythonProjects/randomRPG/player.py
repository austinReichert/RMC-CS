import random

from character import Character


class Player(Character):
    _moveOptions = ["simpleStrike", "meditate", "armorShred", "heal", "manaSiphon", "luckyStrike", "sacrificialStrike",
                    "defensiveForm", "quickAttack", "healingStrike", "halfSlash", "healthSteal", "armorConversion",
                    "luckConversion", "heavyStrike", "ultimateStrike", "bigStrike", "cuttingStrike", "chanceStrike",
                    "wait", "randomMove"]

    def __init__(self):
        super().__init__()
        self.name = "Player"
        self.randomizeMoveset()
        self._level = 0
        self._luck = self.randomize(1, 6)
        self._attack = self.randomize(1, 4)
        self._defence = self.randomize(1, 5)
        self._speed = self.randomize(1, 5)
        self._maxHP = self.randomize(5, 20)
        self._currentHP = self._maxHP
        self._maxMP = self.randomize(4, 8)
        self._currentMP = self._maxMP
        self._scale = 0

    def levelUp(self):
        self.level = self.level + 1
        self.luck = (self.luck + self.randomize(1, self.level)) + self.randomize(round(self.scale / 3), self.scale)
        self.attack = (self.attack + self.randomize(1, self.level)) + self.randomize(round(self.scale / 8), round(self.scale/2))
        self.defence = (self.defence + self.randomize(1, self.level)) + self.randomize(round(self.scale / 4),
                                                                                       self.scale)
        self.speed = (self.speed + self.randomize(1, self.level)) + self.randomize(round(self.scale / 3), self.scale)
        self.maxHP = (self.maxHP + self.randomize(2, 10)) + self.randomize(round(self.scale / 2), self.scale)
        self.currentHP = self.maxHP
        self.maxMP = (self.maxMP + self.randomize(1, 3)) + self.randomize(round(self.scale / 16), round(self.scale / 8))
        self.currentMP = self.maxMP
        self.generateMoveset()

    def reset(self):
        self.level = 0
        self.luck = self.randomize(1, 6)
        self.attack = self.randomize(1, 4)
        self.defence = self.randomize(1, 5)
        self.speed = self.randomize(1, 5)
        self.maxHP = self.randomize(5, 20)
        self.currentHP = self.maxHP
        self.maxMP = self.randomize(4, 8)
        self.currentMP = self.maxMP
        self.scale = 0

    def randomize(self, minNum, maxNum):
        if maxNum == 0:
            return 0
        elif maxNum <= minNum:
            return minNum
        return random.randrange(minNum, maxNum)

    def randomizeMoveset(self):
        moves = []
        while len(moves) < 4:
            toAdd = self._moveOptions[random.randint(0, len(self._moveOptions) - 1)]
            if toAdd not in moves:
                moves.append(toAdd)
        return moves

    def generateMoveset(self):
        self.moveSet = self.randomizeMoveset()
