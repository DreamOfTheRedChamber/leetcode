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

public class RegularExpressionMatchingRecurse
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
 	return helperRecurse( s, p, 0, 0 );
 }
 
 private boolean helperRecurse( String s, String p, int i, int j )
 {
 	// base case
 	if ( j == p.length() )
 	{
 		return i == s.length();
 	}
 	
 	// case 1: p[i+1] == '*'
 	if ( j < p.length() - 1 && p.charAt( j + 1 ) == '*' )
 	{
 		return i < s.length() && ( s.charAt( i ) == p.charAt( j ) || p.charAt( j ) == '.' ) && helperRecurse( s, p, i + 1, j ) 
 				|| helperRecurse( s, p, i, j + 2 );
 	}
 	// case 2: p[i+1] != '*'
 	{
 		return i < s.length() && ( s.charAt( i ) == p.charAt( j ) || p.charAt( j ) == '.' && helperRecurse( s, p, i + 1, j + 1 ) );
 	}
 }
}