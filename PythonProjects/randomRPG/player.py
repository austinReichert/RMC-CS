from character import Character


class Player(Character):
    def __init__(self, isHuman=True):
        super().__init__()
        self.isHuman = isHuman
