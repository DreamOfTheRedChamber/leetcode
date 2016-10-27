package dp.range;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 */

public class LongestValidParentheses
{
    public int longestValidParentheses( String s )
    {
    	if ( s == null || s.length() == 0 )
    	{
    		return 0;
    	}
    	
    	int longestLength = 0;
    	Stack<Integer> leftIndexes = new Stack<>();
    	leftIndexes.push( -1 );
    	for ( int i = 0; i < s.length(); i++ )
    	{
    		char ch = s.charAt( i );
    		if ( ch == '(' )
    		{
    			leftIndexes.push( i );
    		}
    		else
    		{
    			if ( leftIndexes.size() == 1 )
    			{
    				leftIndexes.pop();
    				leftIndexes.push( i );
    			}
    			else
    			{
    				leftIndexes.pop();
    				longestLength = Math.max( longestLength, i - leftIndexes.peek() );
    			}
    		}
    	}
    	return longestLength;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 2, longestValidParentheses( "()" ) );
    	assertEquals( 4, longestValidParentheses( ")()())" ) );
    }
}
