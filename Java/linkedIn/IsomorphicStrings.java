package linkedIn;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */

public class IsomorphicStrings
{
 public boolean isIsomorphic( String s, String t )
 {
 	Map<Character, Character> sToT = new HashMap<>();
 	Map<Character, Character> tToS = new HashMap<>();
 	for ( int i = 0; i < s.length(); i++ )
 	{
 		if ( sToT.containsKey( s.charAt( i ) ) && sToT.get( s.charAt( i ) ) != t.charAt( i ) 
 				|| tToS.containsKey( t.charAt( i ) ) && tToS.get( t.charAt( i ) ) != s.charAt( i ) )
 		{
 			return false;
 		}
 		else
 		{
 			sToT.put( s.charAt( i ), t.charAt( i ) );
 			tToS.put( t.charAt( i ), s.charAt( i ) );
 		}
 	}
 	return true;
 }
 
 @Test
 public void test()
 {
 	assertTrue( !isIsomorphic( "ab", "aa" ) );
 	assertTrue( isIsomorphic( "egg", "add" ) );
 	assertTrue( !isIsomorphic( "foo", "bar" ) );
 	assertTrue( isIsomorphic( "paper", "title" ) );
 }
}
