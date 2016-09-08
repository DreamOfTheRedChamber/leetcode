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
// TO_TEST
public class MiniParser 
{
	private int deserialPos;
	
	@Test
	public void test()
	{
		NestedInteger resultOne = deserialize( new String( "324" ) );
		NestedInteger resultTwo = deserialize( new String( "[324]" ) );
		NestedInteger resultThree = deserialize( new String( "[123,[456,[789]]]" ) );
		NestedInteger resultFour = deserialize( new String( "[123,[456,578,[789,090]]]" ) );
	}
	
	public NestedInteger deserialize(String s)
    {
    	if ( s == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	// other assertions
    	
    	deserialPos = 0;
    	return deserializeRecurse( s );
    }
    
    private NestedInteger deserializeRecurse( String s )
    {
    	// recursion base
    	if ( deserialPos >= s.length() )
    	{
    		return null;
    	}    	    	
    	if ( s.charAt( deserialPos ) >= '0'
    			&& s.charAt( deserialPos ) <= '9' )
    	{
    		return new NestedInteger( parseInteger( s ) );
    	}
    	
    	// recursion body
    	NestedInteger currLevelNestedInteger = new NestedInteger();
    	while ( deserialPos < s.length()
    			&& s.charAt( deserialPos ) != ']' )
    	{
    		if ( s.charAt( deserialPos ) == ',' )
    		{
    			deserialPos++;
    		}
    		else if ( s.charAt( deserialPos ) == '[' )
    		{    	
    			NestedInteger nextLevelNestedInteger = new NestedInteger();
        		deserialPos++;
    			while ( deserialPos < s.length() 
    					&& s.charAt( deserialPos ) != ']' )
    			{
            		nextLevelNestedInteger.add( deserializeRecurse( s ) );
            		if ( s.charAt( deserialPos ) == ',' )
            		{
            			deserialPos++;
            		}
            		else if ( s.charAt( deserialPos ) == ']' )
            		{
            			deserialPos++;
            			break;
            		}
            		else
            		{
            			throw new IllegalStateException("");
            		}
    			}
    			currLevelNestedInteger.add( nextLevelNestedInteger );
    		}
    		else
    		{
    			currLevelNestedInteger.add( new NestedInteger(  parseInteger( s ) ) );    			
    		}
    	}
    	
    	if ( deserialPos < s.length( )
    			&& s.charAt( deserialPos ) == ']' )
    	{
    		deserialPos++;
    	}
    	return currLevelNestedInteger;
    }
    
    private int parseInteger( String s )
    {
		int value = 0;
		while ( deserialPos < s.length()
				&& s.charAt( deserialPos ) <= '9'
				&& s.charAt( deserialPos ) >= '0' )
		{
			value = value * 10 +  s.charAt( deserialPos ) - '0' ;
			deserialPos++;
		}
		return value;
    }
}
