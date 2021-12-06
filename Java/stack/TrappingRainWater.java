package stack;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 */
public class TrappingRainWater
{
 public int trap( int[] height )
 {
 	Stack<Integer> decSeq = new Stack<>();
 	int totalWater = 0;
 	for ( int i = 0; i < height.length; i++ )
 	{
 		if ( decSeq.isEmpty() 
 				|| height[decSeq.peek()] > height[i] )
 		{
 			decSeq.push( i );
 		}
 		else
 		{   
	 		while ( decSeq.size() > 1 && height[decSeq.peek()] < height[i] )
	 		{
	 			int currIndex = decSeq.pop();
	 			totalWater += ( Math.min( height[decSeq.peek()], height[i] ) - height[currIndex] ) * ( i - decSeq.peek() - 1 );
	 		}
	 		
	 		if ( decSeq.size() == 1 && height[decSeq.peek()] <= height[i] )
	 		{
	 			decSeq.pop();
	 		}
	 		decSeq.push( i );	 				
 		}
 	}
 	return totalWater;
 }
 
 @Test
 public void test()
 {
 	assertEquals( 6, trap( new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1} ) );
 	assertEquals( 7, trap( new int[]{ 3, 1, 1, 1, 2, 4}) );
 }
}