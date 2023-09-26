package com.infinite.security;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

 

 

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 

public class TestSecurity {

	private static final Logger logger

    = Logger.getLogger(JavaSecurity.class);


	public static void main(String... a)

	{

		PropertyConfigurator.configure("log4j.properties");

		final String secretKey = "Roshiik";

		String originalString = "mysql@123";

		String encryptedString = JavaSecurity.encrypt(originalString, secretKey) ;

		String decryptedString = JavaSecurity.decrypt(encryptedString, secretKey) ;

		logger.info(originalString);

		logger.info(encryptedString);

		logger.info(decryptedString);

	}

}