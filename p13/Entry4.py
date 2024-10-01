class Ship:
    def collide(self, other):
        # This is Ship
        if isinstance(other, Station):
            # Logic of Ship with Station
            pass
        elif isinstance(other, Comet):
            # Logic of Ship with Comet
            pass
        elif isinstance(other, Asteroid):
            # Logic of Ship with Asteroid
            pass
class Station:
    def collide(self, other):
        # This is Station
        if isinstance(other, Ship):
            # Logic of Ship with Station
            pass
        elif isinstance(other, Comet):
            # Logic of Station with Comet
            pass
        elif isinstance(other, Asteroid):
            # Logic of Station with Asteroid
            pass

class Handler:
    def collide(self, go1, go2):
        go1.collide(go2)