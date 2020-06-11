
single dispatch polymorphism
--------------------------
obj.fun() -> 1| 2| 3

dual dispatch polymorphism
-----------------------------
(obj1,obj2).fun() -> 1 |2 | 3

1. objects belong to different families -> visitor
2. objects belong to same family -> lookup


multi dispatch polymorphism
-----------------------------
(obj1,obj2,...,objn).fun() -> 1 |2 | 3
