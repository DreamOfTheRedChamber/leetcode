package kth;

import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * */

public class KthLargestElementInAnArray 
{
    public int findKthLargest( int[] nums, int k )
    {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> o2 - o1 );
        for ( int num : nums )
        {
        	maxQueue.add( num );
        }
        
        int count = 0;
        int result = 0;
        while ( count < k )
        {
        	result = maxQueue.remove();
        	count++;
        }
        
        return result;
    }
}
