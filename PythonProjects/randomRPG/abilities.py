import random


class abilityDescriptions(object):
    descriptions = {
        "simpleStrike": "Strikes enemy based off attack and enemy defence (Attack - Defence)",
        "meditate": "Regens a random amount of mana (1 - 4 + 10% Max Mana)",
        "armorShred": "Low chance (10% Luck + 15%) to shred an enemy's defence a random amount (1 + 5% Luck)",
        "heal": "Regens a random amount of health (1 - 4 + 15% Max HP)",
        "manaSiphon": "Strikes enemy based on Mana and regens mana a random amount (1 - 1 + 20% Current Mana)",
        "luckyStrike": "Low chance (5% + 30% Luck) to strike for extra damage (50% Luck + 100% Attack)",
        "sacrificialStrike": "Strikes enemy for extra (150% attack) after taking recoil (65% attack)",
        "defensiveForm": "Low chance (35% Defence + 90% Luck) to gain a random amount of defence (1-3)",
        "quickAttack": "Strikes enemy, dealing extra damage if enemy speed is lower (25% Attack + 100% Speed)",
        "healingStrike": "Strikes enemy, healing for the same amount of damage dealt (100% Attack)",
        "halfSlash": "Low chance (70% Attack + 10%) to strike enemy for half their health (50% Current Health + 20% Attack)",
        "healthSteal": "Low chance (30% Max HP + 10%) to steal enemy max hp for random amount (1 - 3 + 15% Max HP)",
        "armorConversion": "Convert ALL defence to extra health (Defence * 150% - 250% -> Max HP)",
        "luckConversion": "Convert ALL luck to extra mana (Luck * 150% - 300% -> Max Mana)",
        "heavyStrike": "Strikes enemy based off defence (Defence * 2)",
        "ultimateStrike": "Strikes enemy based off every stat (60% Every stat total)",
        "bigStrike": "Chance (16.5% + 100% Luck) to strike enemy for extra damage (145% Attack)",
        "cuttingStrike": "Strikes enemy based off their current Health (1 - 2 + 30% Current HP)",
        "chanceStrike": "Chance (30% + 100% Luck) to strike enemy for extra damage. Misses heal the opponent (110% Attack)",
        "wait": "Does literally nothing"
    }

    # x = "".join(abilities.abilityDescriptions.armorShred.value)


class manaCosts:
    costs = {
        "simpleStrike": 2,
        "meditate": 0,
        "armorShred": 6,
        "heal": 2,
        "manaSiphon": 4,
        "luckyStrike": 5,
        "sacrificialStrike": 2,
        "defensiveForm": 6,
        "quickAttack": 2,
        "healingStrike": 6,
        "halfSlash": 7,
        "healthSteal": 4,
        "armorConversion": 6,
        "luckConversion": 6,
        "heavyStrike": 2,
        "ultimateStrike": 12,
        "bigStrike": 2,
        "cuttingStrike": 4,
        "chanceStrike": 2,
        "wait": 0
    }


def simpleStrike(user, target):
    if _spendMana(user, manaCosts.costs["simpleStrike"]):
        attackAmount = round(user.attack - target.defence)
        if attackAmount < 0:
            attackAmount = 0
        _spendHealth(target, attackAmount)
        return attackAmount
    else:
        return 0


def meditate(user, target=None):
    if _spendMana(user, manaCosts.costs['meditate']):
        amount = random.randint(1, 4 + round(user.maxMP * 0.1))
        _gainMana(user, amount)
        return amount
    else:
        return 0


def armorShred(user, target):
    if _spendMana(user, manaCosts.costs['armorShred']):
        if round(user.luck * 0.1) + 15 > _randomChance():
            amount = round(random.randint(0, 1) + round(user.luck * 0.05))
            if target.defence >= amount:
                target.defence = target.defence - amount
                _spendHealth(target, amount)
            else:
                _spendHealth(target, amount)
            return amount
        else:
            return 0
    else:
        return 0


def heal(user, target=None):
    if _spendMana(user, manaCosts.costs['heal']):
        amount = random.randint(1, 4 + (round(user.maxHP * 0.15)))
        _gainHealth(user, amount)
        return amount
    else:
        return 0


def manaSiphon(user, target):
    if _spendMana(user, manaCosts.costs['manaSiphon']):
        amount = (random.randint(1, 4 + (round(user.currentMP * 0.2)))) - _calculateDefense(target)
        _spendHealth(target, amount)
        _gainMana(user, amount)
        return amount
    else:
        return 0


def luckyStrike(user, target):
    if _spendMana(user, manaCosts.costs['luckyStrike']):
        if round(user.luck * 0.3) + 5 > random.randint(0, 100):
            amount = (round((user.luck * 0.5)) + user.attack - _calculateDefense(target))
            _spendHealth(target, amount)
            return amount
        else:
            return 0
    else:
        return 0


def sacrificialStrike(user, target):
    if _spendMana(user, manaCosts.costs['sacrificialStrike']):
        amount = round((user.attack * 1.5) - _calculateDefense(target))
        _spendHealth(user, round((user.attack * 0.65) - _calculateDefense(user)))
        _spendHealth(target, amount)
        return amount
    else:
        return 0


def defensiveForm(user, target=None):
    if _spendMana(user, manaCosts.costs['defensiveForm']):
        if round(user.defence * 0.35) + round(user.luck * 0.9) > _randomChance():
            amount = random.randint(1, 3)
            user.defence = user.defence + amount
            return amount
        else:
            return 0
    else:
        return 0


def quickAttack(user, target):
    if _spendMana(user, manaCosts.costs['quickAttack']):
        if user.speed > target.speed:
            amount = round((user.speed - target.speed) * 1.5 + round(user.attack * 0.25)) - _calculateDefense(target)
        else:
            amount = round(user.attack * 0.5) + 1 - _calculateDefense(target)
        _spendHealth(target, amount)
        return amount
    else:
        return 0


def healingStrike(user, target):
    if _spendMana(user, manaCosts.costs['healingStrike']):
        amount = user.attack - _calculateDefense(target)
        _spendHealth(target, amount)
        _gainHealth(user, amount)
        return amount
    else:
        return 0


def halfSlash(user, target):
    if _spendMana(user, manaCosts.costs['halfSlash']):
        if round(user.attack * 0.7) + 10 > _randomChance():
            amount = (round(target.currentHP * 0.5) + round(user.attack * 0.2)) - _calculateDefense(target)
            _spendHealth(target, amount)
            return amount
        else:
            return 0
    else:
        return 0


def healthSteal(user, target):
    if _spendMana(user, manaCosts.costs['healthSteal']):
        if round(user.maxHP * 0.3) + 10 > _randomChance():
            amount = random.randint(1, 3 + round(target.maxHP * 0.15))
            if amount <= target.maxHP:
                target.maxHP = target.maxHP - amount
                user.maxHP = user.maxHP + amount
                if target.maxHP < target.currentHP:
                    target.currentHP = target.maxHP
            else:
                _spendHealth(target, amount)
            return amount
        else:
            return 0
    else:
        return 0


def armorConversion(user, target=None):
    if _spendMana(user, manaCosts.costs['armorConversion']):
        if user.defence > 0:
            amount = user.defence
            user.defence = 0
            user.maxHP = user.maxHP + (round(random.uniform(1.5, 2.5)) * amount)
            return amount
        else:
            return 0
    else:
        return 0


def luckConversion(user, target=None):
    if _spendMana(user, manaCosts.costs['luckConversion']):
        if user.luck > 0:
            amount = round(random.uniform(1.5, 3)) * user.luck
            user.luck = 0
            user.maxMP = user.maxMP + amount
            return amount
        else:
            return 0
    else:
        return 0


def heavyStrike(user, target):
    if _spendMana(user, manaCosts.costs['heavyStrike']):
        amount = round(user.defence * 2) - _calculateDefense(target)
        _spendHealth(target, amount)
        return amount
    else:
        return 0


def ultimateStrike(user, target):
    if _spendMana(user, manaCosts.costs['ultimateStrike']):
        amount = round((user.level + user.luck + user.attack + user.defence + user.speed + user.currentHP
                        + user.currentMP) * 0.6) - _calculateDefense(target)
        _spendHealth(target, amount)
        return amount
    else:
        return 0


def bigStrike(user, target):
    if _spendMana(user, manaCosts.costs['bigStrike']):
        if round(16.5 + user.luck) > _randomChance():
            amount = round(user.attack * 1.45) - _calculateDefense(target)
            _spendHealth(target, amount)
            return amount
        else:
            return 0
    else:
        return 0


def cuttingStrike(user, target):
    if _spendMana(user, manaCosts.costs['cuttingStrike']):
        amount = round(random.uniform(1, 2 + (target.currentHP * 0.3)))
        _spendHealth(target, amount)
        return amount
    else:
        return 0


def chanceStrike(user, target):
    if _spendMana(user, manaCosts.costs['chanceStrike']):
        amount = round(user.attack * 1.1) - _calculateDefense(target)
        if (30 + user.luck) > _randomChance():
            _spendHealth(target, amount)
        else:
            _gainHealth(target, amount)
        return amount
    else:
        return 0


def wait(user, target=None):
    if _spendMana(user, manaCosts.costs['wait']):
        amount = random.randint(0, 9000)
        return amount
    else:
        return 0


# turn functions

def passiveMana(target):
    amount = round(random.randint(1, target.level))
    _gainMana(target, amount)


def turnDecay(target, turn):
    amount = round(target.maxHP * ((turn - 30) * 0.045))
    _spendHealth(target, amount)


# functions used for upper functions
def _spendHealth(target, amount):
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
