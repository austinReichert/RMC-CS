import random
import enum


class abilityDescriptions(enum.Enum):
    simpleStrike = "Strikes opponent based off attack and opponent defence (Attack - Defence)",
    meditate = "Regens a random amount of mana (1 - 4 + 10% Max Mana)",
    armorShred = "Low chance (10% Luck + 15%) to shred an opponents defence a random amount (1 + 5% Luck)",
    heal = "Regens a random amount of mana (1 - 4 + 10% Max HP)",
    manaSiphon = "Strikes opponent based on Mana and regens mana a random amount (1 - 1 + 20% CurrentMana)",
    luckyStrike = "Low chance (5 + 30% Luck) to strike for extra damage (50% Luck + 100% Attack)",
    sacrificialStrike = "Strikes opponent for extra (140% attack) after taking recoil (65% attack)",
    defensiveForm = "Low chance (35% Defence + 90% Luck) to gain a random amount of defence (1-3)",
    quickAttack = "Strikes opponent, dealing extra damage if opponent speed is lower (Attack 50% + Speed)",
    healingStrike = "Strikes opponent, healing for the same amount of damage dealt (100% Attack)"
    # x = "".join(abilities.abilityDescriptions.armorShred.value)


class manaCosts(enum.IntEnum):
    simpleStrike = 1,
    meditate = 0,
    armorShred = 4,
    heal = 2,
    manaSiphon = 2,
    luckyStrike = 3,
    sacrificialStrike = 1,
    defensiveForm = 5,
    quickAttack = 1,
    healingStrike = 4


def simpleStrike(user, target):
    if _spendMana(user, manaCosts.simpleStrike):
        strikeDMG = user.attack - target.defence
        if strikeDMG > 0:
            _damage(target, strikeDMG)


def meditate(user):
    if _spendMana(user, manaCosts.meditate):
        amount = random.randint(1, 4 + round(user.maxMP * 0.1))
        _gainMana(user, amount)


def armorShred(user, target):
    if _spendMana(user, manaCosts.armorShred):
        if round(user.luck * 0.1) + 15 > random.randint(0, 100):
            armorShredAmount = round(random.randint(0, 1) + round(user.luck * 0.05))
            if target.defence >= armorShredAmount:
                target.defence = target.defence - armorShredAmount
                _damage(target, armorShredAmount)
            else:
                _damage(target, armorShredAmount)


def heal(user):
    if _spendMana(user, manaCosts.heal):
        amount = random.randint(1, 4 + (round(user.maxHP * 0.1)))
        _gainHealth(user, amount)


def manaSiphon(user, target):
    if _spendMana(user, manaCosts.manaSiphon):
        amount = (random.randint(1, 4 + (round(user.currentMP * 0.2)))) - _calculateDefense(target)
        _damage(target, amount)
        _gainMana(user, amount)


def luckyStrike(user, target):
    if _spendMana(user, manaCosts.luckyStrike):
        if round(user.luck * 0.3) + 5 > random.randint(0, 100):
            _damage(target, round((user.luck * 0.5)) + user.attack - _calculateDefense(target))


def sacrificialStrike(user, target):
    if _spendMana(user, manaCosts.sacrificialStrike):
        _damage(user, round((user.attack * 0.65) - _calculateDefense(user)))
        _damage(target, round((user.attack * 1.4) - _calculateDefense(target)))


def defensiveForm(user):
    if _spendMana(user, manaCosts.defensiveForm):
        if round(user.defence * 0.35) + round(user.luck * 0.9) > random.randint(0, 100):
            user.defence = user.defence + random.randint(1, 3)


def quickAttack(user, target):
    if _spendMana(user, manaCosts.quickAttack):
        if user.speed > target.speed:
            amount = round((user.speed - target.speed) * 1.5 + round(user.attack * 0.5)) - _calculateDefense(target)
            _damage(target, amount)
        else:
            _damage(target, round(user.attack * 0.5) + 1 - _calculateDefense(target))


def healingStrike(user, target):
    if _spendMana(user, manaCosts.healingStrike):
        amount = user.attack - _calculateDefense(target)
        _damage(target, amount)
        _gainHealth(user, amount)

        # functions used for upper functions


def _damage(target, amount):
    if 0 >= (target.currentHP - amount):
        target.currentHP = 0
    else:
        target.currentHP = (target.currentHP - amount)


def _gainHealth(target, amount):
    if target.maxHP <= (target.currentHP + amount):
        target.currentHP = target.maxHP
    else:
        target.currentHP = (target.currentHP + amount)


def _gainMana(target, amount):
    if target.maxMP <= (target.currentMP + amount):
        target.currentMP = target.maxMP
    else:
        target.currentMP = (target.currentMP + amount)


def _spendMana(target, cost):
    if (target.currentMP - cost) >= 0:
        target.currentMP = target.currentMP - cost
        return True
    else:
        return False


# defence only has 6% effect

def _calculateDefense(target):
    return round(target.defence * 0.06)
