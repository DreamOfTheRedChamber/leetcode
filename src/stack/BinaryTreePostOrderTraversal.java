package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utility.TreeNode;

class Pair
{
	public final int type; // 1 for visit, 2 for print
	public final TreeNode node;
	public Pair( int type, TreeNode node )
	{
		this.type = type;
		this.node = node;
	}
}

public class BinaryTreePostOrderTraversal 
{
	private final static int VISIT = 1;
	private final static int PRINT = 2;
	
	public List<Integer> postorderTraversal( TreeNode root )
	{
		List<Integer> result = new ArrayList<>();		
		if ( root == null )
		{
			return result;
		}
		
		Stack<Pair> postOrderStack = new Stack<>();
		postOrderStack.push( new Pair( 1, root) );
		while ( !postOrderStack.isEmpty( ) )
		{
			Pair stackTop = postOrderStack.pop( );
			if ( stackTop.type == VISIT )
			{
				postOrderStack.push( new Pair( PRINT, stackTop.node ) );
				if ( stackTop.node.right != null )
				{
					postOrderStack.push( new Pair( VISIT, stackTop.node.right ) );
				}
				if ( stackTop.node.left != null )
				{
					postOrderStack.push( new Pair( VISIT, stackTop.node.left ) );
				}
			}
			else
			{
				result.add( stackTop.node.val );
			}
		}
		return result;
	}
}