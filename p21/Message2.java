

interface Encryption{
  void encrypt(string data);
  string decrypt(string cipher);
}

class Aes implements Encryption{
  void encrypt(string data){
      System.out.println("Encrypting data using AES algorithm");
      /*Code to encrypt data using AES algorithm*/
  }
  string decrypt(string cipher){
        System.out.println("Decrypting cipher using AES algorithm");
        /*Code to decrypt data using AES algorithm*/
  }
}
class BlowFish implements Encryption{ 
  void encrypt(string data){
     System.out.println("Encrypting data using Blowfish algorithm");
     /*Code to encrypt data using Blowfish algorithm */
  }
  string decrypt(string cipher){
      System.out.println("Decrypting cipher using Blowfish algorithm");
      /*Code to decrypt data using Blowfish algorithm */
  }
}

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
