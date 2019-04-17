package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utility.Interval;

/*
Given a set of intervals, for each of the interval i, 
check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. 
If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.

Example 1:
Input: [ [1,2] ]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:
Input: [ [3,4], [2,3], [1,2] ]
Output: [-1, 0, 1]
Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.

Example 3:
Input: [ [1,4], [2,3], [3,4] ]
Output: [-1, 2, -1]
Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
*/

public class FindRightInterval
{
	class Point implements Comparable<Point>
	{
		int val;
		int flag; // 1 start, 0 end
		int index;

		public Point(int val, int flag, int index) {
			this.val = val;
			this.flag = flag;
			this.index = index;
		}

		public int compareTo( Point o )
		{
			if ( this.val == o.val )
				return this.flag - o.flag; // end in front of start
			return this.val - o.val;
		}
	}

	public int[] findRightInterval( Interval[] intervals )
	{
		if ( intervals == null || intervals.length == 0 )
			return new int[] {};

		int[] res = new int[intervals.length];
		Arrays.fill( res, -1 );

		List<Point> points = new ArrayList<>();
		for ( int i = 0; i < intervals.length; i++ )
		{
			points.add( new Point( intervals[i].start, 1, i ) );
			points.add( new Point( intervals[i].end, 0, i ) );
		}

		Collections.sort( points );

		List<Integer> prevIdxs = new ArrayList<>();

		for ( Point point : points )
		{
			if ( point.flag == 1 )
			{
				for ( Integer prevIdx : prevIdxs )
				{
					res[prevIdx] = point.index;
				}
				prevIdxs = new ArrayList<>();
			}
			else
			{
				prevIdxs.add( point.index );
			}
		}

		return res;
	}

	public int[] findRightIntervalTreeMap( Interval[] intervals )
	{
		int[] result = new int[intervals.length];
		java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

		for ( int i = 0; i < intervals.length; ++i )
		{
			intervalMap.put( intervals[i].start, i );
		}

		for ( int i = 0; i < intervals.length; ++i )
		{
			Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry( intervals[i].end );
			result[i] = ( entry != null ) ? entry.getValue() : -1;
		}

		return result;
	}
	
	public int[] findRightIntervalBinarySearch( Interval[] intervals )
	{
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> starts = new ArrayList<>();
		for ( int i = 0; i < intervals.length; i++ )
		{
			map.put( intervals[i].start, i );
			starts.add( intervals[i].start );
		}

		Collections.sort( starts );
		int[] res = new int[intervals.length];
		for ( int i = 0; i < intervals.length; i++ )
		{
			int end = intervals[i].end;
			int start = binarySearch( starts, end );
			if ( start < end )
			{
				res[i] = -1;
			}
			else
			{
				res[i] = map.get( start );
			}
		}
		return res;
	}

	private int binarySearch( List<Integer> list, int x )
	{
		int left = 0, right = list.size() - 1;
		while ( left < right )
		{
			int mid = left + ( right - left ) / 2;
			if ( list.get( mid ) < x )
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}
		return list.get( left );
	}
}
