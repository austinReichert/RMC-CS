import random


def simpleStrike(user, target):
    strikeDMG = user.attack - target.defence
    if strikeDMG > 0:
        damage(target, strikeDMG)


def meditate(target, amount):
    if target.maxMP <= (target.currentMP() + amount):
        target.currentMP = target.maxMP
    else:
        target.currentMP = (target.currentMP + amount)


def heal(target, amount):
    if target.maxHP <= (target.currentHP + amount):
        target.currentHP = target.maxHP
    else:
        target.currentHP = target.currentHP + amount


def damage(target, amount):
    if 0 >= (target.currentHP - amount):
        target.currentHP = 0
    else:
        target.currentHP = (target.currentHP - amount)
