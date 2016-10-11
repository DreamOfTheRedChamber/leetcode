package hashtable;

/**
Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
Example 1: str = "aabbcc", k = 3
Result: "abcabc"
The same letters are at least distance 3 from each other. Example 2: str = "aaabc", k = 3
Answer: ""
It is not possible to rearrange the string. Example 3: str = "aaadbbcc", k = 2
Answer: "abacabcd"
Another possible answer is: "abcabcda"
The same letters are at least distance 2 from each other. 
 */

public class RearrangeStringKDistanceApart
{

    public String rearrangeString(String str, int k) 
    {
        
    }

}

/*
这道题给了我们一个字符串str，和一个整数k，让我们对字符串str重新排序，使得其中相同的字符之间的距离不小于k，这道题的难度标为Hard，看来不是省油的灯。
的确，这道题的解法用到了哈希表，堆，和贪婪算法。这道题我最开始想的算法没有通过OJ的大集合超时了，下面的方法是参考网上大神的解法，发现十分的巧妙。
我们需要一个哈希表来建立字符和其出现次数之间的映射，然后需要一个堆来保存这每一堆映射，按照出现次数来排序。
然后如果堆不为空我们就开始循环，我们找出k和str长度之间的较小值，然后从0遍历到这个较小值，对于每个遍历到的值，
如果此时堆为空了，说明此位置没法填入字符了，返回空字符串，否则我们从堆顶取出一对映射，然后把字母加入结果res中，
此时映射的个数减1，如果减1后的个数仍大于0，则我们将此映射加入临时集合v中，同时str的个数len减1，遍历完一次，我们把临时集合中的映射对由加入堆中，参见代码如下：

 

复制代码
class Solution {
public:
    string rearrangeString(string str, int k) {
        if (k == 0) return str;
        string res;
        int len = (int)str.size();
        unordered_map<char, int> m;
        priority_queue<pair<int, char>> q;
        for (auto a : str) ++m[a];
        for (auto it = m.begin(); it != m.end(); ++it) {
            q.push({it->second, it->first});
        }
        while (!q.empty()) {
            vector<pair<int, int>> v;
            int cnt = min(k, len);
            for (int i = 0; i < cnt; ++i) {
                if (q.empty()) return "";
                auto t = q.top(); q.pop();
                res.push_back(t.second);
                if (--t.first > 0) v.push_back(t);
                --len;
            }
            for (auto a : v) q.push(a);
        }
        return res;
    }
}; */

/*
//先记录str中的char及它出现在次数，存在count[]里，用valid[]来记录这个char最小出现的位置。
    //每一次把count值最大的数选出来，append到新的string后面
    public int selectedValue(int[] count, int[] valid, int i) {
        int select = Integer.MIN_VALUE;
        int val = -1;
        for (int j = 0; j < count.length; j++) {
            if (count[j] > 0 && i >= valid[j] && count[j] > select) {
                select = count[j];
                val = j;
            }
        }
        return val;
    }
    
    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        //把每个出现了的char的个数记下来
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //选出剩下需要出现次数最多又满足条件的字母，即是我们最应该先放的数
            int curt = selectedValue(count, valid, i);
            //如果不符合条件，返回“”
            if (curt == -1) return "";
            //选择好后，count要减少，valid要到下一个k distance之后
            count[curt]--;
            valid[curt] = i + k;
            sb.append((char)('a' + curt));
        }
        
        return sb.toString();
    }
    
    
        public String rearrangeString(String str, int k) 
        {
	        StringBuilder res = new StringBuilder();
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : str.toCharArray()) {
	            map.put(c,map.getOrDefault(c,0)+1);
	        }
	        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
	            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
	                return entry2.getValue() - entry1.getValue();
	            }
	        });
	        maxHeap.addAll(map.entrySet());
	        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
	        while (!maxHeap.isEmpty()) 
	        {
	            Map.Entry<Character, Integer> current = maxHeap.poll();
	            res.append(current.getKey());
	            current.setValue(current.getValue() - 1);
	            waitQueue.offer(current);
	            if (waitQueue.size() < k) { 
	                continue;
	            }
	        
	            Map.Entry<Character, Integer> front = waitQueue.poll();
	            if (front.getValue() > 0) {
	                maxHeap.offer(front);
	            }
	        }
	        return res.length() == str.length() ? res.toString() : "";
    	}
 * */
