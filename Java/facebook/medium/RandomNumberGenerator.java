package facebook.medium;

import java.util.Random;

/**
 * 给一个数组，每个元素有一个概率，写一个函数按照每个元素的概率每次返回一个元素。比如1：0.2，2：0.3，3：0.5    返回1的概率是0.2，返回3的概率是0.5
 */

public class RandomNumberGenerator
{
	private Random rand = new Random();

	public double getRandom( double[] value, int[] freq )
	{
		int[] prefixSum = new int[freq.length+1];
		for ( int i = 1; i < prefixSum.length; i++ )
		{
			prefixSum[i] = prefixSum[i-1] + freq[i-1]; 
		}
		int randNumber = rand.nextInt( prefixSum.length ) + 1;
		int index = findLastSmaller( freq, randNumber );
		return value[index];
	}	
	
	private int findLastSmaller( int[] freq, int target )
	{
		int begin = 0;
		int end = freq.length - 1;
		while ( begin + 1 < end )
		{
			int mid = ( end - begin ) / 2 + begin;
			if ( freq[mid] > target )
			{
				end = mid;
			}
			else
			{
				begin = mid;
			}
		}
		
		if ( freq[end] <= target )
		{
			return end;
		}
		else
		{
			return begin;
		}
	}
}
