public class RandomizedSet
{

	private List<Integer> indexToValueList;
	private Map<Integer, Integer> valueToIndexMap;
	Random rand;
	
	/** Initialize your data structure here. */
	public RandomizedSet( )
	{
		indexToValueList = new ArrayList<>();
		valueToIndexMap = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert( int val )
	{
		if ( valueToIndexMap.containsKey( val ) )
		{
			return false;
		}
		else
		{
			indexToValueList.add( val );
			valueToIndexMap.put( val, indexToValueList.size() - 1 );
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove( int val )
	{
		if ( valueToIndexMap.containsKey( val ) )
		{
			int index = valueToIndexMap.get( val );
			valueToIndexMap.remove( val );
			indexToValueList.remove( index );
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
		int nextRandom = rand.nextInt( indexToValueList.size() );
		return indexToValueList.get( nextRandom );
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */