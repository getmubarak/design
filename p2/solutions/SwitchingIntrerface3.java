interface IX{
   void fx1();
   void fx2();
   void* Query(int id);
}

interface IY{
   void fy1();
   void fy2();
   void* Query(int id);
}

class CA implements IX, IY {
    void fx1() { ... }
    void fx2() { ... }
    void fy1() { ... }
    void fy2() { ... }
    void* Query(int id){
       if(id == ID_IX)
           return (IX) this;
       if(id == ID_IY)
           return (IY) this;
       return 0;
    }

}

void Main(){
   IX x = new CA();
   x.fx1();
   x.fx2();
   IY y = x.query(ID_IY);
   y.fy1(); 
   y.fy2();
}
