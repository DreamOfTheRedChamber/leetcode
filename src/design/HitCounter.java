package design;

import java.util.PriorityQueue;

public class HitCounter
{
	private PriorityQueue<Integer> pastFiveMinHits;
	private final static int FIVE_MINUTES = 299;
	
	/** Initialize your data structure here. */
	public HitCounter( )
	{
		pastFiveMinHits = new PriorityQueue<>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit( int timestamp )
	{
		pastFiveMinHits.offer( timestamp );
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