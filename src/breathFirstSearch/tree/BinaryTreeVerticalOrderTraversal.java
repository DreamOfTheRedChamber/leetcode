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
    	Map<Integer, List<Integer>> orderToVal = new HashMap<>();
    	Queue<Map.Entry<TreeNode, Integer>> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( new AbstractMap.SimpleEntry<>( root, 0 ) );
    	while ( !bfsQueue.isEmpty() )
    	{
    		Map.Entry<TreeNode, Integer> qHead = bfsQueue.poll();
    		TreeNode curr = qHead.getKey();
    		int vertiOrder = qHead.getValue();
    		
    		orderToVal.putIfAbsent( vertiOrder, new ArrayList<>() );
    		orderToVal.get( vertiOrder ).add( curr.val );
    		if ( curr.left != null )
    		{
    			bfsQueue.offer( new AbstractMap.SimpleEntry<>( curr.left, vertiOrder - 1 ) );
    		}
    		if ( curr.right != null )
    		{
    			bfsQueue.offer( new AbstractMap.SimpleEntry<>( curr.right, vertiOrder + 1 ) );
    		}
    	}
    	
    	// build
    	int minVerti = orderToVal.keySet()
    							 .stream()
    							 .min( Integer::compare )
    							 .get();
    	int maxVerti = orderToVal.keySet()
    							 .stream()
    							 .max( Integer::compare )
    							 .get();
    	List<List<Integer>> result = new ArrayList<>();
    	for ( int i = minVerti; i <= maxVerti; i++ )
    	{
    		result.add( orderToVal.get( i ) );
    	}
    	return result;
    }
}

