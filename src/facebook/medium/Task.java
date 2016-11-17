package facebook.medium;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.Test;

/**
Task那道题，很多面经都提到过。就是比如给你一串task，再给一个cooldown，执行每个task需要时间1，两个相同task之间必须至少相距cooldown的时间，问执行所有task总共需要多少时间。
比如执行如下task：12323，假设cooldown是3。总共需要的时间应该是 1 2 3 _ _ 2 3，也就是7个单位的时间。再比如 1242353，假设cool down是4，那总共时间就是 1 2 4 _ _ _ 2 3 5 _ _ _ 3，也就是13个单位的时间
基于1，给出最优的排列，使得字符串最短。

# Tasks: 1, 1, 2, 1
# Recovery interva (cooldown): 2
# Output: 7  (order is 1 _ _ 1 2 _ 1)

# Example 2.
# Tasks: 1, 2, 3, 1, 2, 3
# Recovery interval (cooldown): 3
# Output: 7  (order is 1 2 3 _ 1 2 3).1point3acres缃�

# Example 3.
# Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
# Recovery interval (cooldown): 6
# Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4)

http://massivealgorithms.blogspot.com/search?q=task+schedule
 */

public class Task
{
	@Test
	public void test()
	{
		assertEquals( 7, calcShortestSchedule( new int[]{ 1, 1, 2, 1 }, 2 ) );
		assertEquals( 7, calcShortestSchedule( new int[]{ 1, 2, 3, 1, 2, 3 }, 3 ) );
		assertEquals( 18, calcShortestSchedule( new int[]{ 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4 }, 6 ) );
	}
	
	public class Element 
	{
		int val;
	    int appr;
	    public Element( int value ) 
	    {
	            this.val = value;
	            this.appr = 1;
	    }
	}
	
	public int calcShortestSchedule( int[] arr, int recover )
	{
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Element> queue = new PriorityQueue<Element>(11, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e2.appr-e1.appr;
            }
        });
        Element[] summary = new Element[10];
        for (int each : arr) {
            if (summary[each] == null) {
                summary[each] = new Element(each);
            }
            else summary[each].appr++;
        }
        for (Element elem : summary) {
            if (elem != null)
                queue.offer(elem);
        }                      
        
        int time = 0;
        LinkedList<Element> temp = new LinkedList<Element>();
        while (!queue.isEmpty() || !temp.isEmpty()) {
            if (!queue.isEmpty()) {
                Element cur = queue.poll();
                if (!map.containsKey(cur.val)) {
                    map.put(cur.val, time+recover+1);
                    cur.appr--;
                    if (cur.appr > 0) temp.offer(cur);
                    while (!temp.isEmpty()) {
                        queue.offer(temp.poll());
                    }
                    time++;
                }
                
                else { //map contains cur.val
                    if (time >= map.get(cur.val)) { //time is feasible
                        map.put(cur.val, time+recover+1);
                        cur.appr--;
                        if (cur.appr > 0) temp.offer(cur);
                        while (!temp.isEmpty()) {
                            queue.offer(temp.poll());
                        }
                        time++;
                    }
                    else { //time is not feasible
                        temp.offer(cur);
                    }
                }
            }
            
            else { //queue is empty, but temp is not empty
                while (!temp.isEmpty()) {
                    queue.offer(temp.poll());
                }
                time++;
            }
        }
        return time;
	}
}