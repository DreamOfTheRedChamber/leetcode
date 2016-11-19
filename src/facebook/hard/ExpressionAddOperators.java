package facebook.hard;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
public class ExpressionAddOperators
{
	@Test
	public void test()
	{
		System.out.println( addOperators( "123", 6 ) );
		System.out.println( addOperators( "232", 8 ) );
		System.out.println( addOperators( "105", 5 ) );
		System.out.println( addOperators( "00", 0 ));
	}
	
    public List<String> addOperators( String num, int target )
    {
    	List<String> result = new LinkedList<>();
    	addOperators( num, target, result, 0, 0, "" );
    	return result;
    }
    
    private void addOperators( String toBeParsed, int target, List<String> result, long currSum, long prevSum, String dfsPath )
    {
    	if ( toBeParsed.length() == 0 && currSum == target )
    	{
    		result.add( dfsPath );
    		return;
    	}
    	
    	for ( int i = 1; i <= toBeParsed.length(); i++ )
    	{
    		String numStr = toBeParsed.substring( 0, i );
    		if ( numStr.length() > 1 && numStr.charAt( 0 ) == '0' )
    		{
    			return;
    		}
    		long num = Long.parseLong( numStr );
    		String remainedStr = toBeParsed.substring( i );
    		if ( dfsPath.length() > 0 )
    		{
    			addOperators( remainedStr, target, result, currSum + num, currSum, dfsPath + "+" + numStr );
    			addOperators( remainedStr, target, result, currSum - num, currSum, dfsPath + "-" + numStr );
    			addOperators( remainedStr, target, result, ( currSum - prevSum ) * num + prevSum, prevSum, dfsPath + "*" + numStr );
    		}
    		else
    		{
    			addOperators( remainedStr, target, result, currSum + num, currSum, numStr );
    		}
    	}    	
    }       
}