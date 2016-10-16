package dp.range;

/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII
{
	public int minCut( String s )
	{
		boolean[][] isPalindrome = new boolean[s.length() + 1][s.length() + 1];
		// init isPalindrome
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
		for ( int i = s.length(); i >= 1; i++ )
		{
			for ( int j = i + 2; j <= s.length(); j++ )
			{
				isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt( i-1 ) == s.charAt( j - 1 );
			}
		}
		
		int[][] minCutNum = new int[s.length() + 1][s.length() + 1];
		for ( int i = s.length(); i >= 1; i++ )
		{
			for ( int j = i + 1; j <= s.length(); j++ )
			{
				if ( isPalindrome[i][j] )
				{
					minCutNum[i][j] = 0;
					continue;
				}
				
				minCutNum[i][j] = j - i;
				for ( int k = i + 1; k < j; k++ )
				{
					minCutNum[i][j] = Math.min( minCutNum[i][j], minCutNum[i][k] + minCutNum[k+1][j] + 1 );
				}				
			}
		}
		return minCutNum[s.length()][s.length()];
	}
}
