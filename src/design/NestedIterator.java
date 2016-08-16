package design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> 
{

	private Stack<Iterator<NestedInteger>> iteratorStack;
	private Iterator<NestedInteger> currIterator;
	
    public NestedIterator(List<NestedInteger> nestedList) 
    {
    	iteratorStack = new Stack<>();
    	currIterator = nestedList.iterator( );
    }

    @Override
    public Integer next() 
    {
    	NestedInteger currValue = currIterator.next( );
    	while ( !currValue.isInteger( ) )
    	{
    		List<NestedInteger> nestedIntegerList = currValue.getList( );
    		iteratorStack.push( currIterator );
    		currIterator = nestedIntegerList.iterator( );
    	}
    	return currValue.getInteger( );
    }

    @Override
    public boolean hasNext() 
    {
    	if ( currIterator.hasNext( ) )
    	{
    		return true;
    	}
    	else 
    	{
	    	while ( !iteratorStack.isEmpty( ) )
	    	{
	    		currIterator = iteratorStack.pop( );
	    		if ( currIterator.hasNext( ) )
	    		{
	    			return true;
	    		}
	    	}
	    	return false;
    	}
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */