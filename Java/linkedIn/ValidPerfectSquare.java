package linkedIn;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 * */

public class ValidPerfectSquare 
{
 public boolean isPerfectSquare( int num )
 {
 	if ( num <= 0 )
 	{
 		return false;
 	}
 	
 	// whether can find perfect sqrt root
 	int start = 1;
 	int end = num;
 	while ( start + 1 < end )
 	{
 		int mid = ( end - start ) / 2 + start;
 		if ( num / mid < mid )
 		{
 			end = mid;
 		}
 		else
 		{
 			start = mid;
 		}
 	}
 	
 	if ( start * start == num 
 			|| end * end == num )
 	{
 		return true;
 	}
 	else
 	{
 		return false;
 	}
 }
}
