package stack;

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
		NestedInteger resultTwo = deserialize( new String( "[123,[456,[789]]]" ) );
		NestedInteger resultThree = deserialize( new String( "[123,[456,578,[789, 090]]]" ) );
	}
	
	public NestedInteger deserialize(String s) 
    {
    	if ( s == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	// other assertions
    	
    	return deserializeRecurse( s, new int[1] );
    }
    
    private NestedInteger deserializeRecurse( String s, int[] startPos )
    {
    	if ( startPos[0] >= s.length() )
    	{
    		return null;
    	}
    	
    	NestedInteger currLevelNestedInteger = new NestedInteger();
    	if ( s.charAt(startPos[0]) >= 1 
    			&& s.charAt( startPos[0] ) <= 9 )
    	{
    		currLevelNestedInteger.setInteger( parseInteger( s, startPos ) );
    		return currLevelNestedInteger;
    	}
    	
    	int currPos = startPos[0] + 1;
    	boolean isInteger = true;
    	
    	while ( currPos < s.length()
    			&& s.charAt( currPos ) != ']' )
    	{
    		if ( s.charAt( currPos ) == '[' )
    		{
    			isInteger = false;
    			currPos++;
    			startPos[0] = currPos;
    			NestedInteger nextLevelNestedInteger = deserializeRecurse( s, startPos );
    			currLevelNestedInteger.add( nextLevelNestedInteger );
    		}
    		else if ( s.charAt( currPos ) == ',' )
    		{
    			currPos++;
    		}
    		else
    		{
    			int value = parseInteger( s, startPos );
    			if ( isInteger )
    			{
    				currLevelNestedInteger.setInteger( value );
    			}
    			else
    			{
    				currLevelNestedInteger.add( new NestedInteger( value ) );
    			}
    		}
        	startPos[0] = currPos;
    	}
    	
    	return currLevelNestedInteger;
    }
    
    private int parseInteger( String s, int[] startPos )
    {
    	int currPos = startPos[0];
		int value = 0;
		while ( currPos < s.length()
				&& s.charAt( currPos ) <= '9'
				&& s.charAt( currPos ) >= '0' )
		{
			value = value * 10 +  s.charAt( currPos ) - '0' ;
			currPos++;
		}
		startPos[0] = currPos;
		return value;
    }
}
