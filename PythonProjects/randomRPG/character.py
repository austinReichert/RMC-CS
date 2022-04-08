import random


class Character(object):
    def __init__(self):
        self._name = ""
        self._level = 1
        self._luck = self.randomize(1, 10)
        self._attack = self.randomize(1, 10)
        self._defence = self.randomize(1, 10)
        self._speed = self.randomize(1, 5)
        self._maxHP = self.randomize(5, 30)
        self._currentHP = self._maxHP
        self._maxMP = self.randomize(5, 20)
        self._currentMP = self._maxMP

    def randomize(self, minNum, maxNum):
        return random.randrange(minNum, maxNum)

    def levelUp(self, scalingAmount=0):
        self.level = self.level + 1
        self.luck = (self.luck + 1) + scalingAmount
        self.attack = (self.attack + 1) + scalingAmount
        self.defence = (self.defence + 1) + scalingAmount
        self.speed = (self.speed + 1) + scalingAmount
        self.maxHP = (self.maxHP + 1) + scalingAmount
        self.currentHP = self.maxHP
        self.maxMP = (self.maxMP + 1) + scalingAmount
        self.currentMP = self.maxMP

    def getStats(self):
        return [
            self.level,
            self.luck,
            self.attack,
            self.defence,
            self.speed,
            self.maxHP,
            self.currentHP,
            self.maxMP,
            self.currentMP]

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, newName):
        self._name = newName

    @property
    def level(self):
        return self._level

    @level.setter
    def level(self, newLevel):
        self._level = newLevel

    @property
    def luck(self):
        return self._luck

    @luck.setter
    def luck(self, newAmount):
        self._luck = newAmount

    @property
    def attack(self):
        return self._attack

    @attack.setter
    def attack(self, newAmount):
        self._attack = newAmount

    @property
    def defence(self):
        return self._defence

    @defence.setter
    def defence(self, newAmount):
        self._defence = newAmount

    @property
    def speed(self):
        return self._speed

    @speed.setter
    def speed(self, newAmount):
        self._speed = newAmount

    @property
    def maxHP(self):
        return self._maxHP

    @maxHP.setter
    def maxHP(self, newAmount):
        self._maxHP = newAmount

    @property
    def currentHP(self):
        return self._currentHP

    @currentHP.setter
    def currentHP(self, newAmount):
        self._currentHP = newAmount

    @property
    def maxMP(self):
        return self._maxMP

    @maxMP.setter
    def maxMP(self, newAmount):
        self._maxMP = newAmount

    @property
    def currentMP(self):
        return self._currentMP

    @currentMP.setter
    def currentMP(self, newAmount):
        self._currentMP = newAmount
