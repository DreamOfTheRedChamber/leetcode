package hashtable.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap
{   
 LinkedHashMap<Integer,Integer> cache ;
 int capacity ;
 
 public LRUCacheLinkedHashMap( int capacity ) 
 {
 	   this.cache = new LinkedHashMap<Integer, Integer>( capacity, .75F, true ) {
		   protected boolean removeEldestEntry( Map.Entry<Integer, Integer> eldest ) {
			   return size() > capacity;
		   }
	   };
    this.capacity = capacity;
 }
 
 public int get( int key )
 {
  if( !cache.containsKey( key ) )
  {
   return -1;
  }
  return cache.get( key );  
 }
 
 public void set( int key, int value ) 
 {
 	cache.put( key, value );
 } 
}
