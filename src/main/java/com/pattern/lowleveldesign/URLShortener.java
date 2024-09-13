package com.pattern.lowleveldesign;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class URLShortener {

    @Autowired
    private URLDetailsRepo urlDetailsRepo;

    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


//    public static void main(String[] args) {
//        //Convert a long URL into short URL using base62 encoding
//
//        String longURL = "https://techtutort.com/index.php/2023/12/31/java-tutorial/";
//
//        System.out.println(convertToShortURL(longURL));
//        System.out.println(encode(100));
//    }

    //Here randome will give us a number between 0 - 62 everytime to get unique char
    public String convertToShortURL(String longURL) {

        Random random = new Random();
        StringBuilder shortUrlId = new StringBuilder();

        // Generate a random number of sufficient length
        //Here we have 7 as length for short URL
        for (int i = 0; i < 6; i++) {  // Adjust length as needed
            shortUrlId.append(BASE62_CHARS.charAt(random.nextInt(BASE62_CHARS.length())));
        }

        // Store the long URL and short URL ID in a database or mapping (not shown here)
        URLDetails urlDetails = new URLDetails();
        urlDetails.setLongURL(longURL);
        urlDetails.setShortURL(shortUrlId.toString());
        urlDetails.setCreatedAt(new Date().getTime());

        //In real application it will come from user table
        urlDetails.setUserId(1L);

        urlDetailsRepo.save(urlDetails);
        return shortUrlId.toString();
    }


    //Here divide and remainder operations are used
    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = (int)(num % 62);
            sb.append(BASE62_CHARS.charAt(remainder));
            num /= 62;
        }
        return sb.reverse().toString();
    }

    //for passing string in encode method , we need to convert internally string into long
    //for that different algoritms like SHA256 can be used

    public static long decode(String str) {
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = BASE62_CHARS.indexOf(str.charAt(i));
            num = num * 62 + digit;
        }
        return num;
    }
}
