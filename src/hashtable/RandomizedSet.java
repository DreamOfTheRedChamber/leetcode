package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
		if ( elemToPos.containsKey( val ) )
		{
			return false;
		}
		else
		{
			elements.add( val );
			elemToPos.put( val, elements.size() - 1 );
			return true;
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
			int removedIndex = elemToPos.get( val );
			elemToPos.remove( val );
			moveLastToRemovedIndex( removedIndex );
			return true;
		}
		else
		{
			return false;
		}
	}

	private void moveLastToRemovedIndex( int removedIndex )
	{
		elements.set( removedIndex, elements.get( elements.size() - 1 ) );
		elements.remove( elements.size() - 1 );
	}
	
	/** Get a random element from the set. */
	public int getRandom( )
	{
		int randomPos = rand.nextInt( elements.size() );
		return elements.get( randomPos );
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */