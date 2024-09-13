class Ship:
    def collide(self, other):
        other.collide_with_ship(self)

    def collide_with_station(self, station):
        # logic to collide ship and station
        pass

    def collide_with_comet(self, comet):
        # logic to collide ship and comet
        pass

    def collide_with_asteroid(self, asteroid):
        # logic to collide ship and asteroid
        pass

    def collide_with_ship(self, ship):
        # logic to collide ship and ship
        pass


class Comet:
    def collide(self, other):
        other.collide_with_comet(self)

    def collide_with_ship(self, ship):
        # logic to collide comet and ship
        pass

    def collide_with_station(self, station):
        # logic to collide comet and station
        pass

    def collide_with_comet(self, comet):
        # logic to collide comet and comet
        pass

    def collide_with_asteroid(self, asteroid):
        # logic to collide comet and asteroid
        pass


class Handler:
    def collide(self, go1, go2):
        go1.collide(go2)
