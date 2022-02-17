interface IX{
      void f1();
      void f2();
}
class CA implements IX{
      ...
}
class IXFactory{
      IX getInstance(){
           return new CA();       
      }
}
//=================================
class Client
{
      public static void main()
      {
          IXFactory f= new IXFactory();
          IX obj = f.getInstance();
          obj.f1();
          obj.f2();
      }
}
