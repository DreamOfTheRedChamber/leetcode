package palindrome;

/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class LongestPalindromicSubstring
{
	public String longestPalindrome( String s )
	{
  if ( s == null || s.length() == 0 )
  {
  	return "";
  }
  
  int longest = 1;
  int longestStart = 0;
  int longestEnd = 0;
  
  // odd length palindrome
  for ( int i = 0; i < s.length(); i++ )
  {
  	for ( int left = i-1, right = i + 1; left >= 0 && right < s.length() && s.charAt( left ) == s.charAt( right ); left--, right++ )
  	{
  		if ( right - left + 1 > longest )
  		{
  			longest = right - left + 1;
  			longestStart = left;
  			longestEnd = right;
  		}
  	}
  }
  
  // even length palindrome
  for ( int i = 1; i < s.length(); i++ )
  {
  	for ( int left = i - 1, right = i; left >= 0 && right < s.length() && s.charAt( left ) == s.charAt( right ); left--, right++ )
  	{
  		if ( right - left + 1 > longest )
  		{
  			longest = right - left + 1;
  			longestStart = left;
  			longestEnd = right;
  		}
  	}
  }
    
  return s.substring( longestStart, longestEnd + 1 );
 }		
}