package LeetCode.LC_401_600.LC535;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/**
 * Solution: random fixed length encoding.
 */
public class Solution {
    public class Codec {
        int len = 6;
        String baseUrl = "http://tinyurl.com/";
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String key = getKey();
        Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            while(map.containsKey(key)) {
                key = getKey();
            }
            map.put(key, longUrl);
            return baseUrl + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String key = shortUrl.replace(baseUrl, "");
            return map.get(key);
        }

        private String getKey() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len; i++) {
                int idx = random.nextInt(alphabet.length());
                sb.append(alphabet.charAt(idx));
            }
            return sb.toString();
        }
    }
}
