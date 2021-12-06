package hashtable.design;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

class DLLNode
{
	public int key;
 public int value;
 public DLLNode prev;
 public DLLNode next;
 public DLLNode( int key, int value )
 {
 	this.key = key;
  this.value = value;
 }
}

public class LRUCacheHashTableDDL 
{
	
 private Map<Integer, DLLNode> cache;
 // list ordered from oldest to latest
 private DLLNode dummyOldest;
 private DLLNode dummyLatest;
 private int capacity;
 
 public LRUCacheHashTableDDL( int capacity )
 {
  this.capacity = capacity;
  this.cache = new HashMap<>( capacity );
  dummyOldest = new DLLNode( 0, 0 );
  dummyLatest = new DLLNode( 0, 0 );
  dummyLatest.prev = dummyOldest;
  dummyOldest.next = dummyLatest;
 }
 
 public int get( int key )
 {
  if ( !cache.containsKey( key ) )
  {
  	return -1;
  }
  
  DLLNode node = cache.get( key );
   
  // move node to list tail
  deleteNode( node );
  addAsLatest( node ); 

  return node.value;
 }
 
 public void put( int key, int value )
 {
  // judge and pop up oldest entry when necessary
  if ( !cache.containsKey( key ) 
  		&& cache.size() == capacity )
  {
  	DLLNode oldest = dummyOldest.next;
   deleteNode( oldest );
   cache.remove( oldest.key );
  }
    
  if ( cache.containsKey( key ) )
  {
   DLLNode existingNode = cache.get( key );
   existingNode.value = value;

   deleteNode( existingNode );
   addAsLatest( existingNode );
  }
  else
  {
   DLLNode node = new DLLNode( key, value );
   cache.put( key, node );
   addAsLatest( node );
  }
 }
 
 private void addAsLatest( DLLNode node )
 {
  DLLNode beforeTail = dummyLatest.prev;
  
  beforeTail.next = node;
  node.prev = beforeTail;
  
  node.next = dummyLatest;
  dummyLatest.prev = node;
 }
 
 private void deleteNode( DLLNode node ) 
 {
  DLLNode beforeNode = node.prev;
  DLLNode afterNode = node.next;
  beforeNode.next = afterNode;
  afterNode.prev = beforeNode;
 }
 
 public static void main( String[] args )
 {
 	LRUCacheHashTableDDL table = new LRUCacheHashTableDDL( 2 );
 	table.put( 1, 1 );
 	table.put( 2, 2 );
 	assertEquals( 1, table.get( 1 ) );
 	table.put( 3, 3 );
 	assertEquals( -1, table.get( 2 ));
 }
}
