package bitmanipulation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumberII
{
	private final static int BIT_LENGTH = 32;
	
	public int singleNumber( int[] nums )
	{
		// calc bit 1 histogram in int[32] array
		int[] histogram = new int[BIT_LENGTH];
		for ( int i = 0; i < nums.length; i++ )
		{
			for ( int j = 0; j < BIT_LENGTH; j++ )
			{
				histogram[j] += ( ( nums[i] >> j ) & 1 );
			}
		}
		
		// reconstruct the single one
		int singleOne = 0;
		for ( int i = 0; i < histogram.length; i++ )
		{
			singleOne |= ( histogram[i] % 3 << i );
		}
		return singleOne;		
	}
	
	@Test
	public void test()
	{
		assertEquals( 3, singleNumber( new int[]{ 2, 2, 3, 2 } ) );
	}
}
