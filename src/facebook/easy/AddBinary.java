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
    	
    	if ( a.length() < b.length() )
    	{
    		return addBinary( b, a );
    	}
    	
    	StringBuilder result = new StringBuilder();
    	int aIndex = a.length() - 1;
    	int bIndex = b.length() - 1;
    	int carry = 0;
    	while ( aIndex >= 0 && bIndex >= 0 )
    	{
    		int sum = a.charAt( aIndex ) - '0' + b.charAt( bIndex ) - '0' + carry;
    		result.append( sum % 2 );
    		carry = sum / 2;
    		
    		aIndex--;
    		bIndex--;
    	}
    	
    	while ( aIndex >= 0 )
    	{
    		int sum = a.charAt( aIndex ) - '0' + carry;
    		result.append( sum % 2 );
    		carry = sum / 2;
    		
    		aIndex--;
    	}
    	
    	if ( carry == 1 )
    	{
    		result.append( 1 );
    	}
    	
    	return result.reverse().toString();
    }
}
