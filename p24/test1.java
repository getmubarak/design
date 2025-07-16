//------------- Library -------------
public interface Account{
      void withdraw();
      void deposit();
}
class AccountImp implements Account
{
    public void withdraw() { //logic
    }
    public void deposit()  { //logic
    }
}
public class AccountFactory{
      Account getInstance(){
           return new AccountImp();       
      }
}
//------------- Library Consumer -------------
class Client
{
      public static void main()
      {
          AccountFactory f= new AccountFactory();
          Account obj = f.getInstance();
          obj.withdraw();
          obj.deposit();
      }
}
