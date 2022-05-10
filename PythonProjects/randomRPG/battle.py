import abilities


class Battle(object):
    def __init__(self, player, enemy):
        self.player = player
        self.enemy = enemy

    def findFirst(self):
        if self.player.speed > self.enemy.speed:
            return self.player
        elif self.player.speed < self.enemy.speed:
            return self.enemy
        else:
            return self.player

    def attack(self, number, user, target):
        moves = user.getMoves()
        move = moves[number]
        ability = getattr(abilities, move)
        ability(user, target)
