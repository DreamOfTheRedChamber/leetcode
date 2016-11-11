package facebook.medium;

import java.util.Stack;

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
