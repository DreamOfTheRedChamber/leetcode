package systemDesign.webcrawler;

/*
Implement a webpage Crawler to crawl webpages of http://www.wikipedia.org/. To simplify the question, let's use url instead of the the webpage content.

Your crawler should:

Call HtmlHelper.parseUrls(url) to get all urls from a webpage of given url.
Only crawl the webpage of wikipedia.
Do not crawl the same webpage twice.
Start from the homepage of wikipedia: http://www.wikipedia.org/
 Notice

You need do it with multithreading.

Have you met this question in a real interview? Yes
Example
Given

"http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
"http://www.wikipedia.org/help/": []
Return ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/"]

Given:

"http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
"http://www.wikipedia.org/help/": ["http://www.wikipedia.org/", "http://www.wikipedia.org/about/"]
"http://www.wikipedia.org/about/": ["http://www.google.com/"]
Return ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/", "http://www.wikipedia.org/about/"]
 * */


//Version 1, use sleep
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;
import java.net.*;
import java.io.*;

class CrawlerThread extends Thread {
 private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

 private static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
 private static List<String> results = new ArrayList<String>();

 public static void setFirstUrl(String url) {
     try {
         queue.put(url);
     } catch (InterruptedException e) {
         // e.printStackTrace(); 
     }
 }

 public static List<String> getResults() {
     return results;
 }

 @Override
 public void run() {
     while (true) {
         String url = "";
         try {
             url = queue.take();
         } catch (Exception e) {
             // e.printStackTrace(); 
             break;
         }

         String domain = "";
         try {
             URL netUrl = new URL(url);
             domain = netUrl.getHost();
         } catch (MalformedURLException e) {
             // e.printStackTrace(); 
         }
         if (!mp.containsKey(url) && domain.endsWith("wikipedia.org")) {
             mp.put(url, true);
             results.add(url);
             List<String> urls = HtmlHelper.parseUrls(url);
             for (String u : urls) {
                 try {
                     queue.put(u);
                 } catch (InterruptedException e) {
                     // e.printStackTrace(); 
                 }
             }
         }
     }
 }
}

public class Solution {
 /**
  * @param url a url of root page
  * @return all urls
  */
 public List<String> crawler(String url) {
     // Write your code here
     CrawlerThread.setFirstUrl(url);
     CrawlerThread[] thread_pools = new CrawlerThread[7];
     for (int i = 0; i < 7; ++i) {
         thread_pools[i] = new CrawlerThread();
         thread_pools[i].start();
     }
     
     try {
         Thread.sleep(900);
     } catch (InterruptedException e){
         // e.printStackTrace();
     }

     for (int i = 0; i < 7; ++i) {
         //thread_pools[i].interrupt();
         thread_pools[i].stop();
     }
     
     List<String> results = CrawlerThread.getResults();
     return results;
 }
}


//Version 2, use AtomicLong
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.Thread;
import java.net.*;
import java.io.*;


class CrawlerThread extends Thread {
 private static AtomicLong counter;
 private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

 private static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
 private static List<String> results = new ArrayList<String>();

 public static void setFirstUrl(String url, int thread_num) {
     counter = new AtomicLong(thread_num);

     try {
         queue.put(url);
     } catch (InterruptedException e) {
         // e.printStackTrace(); 
     }
 }
 
 public static Long getCounter() {
     return counter.get();
 }

 public static List<String> getResults() {
     return results;
 }

 @Override
 public void run() {
     while (true) {
         String url = "";
         try {
             counter.decrementAndGet();
             url = queue.take();
             counter.incrementAndGet();
         } catch (Exception e) {
             // e.printStackTrace(); 
             break;
         }

         String domain = "";
         try {
             URL netUrl = new URL(url);
             domain = netUrl.getHost();
         } catch (MalformedURLException e) {
             // e.printStackTrace(); 
         }
         if (!mp.containsKey(url) && domain.endsWith("wikipedia.org")) {
             mp.put(url, true);
             results.add(url);
             List<String> urls = HtmlHelper.parseUrls(url);
             for (String u : urls) {
                 try {
                     queue.put(u);
                 } catch (InterruptedException e) {
                     // e.printStackTrace(); 
                 }
             }
         }
     }
 }
}

public class Solution {
 /**
  * @param url a url of root page
  * @return all urls
  */
 public List<String> crawler(String url) {
     // Write your code here
     int thread_num = 7;
     CrawlerThread.setFirstUrl(url, thread_num);

     CrawlerThread[] thread_pools = new CrawlerThread[thread_num];
     for (int i = 0; i < thread_num; ++i) {
         thread_pools[i] = new CrawlerThread();
         thread_pools[i].start();
     }
     
     while (CrawlerThread.getCounter() > 0);

     for (int i = 0; i < thread_num; ++i) {
         thread_pools[i].stop();
     }
     
     List<String> results = CrawlerThread.getResults();
     return results;
 }
}
