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

class Client{
      public void do(Account acc){
          acc.withdraw();
          acc.deposit();
      }
      public static void main()
      {
          Client client = new Client();
          client.do(new AccountImp());
      }
}

