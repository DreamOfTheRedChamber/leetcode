package facebook.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import utility.Interval;

/**
 * interval [startTime, stoptime)   ----integral  time stamps
给这样的一串区间 I1, I2......In  
找出 一个 time stamp  出现在interval的次数最多。
startTime <= t< stopTime 代表这个数在区间里面出现过。
example：  [1,3),  [2, 7),   [4,  8),   [5, 9)
5和6各出现了三次， 所以答案返回5，6。  (Hard)
 */

public class MostFrequentTimeStamp
{
	public List<Integer> sweepLineMostFreq( Interval[] intervals )
	{
		if ( intervals == null || intervals.length == 0 )
		{
			return new LinkedList<>();
		}
		List<Pair> stamps = new LinkedList<>();
		for ( Interval interval : intervals )
		{
			stamps.add( new Pair( interval.start, 1 ) );
			stamps.add( new Pair( interval.end - 1, -1 ) );
		}
		
		stamps.sort( ( o1, o2 ) -> o1.point == o2.point ? o1.point - o2.point : o1.flag - o2.flag );
		int maxOverLapNum = 0;
		int currOverLapNum = 0;
		List<Integer> mostFreqTS = new LinkedList<>();
		for ( Pair pair : stamps )
		{
			currOverLapNum += pair.flag;
			if ( currOverLapNum > maxOverLapNum )
			{
				mostFreqTS = new LinkedList<>();
				mostFreqTS.add( pair.point );
			}
			else if ( currOverLapNum == maxOverLapNum )
			{
				mostFreqTS.add( pair.point );
			}
		}
		
		return mostFreqTS;
	}
	
	class Pair
	{
		public final int point;
		public final int flag;
		public Pair( int point, int flag )
		{
			this.point = point;
			this.flag = flag;
		}
	}
}
