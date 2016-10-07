package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet
{
	private List<Integer> elements;
	private Map<Integer,Integer> elemToPos;	
	private Random rand;
	
	/** Initialize your data structure here. */
	public RandomizedSet( )
	{
		elements = new ArrayList<>();
		elemToPos = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert( int val )
	{
		if ( !elemToPos.containsKey( val ) )
		{
			elements.add( val );
			elemToPos.put( val, elements.size() - 1 );
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove( int val )
	{
		if ( elemToPos.containsKey( val ) )
		{
			int position = elemToPos.get( val );
			swap( elements, elemToPos, position, elements.size() - 1 );
			elements.remove( elements.size() - 1 );
			elemToPos.remove( val );
			return true;
		}
		else
		{
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom( )
	{
		return elements.get( rand.nextInt( elements.size() ) );
	}
	
	private void swap( List<Integer> elements, Map<Integer, Integer> elemToPos, int pos1, int pos2 )
	{
		elemToPos.put( elements.get( pos1 ), pos2 );
		elemToPos.put( elements.get( pos2 ), pos1 );
		
		int buffer = elements.get( pos1 );		
		elements.set( pos1, elements.get( pos2 ) );
		elements.set( pos2, buffer );
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */