package facebook.medium;

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
    	boolean[] canBreak = new boolean[s.length( )+1]; // whether first i characters can be broken
    	canBreak[0] = true;
    	for ( int i = 1; i <= s.length() ; i++ )
    	{    		    		
    		for ( int lastWordLength = 1; lastWordLength <= i; lastWordLength++ )
    		{
    			if ( canBreak[i - lastWordLength] 
    				&& wordDict.contains( s.substring( i - lastWordLength, i ) ) )
    			{
    				canBreak[i] = true;
    				break;
    			}
    		}
    	}    	
    	return canBreak[s.length( )];
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
