
class Aes { 
  public static void encrypt(string data) { ... }
  public staic string decrypt(string cipher) { ... }
}
class BlowFish { 
  public static void encrypt(string data) { ... }
  public staic string decrypt(string cipher) { ... }
}
public class Message {
    private Encryption algorithmName;
    private String text;
   
   public string getText(){
        if (algorithmName.equals("Aes")){
            return Aes.decrypt(text);;
        }
       else if (algorithmName.equals("Blowfish")){
          return BlowFish.decrypt(text);;
        } 
   }
   public void setText(String text){
        if (algorithmName.equals("Aes")){
            text =  Aes.encrypt(text);;
        }
       else if (algorithmName.equals("Blowfish")){
          text =  BlowFish.encrypt(text);;
        } 
   }     
}
