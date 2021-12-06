package linkedIn;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

/**
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();

 */

public class InsertDeleteGetRandomII
{
	private List<Integer> list;
	private Map<Integer, Set<Integer>> valToIndexes;	
	private Random random;
	
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomII() 
    {
        list = new ArrayList<>();
        valToIndexes = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert( int val )
    {
    	valToIndexes.putIfAbsent( val, new HashSet<>() );
    	valToIndexes.get( val ).add( list.size() );
    	list.add( val );
    	return valToIndexes.get( val ).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove( int val )
    {
    	Set<Integer> indexes = valToIndexes.get( val );
    	if ( indexes == null || indexes.size() == 0 )
    	{
    		return false;
    	}
    	
    	int indexToRemove = indexes.iterator().next();
    	indexes.remove( indexToRemove );    	
    	Set<Integer> indexesSwapped = valToIndexes.get( list.get( list.size() - 1 ) );
    	indexesSwapped.add( indexToRemove );	// add operation comes before remove
    	indexesSwapped.remove( list.size() - 1 );
    	
    	Collections.swap( list, indexToRemove, list.size() - 1 );
    	list.remove( list.size() - 1 );
    	return true;
     }
    
    /** Get a random element from the collection. */
    public int getRandom()
    {
    	return list.get( random.nextInt( list.size() ) );
    }

    /*
["RandomizedCollection","insert","insert","insert","insert","insert",
						"remove","remove","remove","remove"]
[[],[4],[3],[4],[2],[4],
[4],[3],[4],[4]]
     * */

    @Test
    public void test()
    {
    	InsertDeleteGetRandomII result = new InsertDeleteGetRandomII();
    	assertTrue( result.insert( 4 ) );
    	assertTrue( result.insert( 3 ) );
    	assertTrue( !result.insert( 4 ) );
    	assertTrue( result.insert( 2 ) );
    	assertTrue( !result.insert( 4 ) );
    	
    	assertTrue( result.remove( 4 ) );
    	assertTrue( result.remove( 3 ) );
    	assertTrue( result.remove( 4 ) );
    	assertTrue( result.remove( 4 ) );    	    	
    }
}
