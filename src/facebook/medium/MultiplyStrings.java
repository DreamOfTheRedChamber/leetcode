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
    	int carry = 0, product = 0, i, j;
    	for ( i = num1.length() - 1; i >= 0; i-- )
    	{
    		carry = 0;
    		for ( j = num2.length() - 1; j >= 0; j-- )
    		{
    			product = carry + buffer[ i + j + 1 ] + Character.getNumericValue( num1.charAt( i ) ) * Character.getNumericValue( num2.charAt( j ) );
    			buffer[ i + j + 1 ] = product % 10;
    			carry = product / 10;
    		}
    		buffer[ i + j + 1 ] = carry;
    	}
    	
    	StringBuilder result = new StringBuilder();
    	i = 0;
    	while ( i < num1.length() + num2.length() )
    	{
    		i++;
    	}
    	
    	while ( i < num1.length() + num2.length() )
    	{
    		result.append( buffer[ i++ ] );
    	}
    	
    	return result.toString();
    }
}