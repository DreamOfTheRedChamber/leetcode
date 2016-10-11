package kth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
    public List<Integer> topKFrequent(int[] nums, int k) 
    {
    	// build a histogram
    	Map<Integer, Integer> numHistogram = new HashMap<>();
    	for ( int num : nums )
    	{
    		numHistogram.put( num, numHistogram.getOrDefault( num, 0 ) + 1 );
    	}
    	
    	// build a priorityqueue
    	PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) );
    	for ( Map.Entry<Integer, Integer> entry : numHistogram.entrySet( ) )
    	{
    		mostFreqPrioQueue.add( new NumAndFreq( entry.getKey( ), entry.getValue( ) ) );
    	}
    	
    	// take top k frequent
    	List<Integer> topKFreqNums = new LinkedList<>();
    	while ( ( mostFreqPrioQueue.size() > 0 )
    			&& ( topKFreqNums.size() < k ) )
    	{
    		topKFreqNums.add( mostFreqPrioQueue.remove( ).num );
    	}
    	return topKFreqNums;
    }    
    
}

class NumAndFreq
{
	public final int num;
	public final int freq;
	public NumAndFreq( int num, int freq )
	{
		this.num = num;
		this.freq = freq;
	}
}
