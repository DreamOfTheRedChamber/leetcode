package linkedIn;

import java.util.LinkedList;
import java.util.Queue;

import utility.TreeNode;

/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   
 要把一棵树转换成它的镜像
 */

public class SymmetricTree
{
	public boolean isSymmetricIterative( TreeNode root )
	{
		if ( root == null ) return true;
		Queue<TreeNode> leftFirst = new LinkedList<>();
		Queue<TreeNode> rightFirst = new LinkedList<>();
		leftFirst.add( root );
		rightFirst.add( root );
		while ( !leftFirst.isEmpty() && !rightFirst.isEmpty() )
		{
			TreeNode left = leftFirst.poll();
			TreeNode right = rightFirst.poll();
			if ( left == null && right != null 
					|| left != null && right == null )
			{
				return false;
			}
			if ( left != null && right != null )
			{
				if ( left.val != right.val )
				{
					return false;
				}
				leftFirst.add( left.left );
				leftFirst.add( left.right );
				rightFirst.add( right.right );
				rightFirst.add( right.left );
			}
		}
		return true;
	}
	
    public boolean isSymmetric( TreeNode root )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	
    	return isSymmetricRecurse( root.left, root.right );
    }
    
    private boolean isSymmetricRecurse( TreeNode left, TreeNode right )
    {
    	if ( left == null || right == null )
    	{
    		return left == right;
    	}
    	return left.val == right.val && isSymmetricRecurse( left.left, right.right ) && isSymmetricRecurse( left.right, right.left );
    }
}
