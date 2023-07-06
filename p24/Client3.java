class Client{
      public void do(IX ix){
          ix.f1();
          ix.f2();
      }
      public static void main()
      {
          Client client = new Client();
          client.do(new CA());
      }
}

