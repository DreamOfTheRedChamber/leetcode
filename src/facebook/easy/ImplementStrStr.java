package facebook.easy;

/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * */

public class ImplementStrStr 
{
    public int strStr( String haystack, String needle )
    {
    	if ( haystack == null || needle == null || needle.length() == 0 )
    	{
    		return 0;
    	}
    	
    	for ( int i = 0; i < haystack.length() - needle.length() + 1; i++ )
    	{
    		for ( int haystackIndex = i, needleIndex = 0; needleIndex < needle.length(); haystackIndex++, needleIndex++ )
    		{
    			if ( haystack.charAt( haystackIndex ) != needle.charAt( needleIndex ) )
    			{
    				break;
    			}
    			if ( needleIndex == needle.length() - 1 )
    			{
    				return i;
    			}
    		}
    	}
    	return -1;
    }
}