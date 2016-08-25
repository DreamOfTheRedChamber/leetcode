package dynamicprogramming;

/**
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2DMutable
{
	private int[][] rowPrefixSum;
	private int[][] matrix;
	private int heighth;
	private int width;
	
	public RangeSumQuery2DMutable( int[][] matrix )
	{
		this.matrix = matrix;
		this.heighth = matrix.length;
		this.width = matrix[0].length;
		if ( width == 0 )
		{
			return;
		}
		
		for ( int i = 0; i < heighth; i++ )
		{
			rowPrefixSum[i][0] = matrix[i][0];
			for ( int j = 1; j < width; j++ )
			{
				rowPrefixSum[i][j] = rowPrefixSum[i][j-1] + matrix[i][j];
			}
		}
	}

    public void update( int row, int col, int val )
    {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for ( int j = col; j < width; j++ )
        {
        	rowPrefixSum[row][j] += diff;
        }
    }

    public int sumRegion( int row1, int col1, int row2, int col2 )
    {
    	int totalSum = 0;
        if ( col1 == 0 )
        {
        	for ( int i = row1; i <= row2; i++ )
        	{
        		totalSum += rowPrefixSum[i][col2];
        	}
        }
        else
        {
        	for ( int i = row1; i <= row2; i++ )
        	{
        		totalSum += rowPrefixSum[col1-1][col2];
        	}
        }
        return totalSum;
    }

}
