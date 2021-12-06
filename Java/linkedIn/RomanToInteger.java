package linkedIn;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * */

public class RomanToInteger 
{
 public int romanToInt( String s ) 
 {
 	if ( s == null || s.length() == 0 )
 	{
 		return 0;
 	}
 	
 	Map<Character, Integer> charToVal = new HashMap<>();
  charToVal.put( 'I', 1 );
  charToVal.put( 'V', 5 );
  charToVal.put( 'X', 10 );
  charToVal.put( 'L', 50 );
  charToVal.put( 'C', 100 );
  charToVal.put( 'D', 500 );
  charToVal.put( 'M', 1000 );
  
  int result = charToVal.get( s.charAt( 0 ) );
  for ( int i = 1; i < s.length(); i++ )
  {
  	if ( charToVal.get( s.charAt( i ) ) > charToVal.get( s.charAt( i - 1 ) ) )
  	{
  		result += charToVal.get( s.charAt( i ) );
  		result -= 2 * charToVal.get( s.charAt( i - 1 ) );
  	}
  	else
  	{
  		result += charToVal.get( s.charAt( i ) );
  	}
  }
  return result;
 }
 
 @Test
 public void test()
 {
 	assertEquals( 6, romanToInt( "VI" ) );
 	assertEquals( 4, romanToInt( "IV" ) );
 }
}
