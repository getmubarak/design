

interface Encryption{
  byte[] encrypt(string data);
  string decrypt(byte[] cipher);
}
public class EncryptedMessage {
    private Encryption algorithm;
    private byte[] text;
    public EncryptedMessage(Encryption algorithm){
       this.algorithm=algorithm;
   }
   public string getText(){
        return algorithm.decrypt(text);
   }
   public void setText(String text){
         text = algorithm.encrypt(text);
   }     
}
//*******************************************
class Aes implements Encryption{
  byte[] encrypt(string data){
      System.out.println("Encrypting data using AES algorithm");
      /*Code to encrypt data using AES algorithm*/
  }
  string decrypt(byte[] cipher){
        System.out.println("Decrypting cipher using AES algorithm");
        /*Code to decrypt data using AES algorithm*/
  }
}
class BlowFish implements Encryption{ 
  byte[] encrypt(string data){
     System.out.println("Encrypting data using Blowfish algorithm");
     /*Code to encrypt data using Blowfish algorithm */
  }
  string decrypt(byte[] cipher){
      System.out.println("Decrypting cipher using Blowfish algorithm");
      /*Code to decrypt data using Blowfish algorithm */
  }
}
//*******************************************
EncryptedMessage message = new EncryptedMessage(new BlowFish());
message.setText("hello");
...
