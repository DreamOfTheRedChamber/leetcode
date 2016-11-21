package string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
*/

public class TextJustification
{
	@Test
	public void test()
	{
		System.out.println( fullJustify( new String[]{ "This", "is", "an", "example", "of", "text", "justification" }, 16 ) );
		System.out.println( fullJustify( new String[]{ "What", "must", "be", "shall", "be" }, 12 ) );
	}
	
	private void leftAlign( List<String> result, String[] words, int startPos, int numWords, int maxWidth )
	{
		StringBuilder currLine = new StringBuilder();
		for ( int i = 0; i < numWords; i++ )
		{
			currLine.append( words[startPos + i] );
			currLine.append( ' ' );
		}
		if ( currLine.length() > maxWidth )
		{
			currLine.deleteCharAt( currLine.length() - 1 );
		}
		
		for ( int i = 0; i < maxWidth - currLine.length(); i++ )
		{
			currLine.append( ' ' );
		}
		result.add( currLine.toString() );
	}
	
	private void evenlyDisperse( List<String> result, String[] words, int startPos, int numWords, int maxWidth )
	{
 	   int numSpaces = maxWidth;
 	   for ( int currPos = startPos; currPos < startPos + numWords; currPos++ )
 	   {
 		   numSpaces -= words[currPos].length();
 	   }    	   
 	   int averageSpaces = numSpaces / ( numWords - 1 );
 	   int additionSpaces = numSpaces % ( numWords - 1 );
 	       	   
 	   StringBuilder currLine = new StringBuilder();
 	   for ( int currPos = startPos; currPos < startPos + numWords; currPos++ )
 	   {
 		   // append word
 		   currLine.append( words[currPos] );
 		   
 		   if ( currPos != startPos + numWords - 1 )
 		   {
	    		   // append space
	    		   for ( int i = 0; i < averageSpaces; i++ )
	    		   {
	    			   currLine.append(' ');
	    		   }
	    		   
	    		   // append additional space
	    		   if ( additionSpaces > 0 )
	    		   {
	    			   currLine.append(' ');
	    			   additionSpaces--;
	    		   }
 		   }    		   
 	   }
 	   // build this line
 	   result.add( currLine.toString() );

	}
	
    public List<String> fullJustify( String[] words, int maxWidth )
    {
       List<String> result = new ArrayList<>();
       int endPos = 0;
       while ( endPos < words.length )
       {
    	   // calculate num of words in this line
    	   int startPos = endPos;
    	   for ( int usedCharNum = 0; endPos < words.length && usedCharNum + words[endPos].length() <= maxWidth; usedCharNum++, endPos++ ) // usedCharNum++ is used for white spaces
    	   {
    		   usedCharNum += words[endPos].length();
    	   }
    	   int numWords = endPos - startPos;

    	   // handle edge case: single word a line or last line
    	   if ( numWords == 1 
    			   || endPos == words.length )
    	   {
    		   leftAlign( result, words, startPos, numWords, maxWidth );
    	   }
    	   else
    	   {
    		   evenlyDisperse( result, words, startPos, numWords, maxWidth );
    	   }
       }
       
       return result;
    }
}
