

interface Encryption{
  void encrypt(string data);
  string decrypt(string cipher);
}

class Aes implements Encryption{ ... }
class BlowFish implements Encryption{ ... }

public class Message {
    private Encryption algorithm;
    private String text;
    public Message(Encryption algorithm){
       this.algorithm=algorithm;
   }
   public string getText(){
        return algorithm.decrypt(text);
   }
   public void setText(String text){
         text = algorithm.encrypt(text);
   }     
}
