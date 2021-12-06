package linkedIn;

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
   "This is an",
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
 	   for ( int i = 0; i < numWords; i++ )
 	   {
 		   numSpaces -= words[i + startPos].length();
 	   }
 	   int average = numSpaces / ( numWords - 1 );
 	   int residual = numSpaces % ( numWords - 1 );
 	    	   
 	   StringBuilder currLine = new StringBuilder();
 	   for ( int i = 0; i < numWords - 1; i++ )
 	   {
 		   currLine.append( words[startPos + i] );
 		   
 		   for ( int j = 0; j < average; j++ )
 		   {
 			   currLine.append(' ');
 		   }	 		   
 		   if ( residual > 0 )
 		   {
 			   currLine.append(' ');
 			   residual--;
 		   }
 	   }
 	   currLine.append( words[startPos + numWords - 1] );
 	   result.add( currLine.toString() );
	}
	
	private int calcNumWords( int startPos, String[] words, int maxWidth )
	{
		int numWords = 0;
		int lineLength = 0;
		while ( startPos + numWords < words.length && words[startPos + numWords].length() + lineLength <= maxWidth )
		{
			lineLength += words[startPos + numWords].length();
			lineLength += 1;
			numWords++;
		}
		return numWords;
	}
	
 public List<String> fullJustify( String[] words, int maxWidth )
 {
    List<String> result = new ArrayList<>();
    
    for ( int endPos = 0; endPos < words.length; )
    { 	    	   
 	   // calculate num of words in this line
 	   int startPos = endPos;
 	   int numWords = calcNumWords( endPos, words, maxWidth );
 	   endPos += numWords;

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
