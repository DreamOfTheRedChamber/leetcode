package dp.twoSequences;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

// TO_IMME
public class RegularExpressionMatchingMemorizedSearch
{
	@Test
	public void test()
	{
		// test *
		assertTrue( isMatch( "ab", "c*a*b" ) );
		assertTrue( isMatch( "cab", "c*a*b" ) );
		assertTrue( isMatch( "ccaab", "c*a*b" ) );
		assertTrue( isMatch( "", ".*" ) );
		assertTrue( isMatch( "ab", ".*" ) );
		
		assertFalse( isMatch( "aaba", "ab*a*c*a" ) );
		assertTrue( isMatch( "aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s" ) );
	}
	 
 public boolean isMatch( String s, String p )
 {
 	if ( s == null || p == null )
 	{
 		return false;
 	}
 	int[][] match = new int[s.length()+1][p.length()+1];
 	helper( s, p, 0, 0, match );
 	return match[s.length()][p.length()] == 1;
 }
 
 private boolean helper( String s, String p, int i, int j, int[][] match )
 {
 	// base case
 	if ( j == p.length() )
 	{
 		match[i][j] = ( i == s.length() ) ? 1 : -1;
 		return match[i][j] == 1;
 	}
 	
 	if ( match[i][j] != 0 )
 	{
 		return match[i][j] == 1;
 	}
 	
 	// case 1: p[i+1] == '*'
 	if ( j < p.length() - 1 && p.charAt( j + 1 ) == '*' )
 	{
 		match[i][j] = ( i < s.length() 
 				&& ( s.charAt( i ) == p.charAt( j ) || p.charAt( j ) == '.' ) 
 				&& helper( s, p, i + 1, j, match ) 
 				|| helper( s, p, i, j + 2, match ) ) ? 1 : -1;
 	}
 	// case 2: p[i+1] != '*'
 	{
 		match[i][j] = ( i < s.length() 
 				&& ( s.charAt( i ) == p.charAt( j ) || p.charAt( j ) == '.' ) 
 				&& helper( s, p, i + 1, j + 1, match ) ) ? 1 : -1 ;
 	}
 	return match[i][j] == 1;
 }
}