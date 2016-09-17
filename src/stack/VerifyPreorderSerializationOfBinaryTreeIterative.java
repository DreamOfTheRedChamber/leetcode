package stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.Test;

/*
One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 * */
public class VerifyPreorderSerializationOfBinaryTreeIterative 
{
	@Test
	public void test()
	{
		assertTrue( isValidSerialization( "9,3,#,#,#" ) );

		assertTrue( isValidSerialization( "9,3,4,#,#,1,#,#,2,#,6,#,#" ) );
		assertFalse( isValidSerialization( "1,#" ) );
		assertFalse( isValidSerialization( "9,#,#,1" ) );		
		
	}
	
	public boolean isValidSerialization( String preorder )
    {
		if ( preorder == null ) 
		{
			throw new IllegalArgumentException("");
		}
		
		String[] nodes = preorder.split( "," );
		Stack<String> preorderStack = new Stack<>(); 
		for ( int i = 0; i < nodes.length; i++ )
		{
			while ( preorderStack.size() > 1
					&& nodes[i].equals( "#" ) 
					&& preorderStack.peek().equals( "#" ) )
			{
				preorderStack.pop();
				preorderStack.pop();
			}
			preorderStack.push( nodes[i] );
		}
		return preorderStack.size() == 1 
				&& preorderStack.peek().equals( "#" );
    }
}