package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    	Map<Integer, List<Integer>> vOrderToNodes = new HashMap<>();
    	if ( root != null )
    	{
    		traverseTree( vOrderToNodes, root, 0 );
    	}
    	return vOrderToNodes.values( ).stream( ).collect( Collectors.toList( ) );
    }
    
    private void traverseTree( Map<Integer, List<Integer>> vOrderToNodes, TreeNode root, int vOrder )
    {
    	vOrderToNodes.putIfAbsent( vOrder, new ArrayList<>() );
    	vOrderToNodes.get( vOrder ).add( root.val );
    	
    	if ( root.left != null )
    	{
    		traverseTree( vOrderToNodes, root.left, vOrder - 1 );
    	}
    	
    	if ( root.right != null )
    	{
    		traverseTree( vOrderToNodes, root.right, vOrder + 1 );
    	}
    }

}
