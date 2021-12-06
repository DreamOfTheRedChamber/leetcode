package linkedIn;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * */
public class EvaluateReversePolishNotation 
{
	@Test
	public void test()
	{
		assertEquals( 9, evalRPN( new String[]{"2", "1", "+", "3", "*" } ) );
		assertEquals( 6, evalRPN( new String[]{"4", "13", "5", "/", "+"} ) );
	}
	
    public int evalRPN( String[] tokens ) 
    {
    	Stack<Integer> operandStack = new Stack<>();
    	for ( String token : tokens )
    	{
    		if ( token.equals( "+" )
    				|| token.equals( "-" )
    				|| token.equals( "*" ) 
    				|| token.equals( "/" ) )
    		{
    			int operand2 = operandStack.pop( );
    			int operand1 = operandStack.pop( );
    			if ( token.equals( "+" ) )
    			{
    				operandStack.push( operand1 + operand2 );
    			}
    			else if ( token.equals( "-" ) )
    			{
    				operandStack.push( operand1 - operand2 );
    			}
    			else if ( token.equals( "*" ) )
    			{
    				operandStack.push( operand1 * operand2 );
    			}
    			else
    			{
    				operandStack.push( operand1 / operand2 );
    			}
    		}
    		else
    		{
    			operandStack.push( Integer.valueOf( token ) );
    		}
    	}
    	
    	return operandStack.pop( );
    }
}