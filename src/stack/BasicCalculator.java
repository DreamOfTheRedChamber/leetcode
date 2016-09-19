package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

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
// TO_IMME
// TODO: a calculator for + - * / ( )
// TODO: inside interview, never define input as string value because that means a lot parsing
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
    		// pop from stack and calculate when dealing with +, -, )
    		else if ( s.charAt( currPos ) == '+' 
    				|| s.charAt( currPos ) == '-' 
    				|| s.charAt(currPos) == ')' )    			
    		{
    			if ( !operatorStack.isEmpty( )
    					&& operatorStack.peek( ) != '(' )
    			{
    	    		calculate( operandStack, operatorStack );
    			}
    			if ( s.charAt( currPos ) == ')' )
    			{
        			operatorStack.pop( );
    				
    			}
    			else
    			{
    				operatorStack.push( s.charAt( currPos ) );
    			}
    			currPos++;
    		}
    		// push into stack when dealing with (, num
    		else
    		{
    			if ( s.charAt( currPos ) == '(' )
    			{
        			operatorStack.push( s.charAt( currPos ) );
        			currPos++;
    			}
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
