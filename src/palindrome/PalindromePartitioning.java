package palindrome;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 * */

public class PalindromePartitioning 
{
	@Test
	public void test()
	{
		System.out.println( partition( "aab" ) );
		System.out.println( partition( "aaabcb" ) );
	}
	
    public List<List<String>> partition( String s )
    {
    	if ( s == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	List<List<String>> allPartitions = new ArrayList<>();
    	if ( s.length() == 0 )
    	{
    		return allPartitions;
    	}
    	
    	// init dp table
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	for ( int i = 0; i < s.length(); i++ )
    	{
    		isPalindrome[i][i] = true;
    	}
    	for ( int i = 0; i < s.length() - 1; i++ )
    	{
    		isPalindrome[i][i+1] = s.charAt( i ) == s.charAt( i + 1 );
    	}
    	// fill dp table
    	for ( int i = s.length() - 2; i >= 0; i-- )
    	{
    		for ( int j = i + 2; j < s.length(); j++ )
    		{
    			isPalindrome[i][j] = s.charAt(i) == s.charAt(j)
    								&& isPalindrome[i+1][j-1];
    		}
    	}
    	
    	List<String> onePartition = new ArrayList<>();
    	dfs( allPartitions, onePartition, s, isPalindrome, 0, s.length() - 1 );
    	return allPartitions;
    }
    
    private void dfs( List<List<String>> allPartitions, List<String> onePartition, String s, boolean[][] isPalindrome, int start, int end )
    {
    	if ( end == -1 )
    	{
    		allPartitions.add( new ArrayList<>( onePartition ) );
    		return;
    	}
    	if ( end < -1 )
    	{
    		return;
    	}
    	
    	for ( int i = end; i >= start; i-- )
    	{
    		if ( isPalindrome[i][end] )
    		{
    			onePartition.add( 0, s.substring( i, end + 1 ) );
    			dfs( allPartitions, onePartition, s, isPalindrome, start, i - 1 );
    			onePartition.remove( 0 );
    		}
    	}
    }
}