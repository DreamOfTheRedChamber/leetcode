package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Ignore;
import org.junit.Test;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 * */

public class BasicCalculator 
{
	@Test
	public void test()
	{
		assertEquals(2, calculate("1 + 1") );
		assertEquals(0, calculate("0") );
		assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)") );
		assertEquals( 5, calculate("1+4-(3+2)+5") );		
	}
	
	@Test
	public void test2()
	{
		assertEquals( 0, calculate( "0/1" ) );
		assertEquals( 27, calculate( "100000000/1/2/3/4/5/6/7/8/9/10" ) );
		assertEquals( -1 , calculate( "1-1-1") );
		
	}
	
    public int calculate( String s )
    {
    	if ( s == null 
    			|| s.length() == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	// assertions on validity
    	
    	Stack<Integer> valStack = new Stack<>();
    	Stack<Character> opStack = new Stack<>();
    	for ( int i = 0; i < s.length( ); i++ )
    	{
    		char token = s.charAt( i );
    		if ( token == ' ' )
    		{
    			continue;
    		}
    		else if ( token == '(' )
    		{
    			opStack.push( token );
    		}
    		else if ( token == ')' )
    		{
    			while ( opStack.peek() != '(' )
    			{
    				valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
    			}
    			opStack.pop();
    		}
    		else if ( Character.isDigit( token ) )
    		{
    			int start = i;
    			while ( i + 1 < s.length() && Character.isDigit( s.charAt( i + 1 ) ) )
    			{	
    				i++;
    			}
    			valStack.push( Integer.parseInt( s.substring( start, i + 1 ) ) );
    		}
    		else
    		{
	    		while ( !opStack.isEmpty() && isLowerPrece( token, opStack.peek() ) )
	    		{
	    			valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
	    		}
	    		opStack.push( token );
    		}
    	}
    	
    	while ( !opStack.isEmpty( ) )
    	{
    		valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
    	}
    	return valStack.pop();    	
    }
        
    private boolean isLowerPrece( char curr, char toBeCompared )
    {
    	return ( toBeCompared == '*' || toBeCompared == '/' ) 
    			|| ( toBeCompared == '-' && ( curr == '+' || curr == '-' ) );
    }
    
    private int calc( char operator, int operand1, int operand2 )
    {
    	if ( operator == '+' )
    	{
    		return operand2 + operand1;
    	}
    	else if ( operator == '-' )
    	{
    		return operand2 - operand1;
    	}
    	else if ( operator == '*' )
    	{
    		return operand2 * operand1;
    	}
    	else
    	{
    		return operand2 / operand1;
    	}
    }
}
