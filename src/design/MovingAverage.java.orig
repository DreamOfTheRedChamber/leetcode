
package design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage
{

	private int maxWindSize;
	private Queue<Integer> currWind;
	private int sum;
	
	/** Initialize your data structure here. */
	public MovingAverage( int size )
	{
		currWind = new LinkedList<>();
		maxWindSize = size;
		sum = 0;
	}

	public double next( int val )
	{
		if ( currWind.size() < maxWindSize )
		{
			sum += val;
			
			currWind.add( val );
		}
		else
		{
			sum -= currWind.remove();
			sum += val;
			
			currWind.add( val );
		}
		
		return ( double )( sum ) / currWind.size();		
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */