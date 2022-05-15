class Turn(object):
    def __init__(self):
        self._turn = 1

    def reset(self):
        self.turn = 1

    @property
    def turn(self):
        return self._turn

    @turn.setter
    def turn(self, amount):
        self._turn = amount
