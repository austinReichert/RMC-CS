import random


class Character(object):
    def __init__(self):
        self._name = ""
        self._moveSet = []
        self._level = 0
        self._luck = 0
        self._attack = 0
        self._defence = 0
        self._speed = 0
        self._maxHP = 0
        self._currentHP = 0
        self._maxMP = 0
        self._currentMP = 0
        self._scale = 0

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
    def moveSet(self):
        return self._moveSet

    @moveSet.setter
    def moveSet(self, newMoveSet):
        self._moveSet = newMoveSet

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

    @property
    def scale(self):
        return self._scale

    @scale.setter
    def scale(self, newAmount):
        self._scale = newAmount
