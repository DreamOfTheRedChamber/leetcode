package facebook.easy;

import java.util.HashSet;
import java.util.Set;

/*
* Given an integer k>=1 and two strings A and B (length ~n each);
 * Figure out if there is any common substring of length at least k.
 * (i.e. any string of length at least k, that is a substring of both A and B)
 *
 *  A="facebook", B="bookshelf", k=3  ==> true
           ^^^       ^^^
 *  A="facebook", B="bookshelf", k=4  ==> true
           ^^^^      ^^^^
 *  A="facebook", B="bookshelf", k=5  ==> false
 *  
 *  follow up: How to optimize?
 * */

public class ImplementStrStrVariants 
{
	public boolean check( String A, String B, int k )
	{
		Set<String> substrB = new HashSet<>();
		for ( int i = 0; i < B.length() - k; i++ )
		{
			substrB.add( B.substring( i, i + k ) );
		}
		
		for ( int i = 0; i < A.length() - k; i++ )
		{
			if ( substrB.contains( A.substring( i, i + k ) ) )
			{
				return true;
			}
		}
		return false;
	}
}
