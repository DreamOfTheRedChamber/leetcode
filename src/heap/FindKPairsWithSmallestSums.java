package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
 * */

public class FindKPairsWithSmallestSums 
{
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) 
    {    	
        List<int[]> result = new ArrayList<>();
        if ( nums1.length == 0 
        		|| nums2.length == 0 )
        {
        	return result;
        }
        
        // enqueue all pairs
        PriorityQueue<Pair> pairSumQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.sum - o2.sum );
        for ( int i = 0; i < nums1.length; i++ )
        {
        	for ( int j = 0; j < nums2.length; j++ )
        	{
                pairSumQueue.offer( new Pair( i, j, nums1[i] + nums2[j] ) );        		
        	}
        }
        
        // take the smallest k pairs
        int numPairs = 0;
        while ( numPairs < k
        		&& !pairSumQueue.isEmpty() )
        {
        	Pair qHead = pairSumQueue.remove();        	
        	result.add( new int[]{ nums1[qHead.num1Index], nums2[qHead.num2Index ] } );
        	numPairs++;
        }
        return result;
    }
    
    @Test
    public void test()
    {
    	List<int[]> result = kSmallestPairs( new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10 );
    	for (int[] num : result )
    	{
    		System.out.println( Arrays.toString( num ));
    	}
    }
}

class Pair
{
	public final int num1Index;
	public final int num2Index;
	public final int sum;
	public Pair( int num1Index, int num2Index, int sum )
	{
		this.num1Index = num1Index;
		this.num2Index = num2Index;
		this.sum = sum;
	}
}