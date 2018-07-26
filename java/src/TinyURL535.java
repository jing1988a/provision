//Note: This is a companion problem to the System Design problem: Design TinyURL.
//        TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
//
//        Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
//
//
//

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;

public class TinyURL535 {


    String frontUrl="http://tinyurl.com/";
    HashMap<String , String> LtoS=new HashMap<>();
    HashMap<String , String> StoL=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(this.StoL.containsKey(longUrl)){
            return this.LtoS.get(longUrl);
        }
        String shortUrl=getRandomString();
        this.LtoS.put(longUrl , shortUrl);
        this.StoL.put(shortUrl , longUrl);
        return this.frontUrl+shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.StoL.get(shortUrl.substring(19));
    }
    private String getRandomString(){
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<6;i++){
            temp.append(getRandomChar());
        }
        return temp.toString();
    }
    private char getRandomChar(){
        String seeds="1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        return seeds.charAt((int)Math.random()*64);
    }
}

