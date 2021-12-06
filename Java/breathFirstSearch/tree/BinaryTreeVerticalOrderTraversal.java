package breathFirstSearch.tree;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import utility.TreeNode;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */



public class BinaryTreeVerticalOrderTraversal
{
    public List<List<Integer>> verticalOrder( TreeNode root )
    {
    	if ( root == null )
    	{
    		return new ArrayList<>();
    	}
    	
    	// traverse the tree
    	int minLevel = 0;
    	int maxLevel = 0;
    	Map<Integer, List<Integer>> orderToVal = new HashMap<>();
    	Queue<Pair> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( new Pair( root, 0 ) );
    	while ( !bfsQueue.isEmpty() )
    	{
    		Pair head = bfsQueue.poll();
    		
    		minLevel = Math.min( minLevel, head.col );
    		maxLevel = Math.max( maxLevel, head.col );
    		
    		orderToVal.putIfAbsent( head.col, new ArrayList<>() );
    		orderToVal.get( head.col ).add( head.node.val );
    		if ( head.node.left != null )
    		{
    			bfsQueue.offer( new Pair( head.node.left, head.col - 1 ) );
    		}
    		if ( head.node.right != null )
    		{
    			bfsQueue.offer( new Pair( head.node.right, head.col + 1 ) );
    		}
    	}
    	
    	List<List<Integer>> result = new ArrayList<>();
    	for ( int i = minLevel; i <= maxLevel; i++ )
    	{
    		result.add( orderToVal.get( i ) );
    	}
    	return result;
    }
    
    class Pair
    {
    	public final TreeNode node;
    	public final int col;
    	public Pair( TreeNode node, int col )
    	{
    		this.node = node;
    		this.col = col;
    	}
    }
}

