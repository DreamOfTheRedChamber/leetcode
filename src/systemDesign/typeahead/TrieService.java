package systemDesign.typeahead;

import java.util.List;

/*
Build tries from a list of pairs. Save top 10 for each node.

Have you met this question in a real interview? Yes
Example
Given a list of

<"abc", 2>
<"ac", 4>
<"ab", 9>
Return <a[9,4,2]<b[9,2]<c[2]<>>c[4]<>>>, and denote the following tree structure:

         Root
         / 
       a(9,4,2)
      /    \
    b(9,2) c(4)
   /
 c(2)
 * */

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         top10 = new ArrayList<Integer>();
 *     }
 * }
 */
public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        TrieNode cur = root;
        int n = word.length();

        for (int i = 0; i < n; ++i) {
            Character c = word.charAt(i);
            if (!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());

            cur = cur.children.get(c);
            addFrequency(cur.top10, frequency);
        }
    }

    public void addFrequency(List<Integer> top10, int frequency) {
        top10.add(frequency);
        int n = top10.size();
        int index = n - 1;
        while (index > 0) {
            if (top10.get(index) > top10.get(index - 1)) {
                int temp1 = top10.get(index);
                int temp2 = top10.get(index - 1);
                top10.set(index, temp2);
                top10.set(index - 1, temp1);
                index -= 1;
            } else 
                break; 
        }
        if (n > 10)
            top10.remove(n - 1);
    }
}
