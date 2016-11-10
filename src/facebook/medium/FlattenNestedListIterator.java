package facebook.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.NestedInteger;

/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * */

public class FlattenNestedListIterator implements Iterator<Integer> 
{
	private Stack<Iterator<NestedInteger>> parentsIterator;	
	private NestedInteger peekedVal;
	
    public NestedIterator( List<NestedInteger> nestedList ) 
    {
    	if ( nestedList == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	parentsIterator = new Stack<>();
    	parentsIterator.push( nestedList.iterator() );
    	peekedVal = null;
    }

    @Override
    public Integer next()
    {
    	NestedInteger lastPeekedVal = peekedVal;
    	peekedVal = null;    	
    	return lastPeekedVal.getInteger();
    }

    @Override
    public boolean hasNext() 
    {
    	if ( !parentsIterator.isEmpty() )
    	{
	        Iterator<NestedInteger> currIterator = parentsIterator.pop();
	    	while ( currIterator.hasNext() )
	    	{
	    		peekedVal = currIterator.next();
	    		if ( !peekedVal.isInteger() )
	    		{
	    			parentsIterator.push( currIterator );
	    			currIterator = peekedVal.getList().iterator();
	    		}
	    		else
	    		{
	    			parentsIterator.push( currIterator );
	    			return true;
	    		}
	    	}
    	}
    	return false;
    }
}