package test;

import string_Encrypt_Decrypt.StringEncryptFunction;

public class Test {
	public static void main(String[] args) {
		String plainText = "Le Hoang Nam";
		String keyText = "0399405711";

		String encryptedMsg = StringEncryptFunction.EncryptString(StringEncryptFunction.plainTextToHexString(plainText),
				StringEncryptFunction.plainTextToHexString(keyText));
		String decryptedMsg = StringEncryptFunction.DecryptString(encryptedMsg,
				StringEncryptFunction.plainTextToHexString(keyText));

		System.out.println("Plain text: " + plainText);
		System.out.println("Key text: " + keyText);
		System.out.println("Encrypted message: " + encryptedMsg);
		System.out.println("Decrypted message: " + StringEncryptFunction.hexToString(decryptedMsg));
	}
}
