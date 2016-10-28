package facebook.easy;

import static org.junit.Assert.*;

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
        for ( char ch : s.toCharArray() )
        {
        	if ( !stack.isEmpty() 
        			&& ( ch == ')' && stack.peek() == '(' 
        				||  ch == ']' && stack.peek() == '[' 
        				|| ch == '}' && stack.peek() == '{' ) )
        	{
        		stack.pop();
        	}        		
        	else
        	{
        		stack.push( ch );
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
