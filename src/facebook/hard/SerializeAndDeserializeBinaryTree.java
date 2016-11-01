package facebook.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Ignore;
import org.junit.Test;

import utility.TreeNode;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * */

public class SerializeAndDeserializeBinaryTree 
{

    // Encodes a tree to a single string.
    public String serialize( TreeNode root )
    {    	
    	StringBuilder result = new StringBuilder();
    	if ( root == null )
    	{
    		return result.toString();
    	}
    	Queue<TreeNode> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( root );
    	result.append( root.val );
    	result.append( "," );
    	while ( !bfsQueue.isEmpty() )
    	{
    		TreeNode head = bfsQueue.poll();
    		// left
    		result.append( head.left == null ? "#" : head.left.val );
    		result.append( "," );
    		if ( head.left != null )
    		{
    			bfsQueue.offer( head.left );
    		}
    		// right
    		result.append( head.right == null ? "#" : head.right.val );
    		result.append( "," );
    		if ( head.right != null )
    		{
    			bfsQueue.offer( head.right );
    		}    		
    	}
    	return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize( String data )
    {
    	// basic error handling
    	if ( data == null || data.length() == 0 )
    	{
    		return null;
    	}
    	String[] tokens = data.split( "," );
    	TreeNode root = new TreeNode( Integer.parseInt( tokens[0] ) );
    	Queue<TreeNode> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( root );
    	int index = 1;
    	while ( !bfsQueue.isEmpty() )
    	{
    		TreeNode head = bfsQueue.poll();
    		if ( !tokens[index].equals( "#" ) )
    		{
    			head.left = new TreeNode( Integer.parseInt( tokens[index] ) );
    			bfsQueue.offer( head.left );
    		}
    		if ( !tokens[index + 1].equals( "#" ) )
    		{
    			head.right = new TreeNode( Integer.parseInt( tokens[index + 1] ) );
    			bfsQueue.offer( head.right );
    		}
    		index += 2;
    	}
    	return root;
    }
    
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	node1.left = node2;
    	
    	TreeNode node3 = deserialize( serialize( node1 ) );
    	System.out.println( node3.val );
    }
    
    @Ignore
    @Test
    public void test2()
    {
    	StringBuilder sb1 = new StringBuilder();
    	sb1.append("#");
    	sb1.append(",");
    	String[] tokens = sb1.toString().split( "," );
    	
    	StringBuilder sb2 = new StringBuilder();
    	sb2.append('#');
    	sb2.append(',');
    	String[] tokens2 = sb2.toString().split( "," );
    	
    	System.out.println( Arrays.toString( tokens ) );
    	System.out.println( Arrays.toString( tokens2 ) );
    }
}
