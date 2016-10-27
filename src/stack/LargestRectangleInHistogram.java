package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/**
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */
public class LargestRectangleInHistogram
{
    public int largestRectangleArea( int[] heights )
    {
    	if ( heights == null || heights.length == 0 )
    	{
    		return 0;
    	}
    	
    	int maxRecArea = 0;
    	Stack<Integer> incSeq = new Stack<>();
    	incSeq.push( -1 );
    	for ( int i = 0; i < heights.length; i++ )
    	{
    		if ( incSeq.size() > 1 && incSeq.peek() > heights[i] )
    		{
    			maxRecArea = Math.max( maxRecArea, updateMaxRecBefore( incSeq, i, heights[i], heights ) );
    		}
			incSeq.push( i );
    	}
    	maxRecArea = Math.max( maxRecArea, updateMaxRecBefore( incSeq, heights.length, 0, heights ) );
    	return maxRecArea;
    }
    
    private int updateMaxRecBefore( Stack<Integer> incSeq, int nextIndex, int nextValue, int[] heights )
    {
    	int maxRecArea = 0;
    	while ( incSeq.size() > 1 && heights[incSeq.peek()] > nextValue )
    	{
    		int currIndex = incSeq.pop();
    		maxRecArea = Math.max( maxRecArea, heights[currIndex] * ( currIndex - incSeq.peek() ) );
    	}
    	return maxRecArea;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 10, largestRectangleArea( new int[]{ 2, 1, 5, 6, 2, 3} ) );
    	assertEquals( 6, largestRectangleArea( new int[]{ 4, 3, 2, 1} ) );
    	assertEquals( 12, largestRectangleArea( new int[]{ 1, 2, 3, 4, 5, 6} ) );
    }
}