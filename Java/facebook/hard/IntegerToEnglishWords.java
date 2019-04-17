package facebook.hard;

import org.junit.Test;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12 345 -> "Twelve Thousand Three Hundred Forty Five"
1 234 567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

public class IntegerToEnglishWords
{
    public String numberToWords( int num )
    {
        String[] bigs = new String[]{ "", " Thousand", " Million", " Billion" };
        StringBuilder result = new StringBuilder();

        for ( int i = 0; num > 0; i++, num /= 1000 )
        {
        	if ( num % 1000 != 0 )
        	{
        		result.insert( 0, convertToWords( num % 1000 ) + bigs[i] );
        	}
        }

        return result.length() == 0 ? "Zero" : result.toString().trim();
    }
    
    private String convertToWords( int num )
    {
        String[] singleDigit = { "", " One", " Two", " Three", " Four", " Five",
                " Six", " Seven", " Eight", " Nine" };
        String[] tenDigit = { " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen",
                " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
        String[] biggerThanTwenty = { "", "", " Twenty", " Thirty", " Forty", " Fifty",
                " Sixty", " Seventy", " Eighty", " Ninety" };
        
        StringBuilder sb = new StringBuilder();
        if ( num >= 100 )
        {
            sb.append( singleDigit[num / 100] ).append(" Hundred");
            num %= 100;
        }

        if ( num >= 20 )
        {
            sb.append( biggerThanTwenty[num / 10] );
            num %= 10;
            sb.append( singleDigit[num] );
        }
        else if ( num > 9 && num < 20 )
        {
            sb.append( tenDigit[num - 10] );
        } 
        else
        {
            sb.append( singleDigit[num] );        	
        }
        
        return sb.toString();
    }

    @Test
    public void test()
    {
    	System.out.println( numberToWords( 1234567 ) );
    	System.out.println( numberToWords( 12345 ) );
    	System.out.println( numberToWords( 123 ) );
    }
}
