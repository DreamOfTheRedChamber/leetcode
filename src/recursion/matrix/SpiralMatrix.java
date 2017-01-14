package recursion.matrix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder( int[][] matrix )
    {
    	if ( matrix == null 
    			|| matrix.length == 0 
    			|| matrix[0].length == 0 )
    	{
    		return new ArrayList<>();
    	}

    	List<Integer> result = new ArrayList<>();
    	int height = matrix.length;
    	int width = matrix[0].length;
    	int shorterEdge = Math.min( height, width );
    	int numCycles = shorterEdge / 2 + ( shorterEdge % 2 == 0 ? 0 : 1 ) ;
    	for ( int i = 0; i < numCycles; i++ )
    	{
    		processOneRound( i, height - i * 2, width - i * 2, result, matrix ); 
    	}
    	
    	return result;
    }
    
    private void processOneRound( int start, int height, int width, List<Integer> result, int[][] matrix )
    {
    	int xCoor = start;
    	int yCoor = start;
    	
    	// print upper edge
    	for ( int i = 0; i < width - 1; i++ )
    	{
    		result.add( matrix[xCoor][yCoor + i] );
    	}
    	yCoor += width - 1;
    	
    	// print righter edge
    	for ( int i = 0; i < height - 1; i++ )
    	{
    		result.add( matrix[xCoor + i][yCoor] );
    	}
    	xCoor += height - 1;
    	
    	// print lower edge
    	for ( int i = 0; i < width - 1; i++ )
    	{
    		result.add( matrix[xCoor][yCoor - i ] );
    	}
    	yCoor -= width - 1;
    	
    	// print left edge
    	for ( int i = 0; i < height - 1; i++ )
    	{
    		result.add( matrix[xCoor - i][yCoor] );
    	}
    	
    }
    
    @Test
    public void test()
    {
    	System.out.println( spiralOrder( new int[][]{ { 1 } } ) );
    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3, 4 } } ) );    	
    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3}, {4, 5, 6}, {7, 8, 9} } ) );
    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } ) );
    }
}
