
package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PhoneDirectory
{
	private Set<Integer> usedNumbers;
	private PriorityQueue<Integer> availableNumbers;
	private final static int MIN_BOUND = 1;
	private int maxNumbers;
	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *   - The maximum numbers that can be stored in the phone
	 *   directory.
	 */
	public PhoneDirectory( int maxNumbers )
	{
		usedNumbers = new HashSet<>();
		availableNumbers = new PriorityQueue<>();
		this.maxNumbers = maxNumbers;
		for ( int i = MIN_BOUND; i < MIN_BOUND + maxNumbers; i++ )
		{
			availableNumbers.offer( i );
		}
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get( )
	{
		int minAvailableNum = availableNumbers.poll();
		usedNumbers.add( minAvailableNum );
		return minAvailableNum;
	}

	/** Check if a number is available or not. */
	public boolean check( int number )
	{
		if ( ( number < MIN_BOUND + maxNumbers )
				&& ( number >= MIN_BOUND )
				&& ( !usedNumbers.contains( number ) )
				)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/** Recycle or release a number. */
	public void release( int number )
	{
		usedNumbers.remove( number );
		availableNumbers.add( number );
	}
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers); int param_1 = obj.get();
 * boolean param_2 = obj.check(number); obj.release(number);
 */