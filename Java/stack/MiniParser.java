package stack;

import java.util.Stack;

import org.junit.Test;

import utility.NestedInteger;

/*
Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
 * */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser 
{
	
	@Test
	public void test()
	{
		NestedInteger resultOne = deserialize( new String( "324" ) );
//		NestedInteger resultFive = deserialize( new String( "-3" ) );
//		NestedInteger resultTwo = deserialize( new String( "[324]" ) );
//		NestedInteger resultThree = deserialize( new String( "[123,[456]]" ) );
//		NestedInteger resultFour = deserialize( new String( "[123,[456,578]]" ) );
//		NestedInteger resultSix = deserialize( new String( "[[],456]" ) );
	}
	// refer to the code in http://www.jiuzhang.com/solutions/mini-parse/
	public NestedInteger deserialize( String s )
    {
		// input validation
		if ( s == null 
				|| s.length() == 0 )
		{
			throw new IllegalArgumentException("input should not be null");
		}
		// others assertions...
				
		Stack<NestedInteger> recursionStack = new Stack<>();
		int pos = 0;
		while ( pos < s.length() )
		{
			if ( s.charAt( pos ) == '[' )
			{
				recursionStack.push( new NestedInteger() );
				pos++;
			}
			else if ( s.charAt( pos ) == ']' )
			{
				if ( recursionStack.size() > 1 )
				{
					NestedInteger stackTop = recursionStack.pop();
					recursionStack.peek().add( stackTop );
				}
				pos++;
			}
			else if ( s.charAt( pos ) == ',' )
			{
				pos++;
			}
			else // integers
			{
				// parse integer
				int startPos = pos;
				while ( pos < s.length() 
						&& (s.charAt( pos ) == '-' || ( s.charAt( pos ) >= '0' && s.charAt( pos ) <= '9' ) ) )
				{
					pos++;
				}
				int parsedInt = Integer.valueOf( s.substring( startPos, pos ) );
				NestedInteger newValue = new NestedInteger( parsedInt );

				// add to stack
				if ( recursionStack.size() >= 1 )
				{
					recursionStack.peek().add( newValue );
				}
				else
				{
					recursionStack.push( newValue );
				}
			}
		}
		
		return recursionStack.pop();
    }    
}