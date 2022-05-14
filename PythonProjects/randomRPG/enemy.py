import random
import abilities
from character import Character


class Enemy(Character):
    _moveOptions = ["simpleStrike", "meditate", "armorShred", "heal", "manaSiphon", "luckyStrike", "sacrificialStrike",
                    "defensiveForm", "quickAttack", "healingStrike", "halfSlash", "healthSteal", "armorConversion",
                    "luckConversion", "heavyStrike", "ultimateStrike", "bigStrike", "cuttingStrike", "chanceStrike"]

    def __init__(self):
        super().__init__()
        self.name = self.generateName()
        self._moveSet = self.randomizeMoveset()
        self._level = 0
        self._luck = self.randomize(1, 7)
        self._attack = self.randomize(1, 5)
        self._defence = self.randomize(1, 6)
        self._speed = self.randomize(1, 6)
        self._maxHP = self.randomize(5, 21)
        self._currentHP = self._maxHP
        self._maxMP = self.randomize(4, 10)
        self._currentMP = self._maxMP
        self._scale = 0

    def levelUp(self, player):
        while self.level < player.level:
            self.level = self.level + 1
            self.luck = (self.luck + self.randomize(1, self.level)) + self.randomize(round(self.scale / 3), self.scale)
            self.attack = (self.attack + self.randomize(1, self.level)) + self.randomize(round(self.scale / 8),
                                                                                         self.scale)
            self.defence = (self.defence + self.randomize(1, self.level)) + self.randomize(round(self.scale / 3),
                                                                                           self.scale)
            self.speed = (self.speed + self.randomize(1, self.level)) + self.randomize(round(self.scale / 3),self.scale)
            self.maxHP = (self.maxHP + self.randomize(2, 10)) + self.randomize(round(self.scale / 2), self.scale)
            self.maxMP = (self.maxMP + self.randomize(1, 3)) + self.randomize(round(self.scale / 15), round(self.scale/2))
        self.currentHP = self.maxHP
        self.currentMP = self.maxMP
        self.name = self.generateName()

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

    def generateName(self):
        names = ["Kevin", "Cryptpaw", "Shade", "Hauntsoul", "Rotwing", "Crabman", "Moldtaur", "Handvine", "Spiteling", "Lich", "Firepaw", "Dogbot", "Wraith", "Blaze", "Rotclaw", "Umbrah", "Armorpaw", "Goblin", "Catten", "Obu", "Red Slime", "Gauss", "Dozar", "Iago", "Ink Eel", "Prowler", "Slurpem", "Python", "Boombat", "Darkpaw", "Eyecell"]
        name = names[random.randint(0, (len(names)-1))]
        return name

    def mainLogic(self, player):
        moveSet = self.getMoves()
        moveNumber = self.offenseLogic(moveSet)
        if moveNumber is None:
            moveNumber = self.defenceLogic(moveSet)
        if moveNumber is None:
            moveNumber = random.randint(0, 3)
        return moveNumber

    def offenseLogic(self, moveSet):
        attackMoves = ["simpleStrike", "armorShred", "manaSiphon", "luckyStrike", "sacrificialStrike", "quickAttack",
                       "healingStrike", "halfSlash", "healthSteal", "heavyStrike", "ultimateStrike", "bigStrike",
                       "cuttingStrike", "chanceStrike"]
        moveNumber = None
        return moveNumber

    def defenceLogic(self, moveSet):
        supportMoves = ["meditate", "heal", "defensiveForm", "armorConversion", "luckConversion"]
        moveNumber = None
        return moveNumber
