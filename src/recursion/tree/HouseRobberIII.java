package recursion.tree;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import utility.TreeNode;

/**
 *leetcode House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the “root.” Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that “all houses in this place forms a binary tree”. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:


     3
    / \
   2   3
    \   \ 
     3   1
1
2
3
4
5
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:


     3
    / \
   4   5
  / \   \ 
 1   3   1
1
2
3
4
5
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9. 
 */
public class HouseRobberIII
{
	public int rob( TreeNode root )
	{
		return rob( root, new HashMap<>() );
	}	
	
    private int rob( TreeNode root, Map<TreeNode, Integer> computedHouses )
    {
    	if ( root == null )
    	{
    		return 0;
    	}    	
    	if ( computedHouses.containsKey( root ) )
    	{
    		return computedHouses.get( root );
    	}
    	
    	// sum includes root
    	int sumIncludeRoot = 0;
    	sumIncludeRoot += root.val;
    	
    	if ( root.left != null )
    	{    		
    		sumIncludeRoot += rob( root.left.left, computedHouses );
    		sumIncludeRoot += rob( root.left.right, computedHouses );
    	}
    	if ( root.right != null )
    	{
    		sumIncludeRoot += rob( root.right.left, computedHouses );
    		sumIncludeRoot += rob( root.right.right, computedHouses );
    	}
    	
    	// sum does not include root
    	int sumExcludeRoot = rob( root.left, computedHouses ) + rob( root.right, computedHouses );
    	int result = Math.max( sumIncludeRoot, sumExcludeRoot );

    	// memorizing search
    	computedHouses.put( root, result );    	
    	return result;
    }

    @Test
    public void test()    
    {
    	TreeNode node1 = new TreeNode( 3 );
    	TreeNode node2 = new TreeNode( 4 );
    	TreeNode node3 = new TreeNode( 5 );
    	TreeNode node4 = new TreeNode( 1 );
    	TreeNode node5 = new TreeNode( 3 );
    	TreeNode node6 = new TreeNode( 1 );
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node3.right = node6;
    	
    	assertEquals( 9, rob( node1 ) );
    }
}