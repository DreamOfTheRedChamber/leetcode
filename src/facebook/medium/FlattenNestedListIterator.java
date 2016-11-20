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

// [],[[]],[]
// 

public class FlattenNestedListIterator implements Iterator<Integer> 
{
	private Stack<Iterator<NestedInteger>> stack;	
	private Integer nextInteger;
	
    public FlattenNestedListIterator( List<NestedInteger> nestedList ) 
    {
    	if ( nestedList == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	stack = new Stack<>();
    	stack.push( nestedList.iterator() );
    	nextInteger = null;
    }

    @Override
    public Integer next()
    {
    	Integer result = nextInteger;
    	nextInteger = null;
    	return result;
    }

    @Override
    public boolean hasNext() 
    {
    	if ( nextInteger != null )
    	{
    		return true;
    	}
    	
    	while ( !stack.isEmpty() )
    	{
	        Iterator<NestedInteger> currIter = stack.peek();
	    	if ( currIter.hasNext() )
	    	{
	    		NestedInteger nextNested = currIter.next();
	    		if ( nextNested.isInteger() )
	    		{
	    			nextInteger = nextNested.getInteger();
	    			return true;
	    		}
	    		else
	    		{
	    			stack.push( nextNested.getList().iterator() );
	    		}
	    	}
    	}
    	return false;
    }
}