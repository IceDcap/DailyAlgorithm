package com.icedcap.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Encode and Decode TinyURL(M)
 * <p>
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class S535 {
    private Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    public static void main(String[] args) {
        S535 instance = new S535();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = instance.encode(longUrl);
        System.out.println(shortUrl);
        System.out.println(instance.decode(shortUrl));
    }
}
