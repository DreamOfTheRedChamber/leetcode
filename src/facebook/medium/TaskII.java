package facebook.medium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
followup是tasks是无序的.
一开始是有序的，比如说1, 1, 2, 1，一定要先执行第一个task1，然后等task1恢复，再执行第2个task1，再执行task2..... 
followup是无序的，就是不用按给的顺序执行，也就是可以先执行task1，然后task1还没恢复时，先执行task2, etc...... 
*/

public class TaskII
{
	@Test
	public void test()
	{
		assertEquals( 6, calcShortSchedule( new int[]{ 1, 1, 2, 2, 3, 3 }, 2 ) );
		assertEquals( 10, calcShortSchedule( new int[]{ 1, 1, 1, 1, 2, 2, 3 }, 2 ) );
	}
	
	public int calcShortSchedule( int[] tasks, int recover )
	{
		Map<Integer, Integer> histogram = new HashMap<>();
		for ( int task : tasks )
		{
			histogram.put( task, histogram.getOrDefault( task, 0 ) + 1 );
		}
		Queue<Elem> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> o2.freq - o1.freq );
		for ( Map.Entry<Integer, Integer> entry : histogram.entrySet() )
		{
			maxQueue.add( new Elem( entry.getKey(), entry.getValue() ) );
		}

		int time = 0;
		Map<Integer, Integer> taskToNextAppear = new HashMap<>();
		while ( !maxQueue.isEmpty() )
		{
			Iterator<Elem> iterator = maxQueue.iterator();
			Elem nextTask = null;
			while ( iterator.hasNext() )
			{
				Elem nextValue = iterator.next();
				if ( !taskToNextAppear.containsKey( nextValue.value ) || taskToNextAppear.get( nextValue.value ) <= time )
				{
					nextTask = nextValue;
					break;
				}
			}
			
			if ( nextTask == null )
			{
				time++;
			}
			else
			{
				if ( nextTask.freq == 1 )
				{
					maxQueue.remove( nextTask );
				}
				else
				{
					nextTask.freq = nextTask.freq - 1;
				}
				taskToNextAppear.put( nextTask.value, time + recover + 1 );
				time++;
			}
		}
		
		return time;
	}
	
	class Elem
	{
		public int value;
		public int freq;
		public Elem( int val, int freq )
		{
			this.value = val;
			this.freq = freq;
		}
	}
}