package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorII
{
	@Test
	public void test()
	{
		assertEquals( 7, calculate("3 + 2*2") );
		assertEquals( 1, calculate("3/2") );
		assertEquals( 5, calculate("3+5/2") );
		assertEquals( 5, calculate("100/10/2") );
		assertEquals( 2, calculate("10000000/1/2/3/4/5/6/7/8/9/10") );
		assertEquals( -24, calculate("1*2-3/4+5*6-7*8+9/10"));
	}
	
    public int calculate( String s )
    {
    	if ( s == null 
    			|| s.length() == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	// assertions on validity
    	
    	Stack<Integer> operandStack = new Stack<>();
    	Stack<Character> operatorStack = new Stack<>();
    	int currPos = 0;
    	while ( currPos < s.length( ) )
    	{
    		if ( s.charAt( currPos ) == ' ' )
    		{
    			currPos++;
    		}
    		// pop from stack and calculate when dealing with +, -
    		else if ( s.charAt( currPos ) == '+' 
    				|| s.charAt( currPos ) == '-' )    			
    		{
    			while ( !operatorStack.isEmpty( ) )
    			{
    	    		calculate( operandStack, operatorStack );
    			}    			
    			operatorStack.push( s.charAt( currPos ) );    			
    			currPos++;
    		}
    		else if ( s.charAt( currPos ) == '*'
    				|| s.charAt( currPos ) == '/' )
    		{
    			while ( !operatorStack.isEmpty() 
    					&& ( operatorStack.peek() == '*' || operatorStack.peek() == '/') )
    			{
    	    		calculate( operandStack, operatorStack );    				
    			}
    			operatorStack.push( s.charAt( currPos ) );
    			currPos++;
    		}
    		// push into stack when dealing with num
    		else
    		{
	    		int value = 0;
	    		while ( currPos < s.length( ) 
	    				&& s.charAt( currPos ) >= '0'
	    				&& s.charAt( currPos ) <= '9' )
	    		{
	    			value = value * 10 + s.charAt( currPos ) - '0';
	    			currPos++;
	    		}
	    		operandStack.push( value );
    		}
    	}
    	
    	while ( !operatorStack.isEmpty( ) )
    	{
    		calculate( operandStack, operatorStack );
    	}
    	return operandStack.pop();    	
    }
    
    private void calculate( Stack<Integer> operandStack, Stack<Character> operatorStack )
    {
		int operand2 = operandStack.pop( );
		int operand1 = operandStack.pop( );
		char operator = operatorStack.pop( );

    	if ( operator == '+' )
    	{
    		operandStack.push( operand1 + operand2 );
    	}
    	else if ( operator == '-' )
    	{
    		operandStack.push( operand1 - operand2 );
    	}
    	else if ( operator == '*' )
    	{
    		operandStack.push( operand1 * operand2 );
    	}
    	else
    	{
    		operandStack.push( operand1 / operand2 );
    	}
    }
}