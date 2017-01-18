package recursion.matrix;

/**
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII
{
    public int[][] generateMatrixIterative( int n )
    {
    	if ( n < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int[][]	 result = new int[n][n];
    	int num = 1;
    	int top = 0, bottom = n - 1, left = 0, right = n - 1;
    	while ( left < right && top < bottom )
    	{
    		for ( int col = left; col < right; col++ )
    		{
    			result[top][col] = num++;
    		}
    		for ( int row = top; row < bottom; row++ )
    		{
    			result[row][right] = num++;
    		}
    		for ( int col = right; col > left; col-- )
    		{
    			result[bottom][col] = num++;
    		}
    		for ( int row = bottom; row > top; row-- )
    		{
    			result[row][left] = num++;
    		}
    		
    		left++;
    		right--;
    		top++;
    		bottom--;
    	}
    	
    	if ( n % 2 != 0 )
    	{
    		result[n / 2][n / 2] = num;
    	}
    	
        return result;
    }
}
