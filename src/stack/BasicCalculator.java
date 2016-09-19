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
    	
    	Stack<Integer> operandStack = new Stack<>();
    	Stack<Character> operatorStack = new Stack<>();
    	int currPos = 0;
    	while ( currPos < s.length( ) )
    	{
    		if ( s.charAt( currPos ) == ' ' )
    		{
    			currPos++;
    		}
    		else if ( s.charAt( currPos ) == '(' )
    		{
    			operatorStack.push( s.charAt( currPos ) );
    			currPos++;
    		}
    		else if ( s.charAt( currPos ) == ')' )
    		{
    			if ( operatorStack.peek() != '(' )
    			{
    				int operand2 = operandStack.pop( );
    				int operand1 = operandStack.pop( );
    				char operator = operatorStack.pop( );
    				operandStack.push( compute( operand1, operand2, operator ) );    				
    			}
    			operatorStack.pop( );
    			currPos++;
    		}
    		else if ( s.charAt( currPos ) == '+' 
    				|| s.charAt( currPos ) == '-' )
    		{
    			if ( !operatorStack.isEmpty( )
    					&& operatorStack.peek( ) != '(' )
    			{
    				int operand2 = operandStack.pop( );
    				int operand1 = operandStack.pop( );
    				char operator = operatorStack.pop( );
    				operandStack.push( compute( operand1, operand2, operator ) );
    			}
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
    	
    	while ( !operatorStack.isEmpty( ) )
    	{
    		int operand2 = operandStack.pop( );
    		int operand1 = operandStack.pop( );
    		char operator = operatorStack.pop( );
    		operandStack.push( compute( operand1, operand2, operator) );
    	}
    	return operandStack.pop();    	
    }
    
    private int compute( int operand1, int operand2, char operator )
    {
    	if ( operator == '+' )
    	{
    		return operand1 + operand2;
    	}
    	else if ( operator == '-' )
    	{
    		return operand1 - operand2;
    	}
    	else if ( operator == '*' )
    	{
    		return operand1 * operand2;
    	}
    	else
    	{
    		return operand1 / operand2;
    	}
    }
}
