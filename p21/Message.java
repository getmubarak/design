public class Message {
    private String algorithmName;
    private String text;
    public Message(String algorithmName){
       this.algorithmName=algorithmName;
   }
   public string getText(String key){
        return decrypt(key);
   }
   public void setText(String key){
         encrypt(key);
   }
   private void encrypt(String key){
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
    private void decrypt(String key){
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
