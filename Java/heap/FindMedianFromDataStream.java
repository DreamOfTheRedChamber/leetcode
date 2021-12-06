package heap;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class FindMedianFromDataStream 
{
	// larger half
	private PriorityQueue<Integer> largerHalf = new PriorityQueue<>( ( o1, o2 ) -> ( o1 - o2 ) );
	// smaller half
	private PriorityQueue<Integer> smallerHalf = new PriorityQueue<>( ( o1, o2 ) -> ( o2 - o1 ) );
	
 // Adds a number into the data structure.
 public void addNum( int num )
 {
 	if ( largerHalf.size() == 0 )
 	{
 		largerHalf.add( num );
 	}
 	else if ( smallerHalf.size() == 0 )
 	{
 		if ( num >= largerHalf.peek() )
 		{
 			smallerHalf.add( largerHalf.remove() );
 			largerHalf.add( num );
 		}
 		else
 		{
 			smallerHalf.add( num );
 		}
 	}
 	else if ( smallerHalf.size() == largerHalf.size() )
 	{
 		if ( num >= smallerHalf.peek() )
 		{
 			largerHalf.add( num );
 		}
 		else
 		{
 			largerHalf.add( smallerHalf.remove() );
 			smallerHalf.add( num );
 		}
 	}
 	else if ( smallerHalf.size() + 1 == largerHalf.size() )
 	{
 		if ( num >= largerHalf.peek() )
 		{
 			smallerHalf.add( largerHalf.remove() );
 			largerHalf.add( num );
 		}
 		else
 		{
 			smallerHalf.add( num );
 		}
 	}
 	else
 	{
 		throw new IllegalArgumentException("");
 	}
 }

 // Returns the median of current data stream
 public double findMedian() 
 {
 	if ( largerHalf.size() == 0 )
 	{
 		return 0;
 	}
 	
 	if ( smallerHalf.size() == largerHalf.size() )
 	{
 		return ( ( double ) smallerHalf.peek() + largerHalf.peek() ) / 2;
 	}
 	else
 	{
 		return ( double ) largerHalf.peek();
 	}
 }
 
 private static final double DELTA = 1e-15;

 @Test
 public void test()
 {
 	FindMedianFromDataStream obj = new FindMedianFromDataStream();
 	obj.addNum( 3 );
 	assertEquals( 3, obj.findMedian(), DELTA );
 	obj.addNum( 8 );
 	assertEquals( 5.5, obj.findMedian(), DELTA );
 	obj.addNum( 4 );
 	assertEquals( 4, obj.findMedian(), DELTA );
 	obj.addNum( 5 );
 	assertEquals( 4.5, obj.findMedian(), DELTA );
 	obj.addNum( 7 );
 	assertEquals( 5, obj.findMedian(), DELTA );
 	obj.addNum( 6 );
 	assertEquals( 5.5, obj.findMedian(), DELTA );
 	obj.addNum( 2 );
 	assertEquals( 5, obj.findMedian(), DELTA );
 }
}
