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
    public List<Integer> spiralOrderIterative( int[][] matrix )
    {
		List<Integer> result = new ArrayList<Integer>();
		if ( matrix == null || matrix.length == 0 )
			return result;
		int height = matrix.length;
		int width = matrix[0].length;
		int xStart = 0;
		int yStart = 0;
		while ( height > 0 && width > 0 )
		{

			// if one row/column left, no circle can be formed
			if ( height == 1 )
			{
				for ( int i = 0; i < width; i++ )
				{
					result.add( matrix[xStart][yStart++] );
				}
				break;
			}
			else if ( width == 1 )
			{
				for ( int i = 0; i < height; i++ )
				{
					result.add( matrix[xStart++][yStart] );
				}
				break;
			}
			// below, process a circle
			// top - move right
			for ( int i = 0; i < width - 1; i++ )
			{
				result.add( matrix[xStart][yStart++] );
			}
			// right - move down
			for ( int i = 0; i < height - 1; i++ )
			{
				result.add( matrix[xStart++][yStart] );
			}
			// bottom - move left
			for ( int i = 0; i < width - 1; i++ )
			{
				result.add( matrix[xStart][yStart--] );
			}
			// left - move up
			for ( int i = 0; i < height - 1; i++ )
			{
				result.add( matrix[xStart--][yStart] );
			}
			xStart++;
			yStart++;
			height = height - 2;
			width = width - 2;
		}

		return result;
    }

    public List<Integer> spiralOrderRecursive( int[][] matrix )
    {
		if ( matrix == null || matrix.length == 0 )
		{
			return new ArrayList<Integer>();
		}
		return spiralOrder( matrix, 0, 0, matrix.length, matrix[0].length );
    }
    
	private List<Integer> spiralOrder( int[][] matrix, int xStart, int yStart, int height, int width )
	{
		List<Integer> result = new ArrayList<Integer>();
		if ( height <= 0 || width <= 0 )
		{
			return result;
		}
		// only one element left
		if ( height == 1 && width == 1 )
		{
			result.add( matrix[xStart][yStart] );
			return result;
		}

		// top - move right
		for ( int i = 0; i < width - 1; i++ )
		{
			result.add( matrix[xStart][yStart++] );
		}
		// right - move down
		for ( int i = 0; i < height - 1; i++ )
		{
			result.add( matrix[xStart++][yStart] );
		}
		// bottom - move left
		if ( width > 1 )
		{
			for ( int i = 0; i < width - 1; i++ )
			{
				result.add( matrix[xStart][yStart--] );
			}
		}
		// left - move up
		if ( height > 1 )
		{
			for ( int i = 0; i < height - 1; i++ )
			{
				result.add( matrix[xStart--][yStart] );
			}
		}

		if ( height == 1 || width == 1 )
		{
			result.addAll( spiralOrder( matrix, xStart, yStart, 1, 1 ) );
		}
		else
		{
			result.addAll( spiralOrder( matrix, xStart + 1, yStart + 1, height - 2, width - 2 ) );
		}
		return result;
	}
    
    @Test
    public void test()
    {
//    	System.out.println( spiralOrder( new int[][]{ { 1 } } ) );
//    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3, 4 } } ) );    	
//    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3}, {4, 5, 6}, {7, 8, 9} } ) );
//    	System.out.println( spiralOrder( new int[][]{ { 1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} } ) );
    }
}
