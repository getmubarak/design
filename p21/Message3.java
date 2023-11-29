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
        if (algorithmName.equals("Aes")){
            this.algorithm=new Aes();
        }
       else if (algorithmName.equals("Blowfish")){
           this.algorithm=new BlowFish();
        }
   }
   public string getText(){
        return algorithm.decrypt(text);
   }
   public void setText(String text){
         text = algorithm.encrypt(text);
   }     
}
