package hashtable.design;

import java.util.HashMap;
import java.util.Map;

class ListNode
{
    public int key;
    public int value;
    public ListNode prev;
    public ListNode next;
    public ListNode( int key, int value )
    {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

public class LRUCacheHashTableDDL 
{
    private Map<Integer, ListNode> keyToNodeMap;
    // list ordered from oldest to latest
    private ListNode listHeadSentinel;
    private ListNode listTailSentinel;
    private int capacity;
    private final static int SENTINEL = 0;
    
    public LRUCacheHashTableDDL(int capacity) 
    {
        this.capacity = capacity;
        this.keyToNodeMap = new HashMap<>( capacity );
        listHeadSentinel = new ListNode( SENTINEL, SENTINEL );
        listTailSentinel = new ListNode( SENTINEL, SENTINEL );
        listHeadSentinel.next = listTailSentinel;
        listTailSentinel.prev = listHeadSentinel;
    }
    
    public int get(int key) 
    {
        if ( keyToNodeMap.containsKey( key ) )
        {
            ListNode node = keyToNodeMap.get( key );
            
            // move node to list tail
            removeNodeFromList( node );
            addNodeToListTail( node ); 

            if ( node != null )
            {
                return node.value;
            }
            else
            {
                throw new IllegalStateException("");
            }
        }
        else
        {
            return -1;
        }
    }
    
    public void set(int key, int value) 
    {
        // judge and pop up oldest entry when necessary
        if ( !keyToNodeMap.containsKey( key ) )
        {
            if ( keyToNodeMap.size() == capacity )
            {
                ListNode cacheToBeRemoved = listHeadSentinel.next;
                removeNodeFromList( cacheToBeRemoved );
                keyToNodeMap.remove( cacheToBeRemoved.key );
            }
        }
                
        if ( keyToNodeMap.containsKey( key ) )
        {
            ListNode existingNode = keyToNodeMap.get( key );
            removeNodeFromList( existingNode );
            existingNode.value = value;
            addNodeToListTail( existingNode );
        }
        else
        {
            ListNode node = new ListNode( key, value );
            addNodeToListTail( node );
            keyToNodeMap.put( key, node );
        }
    }
    
    private void addNodeToListTail( ListNode nodeToBeAdded )
    {
        ListNode nodeBeforeTail = listTailSentinel.prev;
        
        nodeBeforeTail.next = nodeToBeAdded;
        nodeToBeAdded.prev = nodeBeforeTail;
        
        nodeToBeAdded.next = listTailSentinel;
        listTailSentinel.prev = nodeToBeAdded;
    }
    
    private void removeNodeFromList( ListNode nodeToBeRemoved ) 
    {
        ListNode nodeBeforeCurr = nodeToBeRemoved.prev;
        ListNode nodeAfterCurr = nodeToBeRemoved.next;
        nodeBeforeCurr.next = nodeAfterCurr;
        nodeAfterCurr.prev = nodeBeforeCurr;
    }
}
