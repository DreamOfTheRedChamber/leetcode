package systemDesign.mapReduce;

/*
Use Map Reduce to find anagrams in a given list of words.

Have you met this question in a real interview? Yes
Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"],["code"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba"], ["cd", "dc"], ["e"].


 * */

public class Anagram {
    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            StringTokenizer tokenizer = new StringTokenizer(value);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                String original = word;
                char[] chars = original.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                output.collect(sorted, word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> results = new ArrayList<String>();
            while (values.hasNext()) {
                    results.add(values.next());
            }
            output.collect(key, results);
        }
    }
}
