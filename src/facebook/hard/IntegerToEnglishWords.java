package facebook.hard;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

public class IntegerToEnglishWords
{
    public String numberToWords( int num )
    {
        String[] bigs = new String[]{ " Thousand", " Million", " Billion" };
        StringBuilder result = new StringBuilder();
        int i = 0;
        result.append( convertToWords( num % 1000 ) + bigs[i] );
        num /= 1000;
        
        while ( num > 0 )
        {
        	if ( num % 1000 != 0 )
        	{
        		result.insert( 0, convertToWords( num % 1000 ) + bigs[i] );
        	}
        	i++;
        	num /= 1000;
        }
        return result.length() == 0 ? "Zero" : result.toString().trim();
    }
    
    public String convertToWords( int num )
    {
        String[] digit = {"", " One", " Two", " Three", " Four", " Five",
                " Six", " Seven", " Eight", " Nine"};
        String[] tenDigit = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen",
                " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] tenMutipleDigit = {"", "", " Twenty", " Thirty", " Forty", " Fifty",
                " Sixty", " Seventy", " Eighty", " Ninety"};
        StringBuilder sb = new StringBuilder();
        if ( num >= 100 )
        {
            sb.append( digit[num / 100] ).append(" Hundred");
            num %= 100;
        }
        if ( num > 9 && num < 20 )
        {
            sb.append( tenDigit[num - 10] );
        } 
        else 
        {
            if ( num >= 20 )
            {
                sb.append( tenMutipleDigit[num / 10] );
                num %= 10;
            }
            sb.append( digit[num] );
        }
        return sb.toString();
    }

}
