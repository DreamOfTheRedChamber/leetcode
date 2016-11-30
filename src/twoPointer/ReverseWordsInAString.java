package twoPointer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 * */

public class ReverseWordsInAString 
{
    public String reverseWords( String s )
    {
    	if ( s == null || s.length() == 0 )
    	{
    		return "";
    	}
    	
    	String[] words = s.split( " " );
    	StringBuilder result = new StringBuilder();
    	for ( int i = words.length - 1; i >= 0; i-- )
    	{
    		if ( !words[i].equals( "" ) )
    		{
    			result.append( words[i] ).append( " " );
    		}
    	}
    	
    	if ( result.length() != 0 )
    	{
    		result.deleteCharAt( result.length() - 1 );
    	}
    	return result.toString();
    }
    
    @Test
    public void test()
    {   
    	assertEquals( "a", reverseWords( "a " ));
    	assertEquals( "", reverseWords( " " ) );
    	assertEquals( "blue is sky the", reverseWords( "the sky is  blue" ) );
    }
}
