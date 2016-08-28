package hashtable;

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
    	Map<Integer, List<Integer>> verticalOrderToNodes = new HashMap<>();
    	if ( root != null )
    	{
    		traverseTree( verticalOrderToNodes, root );
    	}
    	
    	int minVerticalOrder = 0;
    	int maxVerticalOrder = 0;
    	for ( int verticalOrder : verticalOrderToNodes.keySet() )
    	{
    		minVerticalOrder = Math.min( minVerticalOrder, verticalOrder );
    		maxVerticalOrder = Math.max( maxVerticalOrder, verticalOrder );
    	}
    	
    	List<List<Integer>> verticalOrderNodes = new LinkedList<>();
    	for ( int i = minVerticalOrder; i <= maxVerticalOrder; i++ )
    	{
    		verticalOrderNodes.add( verticalOrderToNodes.get( i ) );
    	}
    	return verticalOrderNodes;
    }
    
    /** 
     * traverse level by level, put node into its level
     * 
     * @param verticalOrderToNodes
     * @param root
     */
    private void traverseTree( Map<Integer, List<Integer>> verticalOrderToNodes, TreeNode root )
    {
    	Queue<PairWrapper> bfsQueue = new LinkedList<>();
    	bfsQueue.add( new PairWrapper( root, 0 ) );
    	while ( !bfsQueue.isEmpty() )
    	{
    		PairWrapper qHead = bfsQueue.poll();
    		verticalOrderToNodes.putIfAbsent( qHead.colIndex, new LinkedList<>() );
    		verticalOrderToNodes.get( qHead.colIndex ).add( qHead.node.val );
    		if ( qHead.node.left != null )
    		{
    			bfsQueue.add( new PairWrapper( qHead.node.left, qHead.colIndex - 1 ) );
    		}
    		if ( qHead.node.right != null )
    		{
    			bfsQueue.add( new PairWrapper( qHead.node.right, qHead.colIndex + 1 ) );
    		}
    	}
    }
}

class PairWrapper
{
	public final TreeNode node;
	public final int colIndex;
	public PairWrapper( TreeNode node, int colIndex )
	{
		this.node = node;
		this.colIndex = colIndex;
	}
}