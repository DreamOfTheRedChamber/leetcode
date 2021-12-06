package linkedIn;

/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

https://discuss.leetcode.com/topic/32449/trade-off-in-this-problem-should-be-considered/3
 * */

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIWriteIntensive 
{
	private Map<Integer, Integer> histogram = new HashMap<>();
	
 // Add the number to an internal data structure.
	public void add( int number )
	{
		histogram.put( number, 1 + histogram.getOrDefault( number, 0 )  );
	}

 // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find( int value ) 
	{
		for ( int numOne : histogram.keySet() )
		{			
			int numTwo = value - numOne;
			if ( numOne == numTwo && histogram.get( numOne ) > 1 
					|| numOne != numTwo && histogram.containsKey( numTwo ) ) 				
			{
				return true;
			}
		}		
		return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);