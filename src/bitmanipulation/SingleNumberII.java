package bitmanipulation;

/**
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumberII
{
	public int singleNumber( int[] nums )
	{
		// calc bit 1 histogram in int[32] array
		int[] histogram = new int[32];
		for ( int num : nums )
		{
			for ( int i = 0; i < 32; i++ )
			{
				histogram[i] += ( num & ( 1 << i ) );
			}
		}
		
		// reconstruct the single one
		int singleOne = 0;
		for ( int i = 0; i < histogram.length; i++ )
		{
			// TODO: operator precedence of histogram
			singleOne ^= ( histogram[i] % 3 << i );
		}
		return singleOne;		
	}
}
