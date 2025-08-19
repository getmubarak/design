public class EncryptedMessage {
    private String algorithmName;
    private String text;
    public EncryptedMessage(String algorithmName){
       this.algorithmName=algorithmName;
   }
   public string getText(){
        return decrypt(text);
   }
   public void setText(String text){
         this.text = encrypt(text);
   }
   private string encrypt(String data){
        if (algorithmName.equals("Aes")){
            System.out.println("Encrypting data using AES algorithm");
            /*Code to encrypt data using AES algorithm*/
        }
       else if (algorithmName.equals("Blowfish")){
            System.out.println("Encrypting data using Blowfish algorithm");
            /*Code to encrypt data using Blowfish algorithm */
        }
        /*More else if statements for other encryption algorithms*/
   }
    private String decrypt(String data){
        if (algorithmName.equals("Aes")){
            System.out.println("Decrypting cipher using AES algorithm");
            /*Code to decrypt data using AES algorithm*/
        }
       else if (algorithmName.equals("Blowfish")){
            System.out.println("Decrypting cipher using Blowfish algorithm");
            /*Code to decrypt data using Blowfish algorithm */
        }
        /*More else if statements for other encryption algorithms*/
    }     
}
