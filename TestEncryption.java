package com.example.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class TestEncryption {
	private static final String CIPHER_TRANSFORMATION="AES/CBC/PKCS5Padding";
	private static final String AES_ENCRYPTION="AES";
	private static final String UTF ="UTF-8";
	public static void main(String[] args) {
		String gstin="abcccca122344";
		
		if(gstin==null||gstin=="") {
			System.out.println("IS EMPTY");
		}else {
			try {
				String keyString="abcdefghijs122212344567dssawdaaF";
				String ivString ="123456AAA1234567";
				SecretKeySpec key= new SecretKeySpec(keyString.getBytes(UTF),AES_ENCRYPTION);
				IvParameterSpec iv = new IvParameterSpec(ivString.getBytes(UTF));
				Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
				cipher.init(cipher.ENCRYPT_MODE, key,iv);
				byte[] encryptedBytes= cipher.doFinal(gstin.getBytes(UTF));
				String encryptedString= java.util.Base64.getEncoder().encodeToString(encryptedBytes);
				System.out.println(encryptedString);
				Cipher cipherDecrypt=Cipher.getInstance(CIPHER_TRANSFORMATION);
				cipherDecrypt.init(cipher.DECRYPT_MODE, key,iv);
				byte[] decryptBytes =cipherDecrypt.doFinal(java.util.Base64.getDecoder().decode(encryptedString.getBytes(UTF)));
				String decodedString = new String(decryptBytes,UTF);
				System.out.println(decodedString);
					
 			}catch(Exception e) {
 				e.printStackTrace();
 				System.out.println(e.getMessage());
			}
		}
		
	}

}
