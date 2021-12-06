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