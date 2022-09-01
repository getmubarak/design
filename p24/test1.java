//------------- Library -------------
public interface IX{
      void f1();
      void f2();
}
internal class CA implements IX{
      ...
}
public class IXFactory{
      IX getInstance(){
           return new CA();       
      }
}
//------------- Consumer -------------
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
