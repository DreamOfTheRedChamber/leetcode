package hashtable.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class RandomizedSet
{
	private List<Integer> list;
	private Map<Integer,Integer> valToIndex;	
	private Random rand;
	
	/** Initialize your data structure here. */
	public RandomizedSet( )
	{
		list = new ArrayList<>();
		valToIndex = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert( int val )
	{
		if ( valToIndex.containsKey( val ) )
		{
			return false;
		}
		list.add( val );
		valToIndex.put( val, list.size() - 1 );
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove( int val )
	{
		if ( !valToIndex.containsKey( val ) )
		{
			return false;
		}
		if ( valToIndex.get( val ) == list.size() - 1 )
		{
			valToIndex.remove( val );
			list.remove( list.size() - 1 );
		}
		else
		{
			int indexToRemove = valToIndex.get( val );
			int lastValue = list.get( list.size() - 1 );
			valToIndex.put( lastValue, indexToRemove );
			valToIndex.remove( val, indexToRemove );
			list.set( indexToRemove, lastValue );
		}
		return true;
	}
	
	/** Get a random element from the set. */
	public int getRandom( )
	{
		return list.get( rand.nextInt( list.size() ) );
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