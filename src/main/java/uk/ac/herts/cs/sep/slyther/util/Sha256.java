package uk.ac.herts.cs.sep.slyther.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.common.hash.Hashing;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author comqdhb
 */
public class Sha256 {

        public Sha256() throws InstantiationException {
        throw new InstantiationException("You do not need to create an instance of this class to use it.");
    }
    
    public static String hashString(String text) {
        String encoded = text;
        
        byte[] encodedHash = Hashing.sha256().hashString(encoded, StandardCharsets.UTF_8).asBytes();
                
        encoded = bytesToHex(encodedHash);
        
        return encoded;
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
