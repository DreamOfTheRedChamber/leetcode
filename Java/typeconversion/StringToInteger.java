package typeconversion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */

public class StringToInteger
{

 public int myAtoi( String str )
 {
 	if ( str == null || str.length() == 0 )
 	{
 		return 0;
 	}
 	
 	// trim beginning and trailing spaces
 	str = str.trim();
 	int index = 0;
 	
 	// apply sign
 	int sign = 1;
 	if ( str.charAt( index ) == '-' )
 	{
 		index++;
 		sign = -1;
 	}
 	else if ( str.charAt( index ) == '+' )
 	{
 		index++;
 		sign = 1;
 	}
 	
 	// calculate result
 	long result = 0;
 	for ( int i = index; i < str.length(); i++ )
 	{
 		if ( str.charAt( i ) < '0' || str.charAt( i ) > '9' )
 		{
 			break;
 		}
 		result = result * 10 + ( str.charAt( i ) - '0' );
 		if ( result > Integer.MAX_VALUE )
 		{
 			break;
 		}
 	}
 	
 	// return result
 	if ( result * sign >= Integer.MAX_VALUE )
 	{
 		return Integer.MAX_VALUE;
 	}
 	if ( result * sign <= Integer.MIN_VALUE )
 	{
 		return Integer.MIN_VALUE;
 	}
 	return ( int ) result * sign;
 }
 
 @Test
 public void test()
 {
 	assertEquals( 0, myAtoi( "-" ) );
 	assertEquals( 1, myAtoi( "+1" ) );
 	assertEquals( -1, myAtoi( "-1" ) );
 	assertEquals( 10, myAtoi( "   010" ) );
 	assertEquals( Integer.MAX_VALUE, myAtoi( "9223372036854775809" ) );
 }
}
