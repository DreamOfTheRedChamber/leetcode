package systemDesign.mapReduce;

import java.util.Iterator;

/*
Using map reduce to count word frequency.

https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3A+WordCount+v1.0

Have you met this question in a real interview? Yes
Example
chunk1: "Google Bye GoodBye Hadoop code"
chunk2: "lintcode code Bye"


Get MapReduce result:
    Bye: 2
    GoodBye: 1
    Google: 1
    Hadoop: 1
    code: 2
    lintcode: 1
 * */

public class WordCount {
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            String[] tokens = value.split(" ");

            for(String word : tokens) {
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int sum = 0;
            while (values.hasNext()) {
                    sum += values.next();
            }
            output.collect(key, sum);
        }
    }
}
