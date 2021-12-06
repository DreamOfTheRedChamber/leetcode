package depthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utility.NestedInteger;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */

public class NestedListWeightSum
{
    public int depthSum( List<NestedInteger> nestedList )
    {
    	return depthSum( nestedList, 1 );
    }
    
    private int depthSum( List<NestedInteger> nestedList, int depth )
    {
    	int totalSum = 0;
    	for ( NestedInteger nestedInteger : nestedList )
    	{
    		if ( nestedInteger.isInteger() )
    		{
    			totalSum += nestedInteger.getInteger() * depth;
    		}
    		else
    		{
    			totalSum += depthSum( nestedInteger.getList(), depth + 1 );
    		}
    	}
    	return totalSum;
    }
    
	public int depthSumBFS( List<NestedInteger> nestedList )
	{
		Queue<NestedInteger> bfsQueue = new LinkedList<>();
		enqueueAllList( bfsQueue, nestedList );
		int depth = 1;
		int totalSum = 0;
		while ( !bfsQueue.isEmpty() )
		{
			int levelSize = bfsQueue.size();
			for ( int i = 0; i < levelSize; i++ )
			{
				NestedInteger head = bfsQueue.poll();
				if ( head.isInteger() )
				{
					totalSum += head.getInteger() * depth;
				}
				else
				{
					enqueueAllList( bfsQueue, head.getList() );
				}
			}
			depth++;
		}
		return totalSum;
	}
	
	private void enqueueAllList( Queue<NestedInteger> bfsQueue, List<NestedInteger> nestedList )
	{
		for ( NestedInteger nestedInteger : nestedList )
		{
			bfsQueue.offer( nestedInteger );
		}
	}
    
    public int depthSumIterative( List<NestedInteger> nestedList )
    {
    	Stack<Iterator<NestedInteger>> stackIter = new Stack<>();
    	Stack<Integer> stackDepth = new Stack<>();
    	stackIter.push( nestedList.iterator() );
    	stackDepth.push( 1 );
    	int totalSum = 0;
    	while ( !stackIter.isEmpty() )
    	{
    		Iterator<NestedInteger> iterator = stackIter.pop();
    		int depth = stackDepth.pop();
    		while ( iterator.hasNext() )
    		{
    			NestedInteger next = iterator.next();
    			if ( next.isInteger() )
    			{
    				totalSum += depth * next.getInteger();
    			}
    			else
    			{
    				stackDepth.push( depth );
    				stackIter.push( iterator );
    				stackDepth.push( depth + 1 );
    				stackIter.push( next.getList().iterator() );
    				break;
    			}
    		}
    	}
    	return totalSum;    	
    }
    
}
