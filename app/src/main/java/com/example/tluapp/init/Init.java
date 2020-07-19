package com.example.tluapp.init;

import org.jsoup.nodes.Element;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Init {

    public static void checkElement(String name, Element element){
        if (element == null){
            throw new RuntimeException("Unable to find " + name);
        }
    }

    public static String getMD5(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();

        for (byte b : hashInBytes){
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }


}
