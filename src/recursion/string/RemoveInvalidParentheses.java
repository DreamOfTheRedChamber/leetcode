package recursion.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Test;

/**
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
 */
public class RemoveInvalidParentheses
{
	
	@Test
	public void test()
	{
		System.out.println( removeInvalidParentheses( "()())()" ) );
		System.out.println( removeInvalidParentheses( "(a)())()" ) );
		System.out.println( removeInvalidParentheses( ")(" ) );
		System.out.println( removeInvalidParentheses( "n" ) );
	}
	
	public List<String> removeInvalidParentheses( String s ) 
	{
		List<String> result = new ArrayList<>();
		if ( s == null || s.length() == 0 )
		{
			result.add("");
			return result;
		}
		
		// trunning beginning and ending parenthese
		int start = 0;
		while ( s.charAt( start ) == ')' )
		{
			start++;
		}
		int end = s.length() - 1;
		while ( s.charAt( end ) == '(' )
		{
			end--;
		}
		String trimmed = s.substring( start, end + 1 );
		
		int numInvalid = calcNumInvalid( trimmed );
		if ( numInvalid == 0 )
		{
			result.add( trimmed );
			return result;
		}		
		
		Set<String> isVisited = new HashSet<>();		
		Queue<String> bfsQueue = new LinkedList<>();
		bfsQueue.add( trimmed );
		while ( numInvalid > 0 )
		{
			int levelSize = bfsQueue.size();
			for ( int i = 0; i < levelSize; i++ )
			{
				Set<String> nextLevel = removeOneParenthese( bfsQueue.poll(), numInvalid, bfsQueue, isVisited );
				bfsQueue.addAll( nextLevel );
			}
			numInvalid--;
		}
		return bfsQueue.stream().collect( Collectors.toList() );
	}
	
	private Set<String> removeOneParenthese( String target, int numInvalid, Queue<String> bfsQueue, Set<String> isVisited )
	{
		Set<String> result = new HashSet<>();
		for ( int j = 0; j < target.length(); j++ )
		{
			// trunning for no '(' and ')' parenthese
			if ( target.charAt( j ) != '(' && target.charAt( j ) != ')' )
			{
				continue;
			}
			
			String newString = target.substring( 0, j ) + target.substring( j + 1 ); 
			if ( !isVisited.contains( newString ) )
			{						
				isVisited.add( newString );
				int newInvalid = calcNumInvalid( newString );
				if ( newInvalid < numInvalid )
				{
					result.add( newString );
				}
			}
		}
		return result;
	}
	
	private int calcNumInvalid( String s )
	{
		Stack<Character> stack = new Stack<>();
		for ( char ch : s.toCharArray() )
		{
			if ( ch == '(' || ch == ')' )
			{
				if ( !stack.isEmpty() && stack.peek() == '(' && ch == ')' )
				{
					stack.pop();
				}
				else
				{
					stack.push( ch );
				}
			}
		}
		return stack.size();
	}
}
