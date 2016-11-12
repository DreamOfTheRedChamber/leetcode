package facebook.easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */

public class ValidParentheses 
{
    public boolean isValid( String s )
    {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openToClose = new HashMap<>();
        openToClose.put( '(', ')' );
        openToClose.put( '[', ']' );
        openToClose.put( '{', '}' );
        
        for ( char ch : s.toCharArray() )
        {
        	if ( openToClose.containsKey( ch ) )
        	{
        		stack.push( ch );
        	}
        	else
        	{
        		if ( stack.isEmpty() || ch != openToClose.get( stack.peek() ) )
        		{
        			return false;
        		}
        		stack.pop();
        	}
        }
        
        return stack.size() == 0;
    }
    
    @Test
    public void test()
    {
    	assertFalse( isValid( "(]" ) );
    	assertFalse( isValid( "([)]" ) );
    	assertTrue( isValid( "()[]{}" ) );
    }
}
