package facebook.medium;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/*
Find the K closest points to the origin in 2D plane, given an array containing N points. You can assume K is much smaller than N and N is very large.
 * */

public class KClosestPointsToAGivenPointInA2DPlane 
{
	public List<Point> getClosestPoints( List<Point> points, int k )
	{
		Queue<Point> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> getDistance( o2 ) - getDistance( o1 ) );
		Iterator<Point> iterator = points.iterator();
		while ( maxQueue.size() < k && iterator.hasNext() )
		{
			maxQueue.offer( iterator.next() );
		}
		
		while ( iterator.hasNext() )
		{
			Point nextPoint = iterator.next();
			if ( getDistance( nextPoint ) < getDistance( maxQueue.peek() ) )
			{
				maxQueue.poll();
				maxQueue.offer( nextPoint );
			}
		}
		
		return maxQueue.stream().collect( Collectors.toList() );
	}
	
	public int getDistance( Point point )
	{
		return point.x * point.x + point.y * point.y;
	}
	
	class Point
	{
		public int x;
		public int y;		
	}
}
