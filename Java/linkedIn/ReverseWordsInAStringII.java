package linkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array
 * */

public class ReverseWordsInAStringII 
{
    public void reverseWords( char[] s )
    {	
    	if ( s == null || s.length == 0 )
    	{
    		return;
    	}
    	
    	reverse( s, 0, s.length - 1 );
    	for ( int wordStart = 0; wordStart < s.length;  )
    	{
    		if ( s[wordStart] == ' ' )
    		{
    			wordStart++;
    		}
    		else 
    		{
    			// find word end position
    			int wordEnd = wordStart;
    			while ( wordEnd + 1 < s.length && s[wordEnd + 1] != ' ' )
    			{
    				wordEnd++;
    			}
    			
    			reverse( s, wordStart, wordEnd );    			
    			wordStart = wordEnd + 1;
    		}    		
    	}    	
    }
    
    private void reverse( char[] s, int start, int end )
    {
    	while ( start < end )
    	{
    		char temp = s[start];
    		s[start] = s[end];
    		s[end] = temp;
    		start++;
    		end--;
    	}
    }
    
    @Test
    public void test()
    {
    	// strange input
//    	assertEquals( "word", reverseWords( "word" ) );
    	
    	// normal cases
//    	assertEquals( "blue is sky the", reverseWords( "the sky is blue" ) );
    }
}
