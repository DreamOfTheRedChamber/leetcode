package design;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator 
{

    private Stack<TreeNode> inorderTravStack;

    public BSTIterator(TreeNode root) 
    {
        inorderTravStack = new Stack<>();
        pushAllPureLeftChildren( inorderTravStack, root );
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        return !inorderTravStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() 
    {
        TreeNode nextSmallestNode = inorderTravStack.pop();
        if ( nextSmallestNode.right != null )
        {
            pushAllPureLeftChildren( inorderTravStack, nextSmallestNode.right);
        }
        return nextSmallestNode.val;
    }
    
    private void pushAllPureLeftChildren( Stack<TreeNode> inorderTravStack, TreeNode root )
    {
        TreeNode currNode = root;
        while ( currNode != null )
        {
            inorderTravStack.push( currNode );
            currNode = currNode.left;
        }
    }
    
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
