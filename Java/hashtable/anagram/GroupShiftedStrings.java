package hashtable.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */

public class GroupShiftedStrings
{

    public List<List<String>> groupStrings(String[] strings) 
    {
        Map<String, List<String>> groupedStrings = new HashMap<>();

        for ( String originalStr : strings )
        {
        	String shiftedStr = shiftString( originalStr );
        	groupedStrings.putIfAbsent( shiftedStr, new ArrayList<>() );
        	groupedStrings.get( shiftedStr ).add( originalStr );
        }
        
        return groupedStrings.values( )
        					.stream( )
        					.collect( Collectors.toList( ) );
    }

    private String shiftString( String originalStr )
    {
    	StringBuilder shiftedStr = new StringBuilder();
    	int shiftDist = originalStr.charAt( 0 ) - 'a' ;
    	for ( char ch : originalStr.toCharArray( ) )
    	{
    		// map shifted char into 0-25
    		int shiftedInteger = ( ch - 'a' - shiftDist + 26 ) % 26;
    		char shiftedCh = (char) ( 'a' + shiftedInteger );
    		shiftedStr.append( shiftedCh );
    	}
    	return shiftedStr.toString( );
    }
    
    @Test
    public void test()
    {
    	System.out.println( groupStrings( new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}) );
    }
}
