package dp.oneSequence;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak
{
    public boolean wordBreak( String s, Set<String> wordDict )
    {
    	boolean[] canBreak = new boolean[s.length( )+1];
    	canBreak[0] = true;
    	int maxLength = getMaxLength( wordDict );
    	for ( int i = 1; i <= s.length() ; i++ )
    	{    		    		
    		for ( int lastWordLength = 1; lastWordLength <= i && lastWordLength <= maxLength; lastWordLength++ )
    		{
    			if ( !canBreak[i-lastWordLength] )
    			{
    				continue;
    			}
    			String lastWord = s.substring( i - lastWordLength, i );
    			if ( wordDict.contains( lastWord ) )
    			{
    				canBreak[i] = true;
    				break;
    			}
    		}
    	}    	
    	return canBreak[s.length( )];
    }
    
    private int getMaxLength( Set<String> dict )
    {
    	int maxLength = 0;
    	for ( String word : dict )
    	{
    		maxLength = Math.max( maxLength, word.length() );
    	}
    	return maxLength;
    }
    
    @Test
    public void test()
    {
    	Set<String> words = new HashSet<>();
    	words.add( "leet" );
    	words.add( "code" );
    	assertTrue( wordBreak( "leetcode", words ) );
    }
}
