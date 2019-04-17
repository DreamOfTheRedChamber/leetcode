package facebook.easy;

/**
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class AddBinary
{
    public String addBinary( String a, String b )
    {
    	if ( a == null || b == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	    	
    	StringBuilder result = new StringBuilder();
    	
    	int carry = 0;
    	for ( int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j-- )
    	{
    		int aVal = i >= 0 ? a.charAt( i ) - '0' : 0;
    		int bVal = j >= 0 ? b.charAt( j ) - '0' : 0;
    		int sum = aVal + bVal + carry;
    		result.append( sum % 2 );
    		carry = sum / 2;
    	}
    	
    	if ( carry == 1 )
    	{
    		result.append( 1 );
    	}
    	
    	return result.reverse().toString();
    }
}
