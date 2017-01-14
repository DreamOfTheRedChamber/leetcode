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
    	spiralOrder( matrix, 0, 0, matrix.length, matrix[0].length, result );
    	return result;
    }
    
    private void spiralOrder( int[][] matrix, int xCoor, int yCoor, int height, int width, List<Integer> result )
    {
    	// handle edge cases
    	if ( height <= 0 || width <= 0 )
    	{
    		return;
    	}    	
    	if ( height == 1 && width == 1 )
    	{
    		result.add( matrix[xCoor][yCoor] );
    		return;
    	}
    	
    	// handle current level
    	for ( int i = 0; i < width - 1; i++ )
    	{
    		result.add( matrix[xCoor][yCoor++] );
    	}
    	for ( int i = 0; i < height - 1; i++ )
    	{
    		result.add( matrix[xCoor++][yCoor] );
    	}
    	
    	if ( height > 1 )
    	{
    		for ( int i = 0; i < width - 1; i++ )
    		{
    			result.add( matrix[xCoor][yCoor--] );
    		}
    	}
    	
    	if ( width > 1 )
    	{
    		for ( int i = 0; i < height - 1; i++ )
    		{
    			result.add( matrix[xCoor--][yCoor] );
    		}
    	}
    	
    	// recurse for the next level
    	if ( height == 1 || width == 1 )
    	{
    		spiralOrder( matrix, xCoor, yCoor, 1, 1, result );
    	}
    	else
    	{
    		spiralOrder( matrix, xCoor + 1, yCoor + 1, height - 2, width - 2, result );
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
