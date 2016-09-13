package stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
//TO_TEST
public class VerifyPreorderSerializationOfBinaryTree 
{
	@Test
	public void test()
	{
		assertTrue( isValidSerialization( "9,3,4,#,#,1,#,#,2,#,6,#,#" ) );
		assertFalse( isValidSerialization("1, #") );
		assertFalse( isValidSerialization("9, #, #, 1") );
	}
	
	public boolean isValidSerialization( String preorder )
    {
    	if ( preorder == null )
    	{
    		throw new NullPointerException("");
    	}    			
    	if ( preorder.length() == 0 )
    	{
    		return true;
    	}
    	
    	int[] currPos = new int[1];
    	String[] nodeValues = preorder.split( "," );
    	if ( !isValidSerializationRecurse( nodeValues, currPos ) )
    	{ 
    		return false;
    	}
    	return currPos[0] == preorder.length( );
    }
    
    /**
     * 
     * @param nodeValues  parsed tree node values
     * @param currPos  position inside nodeValues
     * @return	whether nodeValues is enough to build a binary tree
     */
    private boolean isValidSerializationRecurse( String[] nodeValues, int[] currPos )
    {
    	if ( currPos[0] >= nodeValues.length )
    	{
    		return false;
    	}    	
    	if ( nodeValues[currPos[0]].equals( "#" ) )
    	{
    		return true;
    	}
    	
    	currPos[0] += 1;
    	return isValidSerializationRecurse( nodeValues, currPos )
    			&& isValidSerializationRecurse( nodeValues, currPos );
    }
}