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
    		return findClosest( root.val, closestValue( root.right, target ), target );    		
    	}
    	if ( root.val > target && root.left != null )
    	{
    		return findClosest( root.val, closestValue( root.left, target ), target );
    	}
    	
    	return root.val;
    }
    
    private int findClosest( int value1, int value2, double target )
    {
		double value1Distance = Math.abs( value1 - target );
		double value2Distance = Math.abs( value2 - target );
		if ( value1Distance < value2Distance )
		{
			return value1;
		}
		else
		{
			return value2;
		}    	
    }
}