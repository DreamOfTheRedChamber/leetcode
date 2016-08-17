package design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter
{
	private Queue<Integer> pastFiveMinHits;
	private final static int FIVE_MINUTES = 299;
	
	/** Initialize your data structure here. */
	public HitCounter( )
	{
		pastFiveMinHits = new LinkedList<>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit( int timestamp )
	{
		pastFiveMinHits.add( timestamp );
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits( int timestamp )
	{
		while ( !pastFiveMinHits.isEmpty() 
				&& pastFiveMinHits.peek() + FIVE_MINUTES <= timestamp )
		{
			pastFiveMinHits.poll();
		}
		return pastFiveMinHits.size();
	}
}

/**
 * Your HitCounter object will be instantiated and called as such: HitCounter
 * obj = new HitCounter(); obj.hit(timestamp); int param_2 =
 * obj.getHits(timestamp);
 */