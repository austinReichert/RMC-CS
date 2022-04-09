import random
import enum


class abilityDescriptions(enum.Enum):
    simpleStrike = "Strikes enemy based off attack and enemy defence (Attack - Defence)",
    meditate = "Regens a random amount of mana (1 - 4 + 10% Max Mana)",
    armorShred = "Low chance (10% Luck + 15%) to shred an enemy's defence a random amount (1 + 5% Luck)",
    heal = "Regens a random amount of mana (1 - 4 + 10% Max HP)",
    manaSiphon = "Strikes enemy based on Mana and regens mana a random amount (1 - 1 + 20% Current Mana)",
    luckyStrike = "Low chance (5 + 30% Luck) to strike for extra damage (50% Luck + 100% Attack)",
    sacrificialStrike = "Strikes enemy for extra (140% attack) after taking recoil (65% attack)",
    defensiveForm = "Low chance (35% Defence + 90% Luck) to gain a random amount of defence (1-3)",
    quickAttack = "Strikes enemy, dealing extra damage if enemy speed is lower (25% Attack + 100% Speed)",
    healingStrike = "Strikes enemy, healing for the same amount of damage dealt (100% Attack)",
    halfSlash = "Low chance (70% Attack + 10%) to strike enemy for half their health (50% Current Health + 20% Attack)",
    healthSteal = "Low chance (30% Max HP + 10%) to steal enemy max hp for random amount (1 - 3 + 15% Max HP)",
    armorConversion = "Convert ALL defence to extra health (Defence * 150% - 250% -> Max HP)",
    luckConversion = "Convert ALL luck to extra mana (Luck * 150% - 300% -> Max Mana)",
    heavyStrike = "Strikes enemy based off defence (Defence * 2)",
    ultimateStrike = "Strikes enemy based off every stat (60% Every stat total)",
    bigStrike = "Chance (16.5% + 100% Luck) to strike enemy for extra damage (145% Attack)",
    cuttingStrike = "Strikes enemy based off their current Health (1 - 2 + 30% Current HP)"

    # x = "".join(abilities.abilityDescriptions.armorShred.value)


class manaCosts(enum.IntEnum):
    simpleStrike = 0,
    meditate = 0,
    armorShred = 4,
    heal = 2,
    manaSiphon = 2,
    luckyStrike = 3,
    sacrificialStrike = 1,
    defensiveForm = 5,
    quickAttack = 0,
    healingStrike = 4,
    halfSlash = 4,
    healthSteal = 3,
    armorConversion = 3,
    luckConversion = 3,
    heavyStrike = 1,
    ultimateStrike = 7,
    bigStrike = 0,
    cuttingStrike = 2


def simpleStrike(user, target):
    if _spendMana(user, manaCosts.simpleStrike):
        _damage(target, (user.attack - target.defence))


def meditate(user):
    if _spendMana(user, manaCosts.meditate):
        amount = random.randint(1, 4 + round(user.maxMP * 0.1))
        _gainMana(user, amount)


def armorShred(user, target):
    if _spendMana(user, manaCosts.armorShred):
        if round(user.luck * 0.1) + 15 > _randomChance():
            amount = round(random.randint(0, 1) + round(user.luck * 0.05))
            if target.defence >= amount:
                target.defence = target.defence - amount
                _damage(target, amount)
            else:
                _damage(target, amount)


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
        if round(user.defence * 0.35) + round(user.luck * 0.9) > _randomChance():
            user.defence = user.defence + random.randint(1, 3)


def quickAttack(user, target):
    if _spendMana(user, manaCosts.quickAttack):
        if user.speed > target.speed:
            amount = round((user.speed - target.speed) * 1.5 + round(user.attack * 0.25)) - _calculateDefense(target)
            _damage(target, amount)
        else:
            _damage(target, round(user.attack * 0.5) + 1 - _calculateDefense(target))


def healingStrike(user, target):
    if _spendMana(user, manaCosts.healingStrike):
        amount = user.attack - _calculateDefense(target)
        _damage(target, amount)
        _gainHealth(user, amount)


def halfSlash(user, target):
    if _spendMana(user, manaCosts.halfSlash):
        if round(user.attack * 0.7) + 10 > _randomChance():
            amount = (round(target.currentHP * 0.5) + round(user.attack * 0.2)) - _calculateDefense(target)
            _damage(target, amount)


def healthSteal(user, target):
    if _spendMana(user, manaCosts.halfSlash):
        if round(user.maxHP * 0.3) + 10 > _randomChance():
            amount = random.randint(1, 3 + round(target.maxHP * 0.15))
            if amount <= target.maxHP:
                target.maxHP = target.maxHP - amount
                user.maxHP = user.maxHP + amount
                if target.maxHP < target.currentHP:
                    target.currentHP = target.maxHP
            else:
                _damage(target, amount)


def armorConversion(user):
    if _spendMana(user, manaCosts.armorConversion):
        if user.defence > 0:
            amount = user.defence
            user.defence = 0
            user.maxHP = user.maxHP + (round(random.uniform(1.5, 2.5)) * amount)


def luckConversion(user):
    if _spendMana(user, manaCosts.luckConversion):
        if user.luck > 0:
            amount = user.luck
            user.luck = 0
            user.maxMP = user.maxMP + (round(random.uniform(1.5, 3)) * amount)


def heavyStrike(user, target):
    if _spendMana(user, manaCosts.heavyStrike):
        amount = round(user.defence * 2) - _calculateDefense(target)
        _damage(target, amount)


def ultimateStrike(user, target):
    if _spendMana(user, manaCosts.ultimateStrike):
        amount = round((user.level + user.luck + user.attack + user.defence + user.speed + user.currentHP
                        + user.currentMP) * 0.6) - _calculateDefense(target)
        _damage(target, amount)


def bigStrike(user, target):
    if _spendMana(user, manaCosts.bigStrike):
        if round(16.5 + user.luck) > _randomChance():
            amount = round(user.attack * 1.45) - _calculateDefense(target)
            _damage(target, amount)


def cuttingStrike(user, target):
    if _spendMana(user, manaCosts.cuttingStrike):
        amount = round(random.uniform(1, 2 + (target.currentHP * 0.3)))
        print(amount)
        _damage(target, amount)


# functions used for upper functions
def _damage(target, amount):
    if amount > 0:
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


def _randomChance():
    return random.randint(0, 100)


# defence only has 5.5% effect

def _calculateDefense(target):
    return round(target.defence * 0.055)
