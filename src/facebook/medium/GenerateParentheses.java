package facebook.medium;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * */
public class GenerateParentheses 
{
	@Test
	public void test()
	{
		System.out.println( generateParenthesis( 3 ) );
	}
	
    public List<String> generateParenthesis( int n )
    {
    	List<String> result = new LinkedList<>();
    	generateParenthesis( result, new StringBuilder(), n, n );
    	return result;
    }
    
    private void generateParenthesis( List<String> result, StringBuilder currStr, int left, int right )
    {
    	if ( left == 0 && right == 0 )
    	{
    		result.add( currStr.toString() );
    		return;
    	}
    	
    	if ( left > 0 )
    	{
    		currStr.append( '(' );
    		generateParenthesis( result, currStr, left - 1, right );
    		currStr.deleteCharAt( currStr.length() - 1 );
    	}
    	if ( right > 0 && left < right )
    	{
	    	currStr.append( ')' );
	    	generateParenthesis( result, currStr, left, right -1 );
	    	currStr.deleteCharAt( currStr.length() - 1 );
    	}
    }
}