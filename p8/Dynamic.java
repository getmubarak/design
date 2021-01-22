class CA{
}
class CB {
}
---------------------------------
class CC extends ? { <--- change or choose parent at runtime
}
---------------------------------
class CC extends CA { <-- lazy load the parent
}
---------------------------------
class CC extends CA , CB { <-- multiple parent
}
