package sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII 
{
	private Map<Integer, Integer> numToFreqMap = new HashMap<>();
	
    // Add the number to an internal data structure.
	public void add( int number )
	{
		numToFreqMap.put( number, numToFreqMap.getOrDefault( number, 1 )  );
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find( int value ) 
	{
		for ( Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet() )
		{
			int key = entry.getKey();
			int freq = entry.getValue();
			
			if ( ( value == key + key )
				&& ( freq > 1 ) ) 
			{
				return true;
			}
			
			if ( numToFreqMap.containsKey( value - key ) )
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