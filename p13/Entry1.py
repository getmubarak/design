class Handler:
    def collide(self, obj1, obj2):
        if isinstance(obj1, Ship) and isinstance(obj2, Station):
            # logic1
            pass
        elif isinstance(obj1, Station) and isinstance(obj2, Asteroid):
            # logic2
            pass
        elif isinstance(obj1, Ship) and isinstance(obj2, Comet):
            # logic3
            pass
