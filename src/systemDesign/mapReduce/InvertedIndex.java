package systemDesign.mapReduce;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */

/*
Use map reduce to build inverted index for given documents.
 * */
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            StringTokenizer tokenizer = new StringTokenizer(value.content);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                output.collect(word, id);
            }
            
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> results = new ArrayList<Integer>();
            int previous = -1;
            while (values.hasNext()) {
                int now = values.next();
                if(previous != now) {
                    results.add(now);
                }
                previous = now;
            }
            output.collect(key, results);
        }
    }
}

