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
		if ( s == null )
		{
			return result;
		}
		if ( s.length() == 0 
				|| isValid( s ) )
		{
			result.add( s );
			return result;
		}
		
		Queue<Tuple> bfsQueue = new LinkedList<>();
		bfsQueue.add( new Tuple( s, 0, ')') );
		while ( !bfsQueue.isEmpty() )
		{
			Tuple qHead = bfsQueue.poll();
			for ( int i = qHead.start; i < qHead.string.length(); ++i )
			{
				char ch = qHead.string.charAt( i );
				if ( ch != '(' && ch != ')' ) continue;
				if ( i != qHead.start && qHead.string.charAt( i - 1 ) == ch ) continue;
				if ( qHead.removed == '(' && ch == ')' ) continue;
				
				String next = qHead.string.substring( 0, i ) + qHead.string.substring( i + 1 );
				if ( isValid( next ) )	
				{
					result.add( next );
				}
				else if ( result.isEmpty() )
				{
					bfsQueue.offer( new Tuple( next, i, ch ) );
				}
				
			}
		}
		return result;
	}
	
	private boolean isValid( String s ) 
	{
	    int count = 0;
	    for ( int i = 0; i < s.length(); ++i ) 
	    {
	        char c = s.charAt(i);
	        if ( c == '(' ) ++count;
	        if ( c == ')' && count-- == 0 ) return false;
	    }
	    return count == 0;
	}

	private class Tuple 
	{
	    public final String string;
	    public final int start;
	    public final char removed;

	    public Tuple( String string, int start, char removed ) 
	    {
	        this.string = string;
	        this.start = start;
	        this.removed = removed;
	    }
	}
}
