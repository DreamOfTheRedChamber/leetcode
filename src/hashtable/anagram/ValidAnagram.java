package hashtable.anagram;

/**
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram
{
	private final static int CHARSET_SIZE = 26;
    public boolean isAnagram(String s, String t) 
    {
    	int[] sHistogram = new int[CHARSET_SIZE];
    	for ( char ch : s.toCharArray( ) )
    	{
    		sHistogram[ch - 'a'] = sHistogram[ch - 'a'] + 1;
    	}
    	
    	int[] tHistogram = new int[CHARSET_SIZE];
    	for ( char ch : t.toCharArray( ) )
    	{
    		tHistogram[ch - 'a'] = tHistogram[ch - 'a'] + 1;
    	}
    	
    	for ( int i = 0; i < CHARSET_SIZE; i++ )
    	{
    		if ( sHistogram[i] != tHistogram[i] )
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
