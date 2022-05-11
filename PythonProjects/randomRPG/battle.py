import abilities


class Battle(object):
    def __init__(self, player, enemy):
        self.player = player
        self.enemy = enemy

    def attack(self, number, user, target):
        moves = user.getMoves()
        move = moves[number]
        ability = getattr(abilities, move)
        print("did:", str(move))
        ability(user, target)
