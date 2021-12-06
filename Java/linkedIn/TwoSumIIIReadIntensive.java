package linkedIn;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIIIReadIntensive
{
	private Set<Integer> existingNums = new HashSet<>();
	private Set<Integer> existingSums = new HashSet<>();
	
 // Add the number to an internal data structure.
	public void add( int number )
	{
		if ( existingNums.contains ( number ) )
		{
			existingSums.add ( number * 2 );
		}
		else
		{
			for ( int num : existingNums )
			{
				existingSums.add( num + number );
			}
			existingNums.add( number );
		}
	}

 // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find( int value )
	{
	 return existingSums.contains ( value );
	}
}