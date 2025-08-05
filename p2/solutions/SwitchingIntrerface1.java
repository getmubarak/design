interface IX{
   void fx1();
   void fx2();
}

interface IY{
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
   IX x = new CA();
   x.fx1();
   x.fx2();

    
}
