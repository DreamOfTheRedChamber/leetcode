package design;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheLinkedHashMap<K,V> extends LinkedHashMap<K, V>
{   
	private final int maxCapacity;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private final Lock lock = new ReentrantLock();
	
    public LRUCacheLinkedHashMap( int maxCapacity ) 
    {
    	super( maxCapacity, DEFAULT_LOAD_FACTOR, true );
    	this.maxCapacity = maxCapacity;
    }
    
    @Override
    protected boolean removeEldestEntry( Map.Entry<K, V> eldest )
    {
    	return size() > maxCapacity;
    }
    
    @Override
    public V get( Object key )
    {
    	try
    	{
    		lock.lock();
    		return super.get( key );
    	}
    	finally
    	{
    		lock.unlock();
    	}
    }
    
    @Override
    public V put( K key, V value ) 
    {
    	try 
    	{
    		lock.lock();
    		return super.put( key, value );
    	}
    	finally
    	{
    		lock.unlock();
    	}
    }
    
}
