import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class My_Enc{
    public static void main(String[] args){
        try{
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey myAESKey = kg.generateKey();
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, myAESKey);
             
			byte[] text = "ABCHI5".getBytes();
            System.out.println("Text in bytes :" + text);
            System.out.println("Text : " + new String(text));
            byte[] textEnc = cipher.doFinal(text);
            System.out.println("Text in bytes :" + textEnc);
            System.out.println("Text Encrypted : " + new String(textEnc));
            cipher.init(Cipher.DECRYPT_MODE, myAESKey);

            byte[] textDec = cipher.doFinal(textEnc);
            System.out.println("Text Decrypted: " + new String(textDec));
        } catch(Exception e) { }
	}
}

