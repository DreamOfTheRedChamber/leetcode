package depthFirstSearch;

import java.util.List;

import utility.NestedInteger;

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

public class NestedListWeightSumII
{
    public int depthSumInverse( List<NestedInteger> nestedList )
    {
        return calcWeightSum( nestedList, calcMaxNestDepth( nestedList, 1 ) );
    }
    
    private int calcWeightSum( List<NestedInteger> nestedList, int currDepth )
    {
    	int weightSum = 0;
    	for ( NestedInteger num : nestedList )
    	{
    		if ( num.isInteger() )
    		{
    			weightSum += num.getInteger() * currDepth;
    		}
    		else
    		{
    			weightSum += calcWeightSum( num.getList(), currDepth - 1 );
    		}
    	}
    	return weightSum;
    }
    
    private int calcMaxNestDepth( List<NestedInteger> nestedList, int baseDepth )
    {
    	int maxDepth = baseDepth;
    	for ( NestedInteger num : nestedList )
    	{
    		if ( !num.isInteger() )
    		{
    			maxDepth = Math.max( maxDepth, calcMaxNestDepth( num.getList() , baseDepth + 1 ) );
    		}
    	}
    	return maxDepth;
    }
}
