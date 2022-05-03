
class scaleFactor(object):
    def __init__(self, default=0):
        self._scaleFactor = default

    @property
    def scaleFactor(self):
        return self._scaleFactor

    @scaleFactor.setter
    def scaleFactor(self, amount):
        self._scaleFactor = amount
