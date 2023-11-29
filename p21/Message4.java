interface Encryption{
  void encrypt(string data);
  string decrypt(string cipher);
}

class Aes implements Encryption{ ... }
class BlowFish implements Encryption{ ... }

public class Message {
    private Encryption algorithm;
    private String text;
    public Message(string algo){
        EncryptionFactory factory = new EncryptionFactory();
        this.algorithm=factory.create(algo);
   }
   public string getText(){
        return algorithm.decrypt(text);
   }
   public void setText(String text){
         text = algorithm.encrypt(text);
   }     
}
class EncryptionFactory{
  Encryption create(string algo){
        if (algo.equals("Aes")){
            return new Aes();
        }
       else if (algo.equals("Blowfish")){
           return new BlowFish();
        }
        return null;
   }
}
