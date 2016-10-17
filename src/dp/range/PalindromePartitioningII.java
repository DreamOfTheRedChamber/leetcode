package dp.range;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII
{
	@Test
	public void test()
	{
		assertEquals( 1, minCut( "abcb" ) );
		assertEquals( 3, minCut( "abcd" ) );
		assertEquals( 0, minCut( "aaaaa" ) );
	}
	
	public int minCut( String s )	
	{
		boolean[][] isPalindrome = new boolean[s.length() + 1][s.length() + 1];
		// init
		for ( int i = 1; i <= s.length(); i++ )
		{
			isPalindrome[i][i] = true;
		}
		for ( int i = 1; i < s.length(); i++ )
		{
			if ( s.charAt( i - 1 ) == s.charAt( i ) )
			{
				isPalindrome[i][i+1] = true;
			}
		}
		// fill in table
		for ( int i = s.length(); i >= 1; i-- )
		{
			for ( int j = i + 2; j <= s.length(); j++ )
			{
				isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt( i-1 ) == s.charAt( j - 1 );
			}
		}
		
		// init
		int[] minNumPalindrome = new int[s.length() + 1]; // 
		for ( int i = 0; i <= s.length(); i++ )
		{
			minNumPalindrome[i] = i - 1;
		}
		// fill in table
		for ( int i = 1; i <= s.length(); i++ )
		{
			if ( isPalindrome[1][i] )
			{
				minNumPalindrome[i] = 0;
			}
			else
			{
				for ( int lastWordLength = 1; lastWordLength < i; lastWordLength++ )
				{
					if ( isPalindrome[i-lastWordLength+1][i] )
					{
						minNumPalindrome[i] = Math.min( minNumPalindrome[i], minNumPalindrome[i-lastWordLength] + 1 );
					}
				}
			}
		}
		
		return minNumPalindrome[s.length()];
	}
}
