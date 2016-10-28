package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

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
		elements.add( val );
		elemToPos.put( val, elements.size() - 1 );
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove( int val )
	{
		if ( !elemToPos.containsKey( val ) )
		{
			return false;
		}
		int removedIndex = elemToPos.get( val );
		if ( removedIndex != elements.size() - 1 )
		{
			int lastValue = elements.get( elements.size() - 1 );
			elements.set( removedIndex, lastValue );
			elemToPos.put( lastValue, removedIndex );
		}

		elemToPos.remove( val );
		elements.remove( elements.size() - 1 );
		return true;
	}
	
	/** Get a random element from the set. */
	public int getRandom( )
	{
		return elements.get( rand.nextInt( elements.size() ) );
	}
	
	/*
["RandomizedSet",
"insert","insert","remove","insert","insert",   [3],[-2],[2],[1],[-3],
"insert","remove","remove","insert","remove",   [-2],[-2],[3],[-1],[-3]
"insert","insert","insert","insert","insert",   [1],[-2],[-2],[-2],[1]
"getRandom","insert","remove","insert","insert"]   [],[-2],[0],[-3],[1]]
	 * */
	@Ignore
	@Test
	public void test()
	{
		RandomizedSet set = new RandomizedSet();
		set.insert( 3 );
		set.insert( -2 );
		set.remove( 2 );
		set.insert( 1 );
		set.insert( -3 );
		
		set.insert( -2 );
		set.remove( -2 );
		set.remove( 3 );
		set.insert( -1 );
		set.remove( -3 );
		
		set.insert( 1 );
		set.insert( -2 );
		set.insert( -2 );
		set.insert( -2 );
		set.insert( 1 );
		
		set.getRandom();
		set.insert( -2 );
		set.remove( 0 );
		set.insert( -3 );
		set.insert( 1 );
	}

	/*
["RandomizedSet",
"insert","remove","insert","remove","getRandom",
"getRandom","getRandom","getRandom","getRandom","getRandom",
"getRandom","getRandom","getRandom","getRandom"]
[[],[0],[0],[-1],[0],[],[],[],[],[],[],[],[],[],[]]
	 * */
	@Test
	public void test2()
	{
		RandomizedSet set = new RandomizedSet();
		set.insert( 0 );
		set.remove( 0 );
		set.insert( -1 );
		set.remove( 0 );
		set.getRandom();
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */