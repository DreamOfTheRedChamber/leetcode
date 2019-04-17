package linkedIn;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*
http://www.cnblogs.com/EdwardLiu/p/6216593.html
http://massivealgorithms.blogspot.com/2015/10/lfu-cache.html

Support get/set in O(1) time
*/

public class LFUCache
{
	int cap;
	ListNode head;
	Map<Integer, Integer> valueMap;
	Map<Integer, ListNode> nodeMap;

	public LFUCache(int capacity) {
		this.cap = capacity;
		this.head = null;
		this.valueMap = new HashMap<>();
		this.nodeMap = new HashMap<>();
	}

	public int get( int key )
	{
		if ( valueMap.containsKey( key ) )
		{
			increaseCount( key );
			return valueMap.get( key );
		}
		return -1;
	}

	public void set( int key, int value )
	{
		if ( cap == 0 )
		{
			return;
		}
		if ( valueMap.containsKey( key ) )
		{
			valueMap.put( key, value );
			increaseCount( key );
		}
		else
		{
			if ( valueMap.size() < cap )
			{
				valueMap.put( key, value );
				addToHead( key );
			}
			else
			{
				removeOld();
				valueMap.put( key, value );
				addToHead( key );
			}
		}
	}

	public void increaseCount( int key )
	{
		ListNode node = nodeMap.get( key );
		node.keys.remove( key );
		if ( node.next == null )
		{
			node.next = new ListNode( node.count + 1 );
			node.next.prev = node;
			node.next.keys.add( key );
		}
		else if ( node.next.count == node.count + 1 )
		{
			node.next.keys.add( key );
		}
		else
		{
			ListNode newNode = new ListNode( node.count + 1 );
			newNode.next = node.next;
			node.next.prev = newNode;
			newNode.prev = node;
			node.next = newNode;
			node.next.keys.add( key );
		}
		nodeMap.put( key, node.next );
		if ( node.keys.size() == 0 )
			remove( node );
	}

	public void remove( ListNode node )
	{
		if ( node.next != null )
		{
			node.next.prev = node.prev;
		}
		if ( node.prev != null )
		{
			node.prev.next = node.next;
		}
		else
		{ // node is head
			head = head.next;
		}
	}

	public void addToHead( int key )
	{
		if ( head == null )
		{
			head = new ListNode( 1 );
			head.keys.add( key );
		}
		else if ( head.count == 1 )
		{
			head.keys.add( key );
		}
		else
		{
			ListNode newHead = new ListNode( 1 );
			head.prev = newHead;
			newHead.next = head;
			head = newHead;
			head.keys.add( key );
		}
		nodeMap.put( key, head );
	}

	public void removeOld()
	{
		if ( head == null )
			return;
		int old = 0;
		for ( int keyInorder : head.keys )
		{
			old = keyInorder;
			break;
		}
		head.keys.remove( old );
		if ( head.keys.size() == 0 )
			remove( head );
		valueMap.remove( old );
		nodeMap.remove( old );
	}

	public class ListNode
	{
		int count;
		ListNode prev, next;
		LinkedHashSet<Integer> keys;

		public ListNode(int freq) {
			count = freq;
			keys = new LinkedHashSet<Integer>();
			prev = next = null;
		}
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.set(key,value);
 */