package systemDesign.bigtable;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
Implement a standard bloom filter. Support the following method:
1. StandardBloomFilter(k),The constructor and you need to create k hash functions.
2. add(string). add a string into bloom filter.
3. contains(string). Check a string whether exists in bloom filter.

Have you met this question in a real interview? Yes
Example
StandardBloomFilter(3)
add("lint")
add("code")
contains("lint") // return true
contains("world") // return false
 * */

class HashFunction {
    public int cap, seed;

    public HashFunction(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    public int hash(String value) {
        int ret = 0;
        int n = value.length();
        for (int i = 0; i < n; ++i) {
            ret += seed * ret + value.charAt(i);
            ret %= cap;
        }
        return ret;
    }
}

public class StandardBloomFilter {

    public BitSet bits;
    public int k;
    public List<HashFunction> hashFunc;

    public StandardBloomFilter(int k) {
        // initialize your data structure here
        this.k = k;
        hashFunc = new ArrayList<HashFunction>();
        for (int i = 0; i < k; ++i)
            hashFunc.add(new HashFunction(100000 + i, 2 * i + 3));
        bits = new BitSet(100000 + k);
    }

    public void add(String word) {
        // Write your code here
        for (int i = 0; i < k; ++i) {
            int position = hashFunc.get(i).hash(word);
            bits.set(position);
        }
    }

    public boolean contains(String word) {
        // Write your code here
        for (int i = 0; i < k; ++i) {
            int position = hashFunc.get(i).hash(word);
            if (!bits.get(position))
                return false;
        }
        return true;
    }
}