/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author charlysama
 */
@Service
@Slf4j
public class Encriptar {
    
 
     @Value("${configuracion.otro}")
        private String otro;
     
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        return enc.encode(password);
    }
    

 private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
 
    public  void encrypt( File inputFile, File outputFile)
            throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, otro, inputFile, outputFile);
    }
 
    public  void decrypt( File inputFile, File outputFile)
            throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, otro, inputFile, outputFile);
    }
 
    private  void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile) throws Exception {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileOutputStream outputStream;
            try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                byte[] inputBytes = new byte[(int) inputFile.length()];
                inputStream.read(inputBytes);
                byte[] outputBytes = cipher.doFinal(inputBytes);
                outputStream = new FileOutputStream(outputFile);
                outputStream.write(outputBytes);
            }
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            log.info(ex.getMessage());
            //throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    
    public void activaArchivo(String f){
        File desactivado = new File(f+".cript");     
        File activado  = new File(f);
         try {
             decrypt( desactivado,activado );
         } catch (Exception ex) {
            log.info(ex.getMessage());
         }
        desactivado.deleteOnExit();
    }
    
     public void desactivaArchivo(String f){
        File desactivado = new File(f+".cript");     
        File activado  = new File(f);
         try {
             encrypt(activado,desactivado );
         } catch (Exception ex) {
            log.info(ex.getMessage());
         }
        activado.deleteOnExit();
    }
    
}
