package kth.heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size
 */

public class TopKFrequentElements
{
    public List<Integer> topKFrequent( int[] nums, int k )
    {
    	// build a histogram
    	Map<Integer, Integer> histogram = new HashMap<>();
    	for ( int num : nums )
    	{
    		histogram.put( num, histogram.getOrDefault( num, 0 ) + 1 );
    	}
    	
    	// build a priorityqueue
    	Queue<Map.Entry<Integer, Integer>> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.getValue() - o1.getValue() ) );
    	maxQueue.addAll( histogram.entrySet() );
    	
    	// take top k frequent
    	return maxQueue.stream()
    				   .sorted( ( o1, o2 ) -> ( o2.getValue() - o1.getValue() ) )
    				   .limit( k )
    				   .map( o -> o.getKey() )
    				   .collect( Collectors.toList() );    	
    }    
    
    @Test
    public void test()
    {
    	System.out.println( topKFrequent( new int[]{4, 1, -1, 2, -1, 2, 3}, 2 ) );
    }
    
}
