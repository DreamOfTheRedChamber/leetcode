package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */

public class RepeatDNASequences
{

    public List<String> findRepeatedDnaSequences(String s) 
    {
    	// compute histogram
        Map<String, Integer> sequenceHistogram = new HashMap<>();
    	for ( int i = 0; i < s.length() - 10; i++ )
        {
    		String sequence = s.substring( i, i + 10 );
        	sequenceHistogram.put( sequence, sequenceHistogram.getOrDefault( sequence, 0 ) + 1 );
        }
        
        // find substrings occuring more than once
    	List<String> repeatedSequence = new ArrayList<>();
    	for ( Map.Entry<String, Integer> entry : sequenceHistogram.entrySet( ) )
    	{
    		if ( entry.getValue( ) > 1 )
    		{
    			repeatedSequence.add( entry.getKey( ) );
    		}
    	}
    	return repeatedSequence;
    }

}
