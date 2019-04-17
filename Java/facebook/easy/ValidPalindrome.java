package facebook.easy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome 
{
	@Test
	public void test()
	{
		assertTrue( isPalindrome( "aA" ) );
		assertTrue( !isPalindrome( "0P" ) );
	}
	
    public boolean isPalindrome( String s )
    {
    	int start = 0;
    	int end = s.length() - 1;
    	while ( start < end )
    	{
    		while ( start < end && !isValid( s.charAt( start ) ) )
    		{
    			start++;
    		}
    		while ( start < end && !isValid( s.charAt( end ) ) )
    		{
    			end--;
    		}
    		
    		if ( start < end ) 
    		{
    			if ( Character.toLowerCase( s.charAt( start ) ) != Character.toLowerCase( s.charAt( end ) ) )
    			{
        			return false;    				    				
    			}
    			start++;
    			end--;
    		}    		
    	}
    	return true;
    }
    
    private boolean isValid( char ch )
    {
    	return Character.isLetter( ch ) || Character.isDigit( ch );
    }
}
