package binarySearchTree;

import utility.TreeNode;

/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 * */

public class ClosestBinarySearchTreeValue 
{
    public int closestValue( TreeNode root, double target )
    {
    	if ( root == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	if ( root.left == null && root.right == null )
    	{
    		return root.val;
    	}
    	
    	
    	if ( root.val < target && root.right != null )
    	{
    		int childClosest = closestValue( root.right, target );
    		double rootDistance = Math.abs( root.val - target );
    		double childDistance = Math.abs( childClosest - target );
    		if ( rootDistance < childDistance )
    		{
    			return root.val;
    		}
    		else
    		{
    			return childClosest;
    		}
    	}
    	if ( root.val > target && root.left != null )
    	{
    		int childClosest = closestValue( root.left, target );
    		double rootDistance = Math.abs( root.val - target );
    		double childDistance = Math.abs( childClosest - target );
    		if ( rootDistance < childDistance )
    		{
    			return root.val;
    		}
    		else
    		{
    			return childClosest;
    		}
    		
    	}
    	
    	return root.val;
    }
}