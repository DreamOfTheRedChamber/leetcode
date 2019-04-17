package facebook.medium;

import java.util.Deque;
import java.util.LinkedList;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
 * */

public class SlidingWindowMaximum 
{
    public int[] maxSlidingWindow( int[] nums, int k )
    {
    	Deque<Integer> decSeq = new LinkedList<>();
    	int[] result = new int[nums.length - k + 1];

    	for ( int i = 0; i < k; i++ )
    	{
    		addElem( decSeq, result[i] );
    	}    	
    	for ( int i = k; i < nums.length; i++ )
    	{
    		addElem( decSeq, result[i] );
    		if ( decSeq.peekFirst() == result[i-k] )
    		{
    			decSeq.pollFirst();
    		}
    		result[i] = decSeq.peekFirst();
    	}
    	
    	return result;
    }
    
    private void addElem( Deque<Integer> decSeq, int num )
    {
		while ( !decSeq.isEmpty() && decSeq.peekLast() < num )
		{
			decSeq.pollLast();
		}
		if ( decSeq.isEmpty() || decSeq.peekLast() >= num )
		{
			decSeq.offerLast( num );
		}    	
    }
}
