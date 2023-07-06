class Client{
      public void do(IX ix){
          ix.f1();
          ix.f2();
      }
}
class App
{
      public static void main()
      {
          Client client = new Client();
          client.do(new CA());
      }
}

