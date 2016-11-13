package hashtable.design;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheLinkedHashMap
{   
    Map<Integer,Integer> cache ;
    int capacity ;
    
    public LRUCacheLinkedHashMap( int capacity ) 
    {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get( int key )
    {
        if( !cache.containsKey( key ) )
        {
            return -1;
        }
        int value = cache.get( key );
        if( cache.size() > 1 ) 
        {
            cache.remove( key );
            cache.put( key, value );
        }
        return value;
    }
    
    public void set( int key, int value ) 
    {
        if( !cache.containsKey( key ) ) 
        {
            if( cache.size()==capacity ) 
            {
                int firstKey = cache.keySet().iterator().next();
                cache.remove( firstKey );
            } 
            cache.put( key,value );
        } 
        else 
        {
            cache.remove( key );
            cache.put( key, value );
        }
    }    
}
