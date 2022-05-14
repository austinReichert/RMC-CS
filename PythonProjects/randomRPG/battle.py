import abilities


def attack(number, user, target):
    moves = user.moveSet
    move = moves[number]
    ability = getattr(abilities, move)
    attackAmount = ability(user, target)
    print("USER:{} | TARGET:{} -- DID {} FOR {} DMG". format(user.name, target.name, str(ability), attackAmount))
    return attackAmount
