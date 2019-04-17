package facebook.medium;

/**
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
 */

public class MultiplyStrings
{
    public String multiply( String num1, String num2 )
    {
    	if ( num1 == null || num2 == null )
    	{
    		return null;
    	}
    	
    	int[] buffer = new int[num1.length() + num2.length()];
    	for ( int i = num1.length() - 1; i >= 0; i-- )
    	{
    		for ( int j = num2.length() - 1; j >= 0; j-- )
    		{
    			int product = ( num1.charAt( i ) - '0' ) * ( num2.charAt( j ) - '0' );
    			int sum = product + buffer[i + j + 1];
    			buffer[ i + j + 1 ] = sum % 10;
    			buffer[ i + j ] += sum / 10;
    		}
    	}
    	
    	StringBuilder result = new StringBuilder();
    	for ( int digit : buffer )
    	{
    		if ( !( result.length() == 0 && digit == 0 ) )
    		{
    			result.append( digit );
    		}
    	}
    	return result.length() == 0 ? "0" : result.toString();
    }
}