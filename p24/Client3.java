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
# CA should be a public class in the library
client.do(new CA());
client.do(new(sizeof(CA))); .. sizeof is compiletime operator
client.do(new(24));
