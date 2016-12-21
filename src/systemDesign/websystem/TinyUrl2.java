package systemDesign.websystem;

import java.util.HashMap;

/*
As a follow up for Tiny URL, we are going to support custom tiny url, so that user can create their own tiny url.

Custom url may have more than 6 characters in path.

Have you met this question in a real interview? Yes
Example
createCustom("http://www.lintcode.com/", "lccode")
>> http://tiny.url/lccode
createCustom("http://www.lintcode.com/", "lc")
>> error
longToShort("http://www.lintcode.com/problem/")
>> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
shortToLong("http://tiny.url/lccode")
>> http://www.lintcode.com/
shortToLong("http://tiny.url/1Ab38c")
>> http://www.lintcode.com/problem/
shortToLong("http://tiny.url/1Ab38d")
>> null
 * */

public class TinyUrl2 {
    private HashMap<Long, String> id2url = new HashMap<Long, String>();
    private HashMap<String, Long> url2id = new HashMap<String, Long>();

    private HashMap<String, String> custom_s2l = new HashMap<String, String>();
    private HashMap<String, String> custom_l2s = new HashMap<String, String>();

    private final String tinyUrl = "http://tiny.url/";
    private static long GLOBAL_ID = 0;

    private String getShortKey(String short_url) {
        return short_url.substring(tinyUrl.length(), short_url.length());
    }

    private long shortKeytoID(String shortKey) {
        long id = 0;
        for (int i = 0; i < shortKey.length(); ++i) {
            if ('a' <= shortKey.charAt(i) && shortKey.charAt(i) <= 'z')
                id = id * 62L + (long)(shortKey.charAt(i) - 'a');
            if ('A' <= shortKey.charAt(i) && shortKey.charAt(i) <= 'Z')
                id = id * 62L + (long)(shortKey.charAt(i) - 'A' + 26);
            if ('0' <= shortKey.charAt(i) && shortKey.charAt(i) <= '9')
                id = id * 62L + (long)(shortKey.charAt(i) - '0' + 52);
        }
        return id;
    }

    private String idToShortKey(long n) {
        StringBuffer shortKey = new StringBuffer();
        char[] c = new char[62];
        c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        while (n > 0) {
            shortKey.append(c[(int)(n % 62)]);
            n = n / 62L;
        }
        while (shortKey.length() < 6) {
            shortKey.append("a");
        }
        return shortKey.reverse().toString();
    }
    
    private boolean isNormalKey(String short_key) {
        if (short_key.length() != 6) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            char c = short_key.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                continue;
            }
            return false;
        }
        return true;
    }
    
    /**
     * @param long_url a long url
     * @param a short key
     * @return a short url starts with http://tiny.url/
     */
    String createCustom(String long_url, String short_key) {
        String short_url = tinyUrl + short_key;
        if (isNormalKey(short_key)) {
            long id = shortKeytoID(short_key);
            if (id2url.containsKey(id) && !id2url.get(id).equals(long_url)) {
                return "error";
            }

            if (url2id.containsKey(long_url) && url2id.get(long_url) != id) {
                return "error";
            }
            
            if (id2url.containsKey(id) || url2id.containsKey(long_url))
                return short_url;
        }
        
        if (custom_s2l.containsKey(short_url) && 
                !custom_s2l.get(short_url).equals(long_url)) {
            return "error";
        }
        
        if (custom_l2s.containsKey(long_url) && 
                !custom_l2s.get(long_url).equals(short_url)) {
            return "error";
        }
        
        custom_s2l.put(short_url, long_url);
        custom_l2s.put(long_url, short_url);
        return short_url;
    }

    /**
     * @param long_url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        if (custom_l2s.containsKey(long_url)) {
            return custom_l2s.get(long_url);
        }
        
        if (url2id.containsKey(long_url)) {
            long id = url2id.get(long_url);
            return tinyUrl + idToShortKey(id);
        }
        
        GLOBAL_ID++;
        id2url.put(GLOBAL_ID, long_url);
        url2id.put(long_url, GLOBAL_ID);
        return tinyUrl + idToShortKey(GLOBAL_ID);
    }

    /**
     * @param short_url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String short_url) {
        if (custom_s2l.containsKey(short_url))
            return custom_s2l.get(short_url);

        String short_key = getShortKey(short_url);
        long id = shortKeytoID(short_key);
        return id2url.get(id);
    }
}