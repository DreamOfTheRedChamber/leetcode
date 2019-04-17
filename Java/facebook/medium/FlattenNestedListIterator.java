package facebook.medium;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

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
	Stack<NestedInteger> stack = new Stack<>();
	
    public FlattenNestedListIterator( List<NestedInteger> nestedList ) 
    {
    	pushReversely( nestedList.listIterator(), stack );
    }

    @Override
    public Integer next()
    {
    	return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() 
    {
    	while ( !stack.isEmpty() )
    	{
    		if ( stack.peek().isInteger() ) 
    		{
    			return true;
    		}
    		else
    		{
    			pushReversely( stack.pop().getList().listIterator(), stack );
    		}
    	}
    	return false;
    }
    
    private void pushReversely( ListIterator<NestedInteger> iterator, Stack<NestedInteger> stack )
    {
    	while ( iterator.hasPrevious() )
    	{
    		stack.push( iterator.previous() );
    	}
    }
}