# library
public interface Account{
      void withdraw();
      void deposit();
}
public class AccountImp implements Account
{
    public void withdraw() { //logic
    }
    public void deposit()  { //logic
    }
}

#client

class Client
{
      public static void main()
      {
          Account acc = new AccountImp();
          acc.withdraw();
          acc.deposit();
      }
}
