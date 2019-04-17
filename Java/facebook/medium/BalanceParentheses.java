package facebook.medium;

import java.util.Stack;

import org.junit.Ignore;
import org.junit.Test;

/**
 * balance parentheses in a string
例子：
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"
Note: balance的意思就是把原来string里unpaired的括号变成paired的形式。如果有多个可能的结果， 比如上述最后一种情况，我们就只需要输出一个对的结果即可，所以这点简化了题目的难度。
感受： 遍历string， 用一个stack存储每个open parenthesis的index，也就是'('的index, 每当遇到closed parenthesis就执行一次pop操作。
注意两种unbalanced的情况：
1. 出现多余的')':
    对应情况就是stack为空，但遇到了一个')'。
2. 出现多余的'(':
    对应情况就是遍历结束，stack未空
 */

public class BalanceParentheses
{
	public String balance( String s )
	{
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder( s );
		for ( int i = 0; i < s.length(); i++ )
		{
			int ch = s.charAt( i );
			if ( ch != '(' && ch != ')' )
			{
				continue;
			}

			if ( stack.isEmpty() || ch == '(' )
			{
				stack.push( i );
			}
			else
			{
				if ( s.charAt( stack.peek() ) == '(' )
				{
					stack.pop();
				}
				else
				{
					stack.push( i );
				}
			}
		}
		
		while ( !stack.isEmpty() )
		{
			sb.deleteCharAt( stack.pop() );
		}
		return sb.toString();
	}
	
	public String balanceForwardBackwardSweep( String s )
	{
		StringBuilder result = removeInvalidOpenParen( new StringBuilder( s ) );
		result = removeInvalidCloseParen( result );
		return result.toString();
	}
	
	private StringBuilder removeInvalidOpenParen( StringBuilder input )
	{
		StringBuilder result = new StringBuilder( input );
		int numClose = 0;
		for ( int i = result.length() - 1; i >= 0; i-- )
		{
			if ( result.charAt( i ) == ')' )
			{
				numClose++;
			}
			else if ( result.charAt( i ) == '(' )
			{
				if ( numClose == 0 )
				{
					result.deleteCharAt( i );
				}
				else
				{
					numClose--;
				}
			}
		}
		return result;
	}
	
	private StringBuilder removeInvalidCloseParen( StringBuilder input )
	{
		StringBuilder result = new StringBuilder();
		int numOpen = 0;
		for ( int i = 0; i < input.length(); i++ )
		{
			if ( input.charAt( i ) == ')' )
			{
				if ( numOpen > 0 )
				{
					result.append( input.charAt( i ) );
					numOpen--;
				}
			}
			else if ( input.charAt( i ) == '(' )
			{
				result.append( input.charAt( i ) );
				numOpen++;
			}
			else
			{
				result.append( input.charAt( i ) );
			}
		}
		return result;
	}

	@Test
	public void testBalanceForwardBackwardSweep()
	{
		/*
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"
		 * */
		System.out.println( balanceForwardBackwardSweep( "(a)()") );
		System.out.println( balanceForwardBackwardSweep( "((bc)" ) );
		System.out.println( balanceForwardBackwardSweep( ")))a((" ) );
		System.out.println( balanceForwardBackwardSweep( "(a(b)" ) );
	}
	
	@Ignore
	@Test
	public void test()
	{
		/*
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"
		 * */
		System.out.println( balance( "(a)()") );
		System.out.println( balance( "((bc)" ) );
		System.out.println( balance( ")))a((" ) );
		System.out.println( balance( "(a(b)" ) );
	}
}
