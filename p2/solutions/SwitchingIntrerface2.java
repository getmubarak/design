interface IP{}

interface IX extends IP{
   void fx1();
   void fx2();
}

interface IY extends IP{
   void fy1();
   void fy2();
}

class CA implements IX, IY {
    void fx1() { ... }
    void fx2() { ... }
    void fy1() { ... }
    void fy2() { ... }
}

void Main(){
   IP p = new CA();
   IX x = (IX) p;
   x.fx1();
   x.fx2();
   IY y = (IY) p;
   y.fy1();
   y.fy2();
}
