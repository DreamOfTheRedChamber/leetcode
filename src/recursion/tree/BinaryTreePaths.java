package recursion.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */

public class BinaryTreePaths
{

    public List<String> binaryTreePaths( TreeNode root ) 
    {
        if ( root == null )
        {
        	return new ArrayList<>();
        }
        
        List<StringBuilder> result = new ArrayList<>();        
        StringBuilder path = new StringBuilder();
        traverseTree( result, path, root );

        List<String> trimmedResult = new ArrayList<>();
        for ( StringBuilder oneResult : result )
        {
        	trimmedResult.add( oneResult.delete( 0, 2 ).toString() );
        }
        return trimmedResult;
    }

    private void traverseTree( List<StringBuilder> result, StringBuilder path, TreeNode root )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	if ( root.left == null
    			&& root.right == null )
    	{
    		int originLength = path.length();
    		path.append("->");
    		path.append( String.valueOf( root.val ) );

    		result.add( new StringBuilder( path ) );
    		
    		path.delete( originLength, path.length() );
    		return;
    	}
    	
    	int originLength = path.length();
    	path.append( "->" );
    	path.append( String.valueOf( root.val ) );
    	if ( root.left != null )
    	{
    		traverseTree( result, path, root.left );
    	}
    	if ( root.right != null )
    	{
    		traverseTree( result, path, root.right );
    	}
    	path.delete( originLength, path.length() );
    }
   
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	TreeNode node4 = new TreeNode( 5 );
    	node1.left = node2;
    	node1.right = node3;
    	node2.right = node4;
    	System.out.println( binaryTreePaths( node1 ) );
    }
    
}
