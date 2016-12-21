package systemDesign.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Parse a html page, extract the Urls in it.

Hint: use regex to parse html.

Have you met this question in a real interview? Yes
Example
Given the following html page:

<html>
  <body>
    <div>
      <a href="http://www.google.com" class="text-lg">Google</a>
      <a href="http://www.facebook.com" style="display:none">Facebook</a>
    </div>
    <div>
      <a href="https://www.linkedin.com">Linkedin</a>
      <a href = "http://github.io">LintCode</a>
    </div>
  </body>
</html>
You should return the Urls in it:

[
  "http://www.google.com",
  "http://www.facebook.com",
  "https://www.linkedin.com",
  "http://github.io"
]
 * */

public class UrlParser {
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*\"?'?([^\"'>\\s]*)";
    /**
     * @param content source code
     * @return a list of links
     */
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> links = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String url = null;
        while (matcher.find()) {
            url = matcher.group(1);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        return links;
    }
}
