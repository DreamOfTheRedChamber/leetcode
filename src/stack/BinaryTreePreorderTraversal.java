package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utility.TreeNode;

public class BinaryTreePreorderTraversal 
{
	// push root first, right child second, left child third
	// enqueue into result when popped out of queue
	// more concise than method2 
    public List<Integer> preorderTraversalMethod1(TreeNode root) 
    {
     	List<Integer> result = new ArrayList<>();
    	if ( root == null )
    	{
    		return result;
    	}
    	
    	Stack<TreeNode> preorderStack = new Stack<>();
    	preorderStack.push( root );
    	while ( !preorderStack.isEmpty() )
    	{
    		TreeNode stackTop = preorderStack.pop();
    		result.add( stackTop.val );
    		if ( stackTop.right != null )
    		{
    			preorderStack.push( stackTop.right );
    		}
    		if ( stackTop.left != null )
    		{
    			preorderStack.push( stackTop.left );
    		}
    	}
    	return result;       
    }
    
    // push root first, all children along left path second, right child third
    // enqueue into result when pushing into queue
    // code structure more consistent with inorder traversal
    public List<Integer> preorderTraversalMethod2( TreeNode root ) 
    {
     	List<Integer> result = new ArrayList<>();
    	if ( root == null )
    	{
    		return result;
    	}
    	
    	Stack<TreeNode> preorderStack = new Stack<>();
    	pushAllLeftChildren( root, preorderStack, result );
    	
    	while ( !preorderStack.isEmpty() )
    	{
    		TreeNode top = preorderStack.pop();
    		if ( top.right != null )
    		{
    			pushAllLeftChildren( top.right, preorderStack, result );
    		}
    	}
    	return result;
    }
        
    private void pushAllLeftChildren( TreeNode root, Stack<TreeNode> preorderStack, List<Integer> result )
	{
		TreeNode currNode = root;
		while ( currNode != null )
		{
			result.add( currNode.val );
			preorderStack.push( currNode );
			currNode = currNode.left;
		}
	}
}