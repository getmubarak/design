public class Encryptor {
    private String algorithmName;
    private String plainText;
    public Encryptor(String algorithmName){
       this.algorithmName=algorithmName;
   }
    public void encrypt(){
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
   /*Getter and setter methods for plainText*/
        
}
