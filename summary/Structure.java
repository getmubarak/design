interface IX{
  void f();
}
class CA implements IX{
  void f() { ... }
}
//-----------------------------------
class Wrapper implements IX{
  CA ref = new CA();
  void f() { ref.f(); }  <-- enrich behaviour
}
//-----------------------------------
interface IY{
  void f2() { ... } 
}
class Wrapper implements IY{ <-- rename behaviour
  CA ref = new CA();
  void f2() { ref.f(); }
}
//-----------------------------------
interface IX{
}
class CA implements IX {}
class CB implements IX {}
class CC extends CA{ }
class CD extends CA{ }
class CE extends CB{ }
class CF extends CB{ }
//----------------------------------
interface IX{
}
class CA implements IX {}
class CB implements IX {}

interface IY{
}
class CC implements IY{ }
class CD implements IY{ }


