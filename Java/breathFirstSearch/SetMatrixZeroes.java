package breathFirstSearch;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * */

public class SetMatrixZeroes
{
 public void setZeroes( int[][] matrix )
 {
		boolean firstRowZero = false;
		boolean firstColumnZero = false;

		// set first row and column zero or not
		for ( int i = 0; i < matrix.length; i++ )
		{
			if ( matrix[i][0] == 0 )
			{
				firstColumnZero = true;
				break;
			}
		}

		for ( int i = 0; i < matrix[0].length; i++ )
		{
			if ( matrix[0][i] == 0 )
			{
				firstRowZero = true;
				break;
			}
		}

		// mark zeros on first row and column
		for ( int i = 1; i < matrix.length; i++ )
		{
			for ( int j = 1; j < matrix[0].length; j++ )
			{
				if ( matrix[i][j] == 0 )
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// use mark to set elements
		for ( int i = 1; i < matrix.length; i++ )
		{
			for ( int j = 1; j < matrix[0].length; j++ )
			{
				if ( matrix[i][0] == 0 || matrix[0][j] == 0 )
				{
					matrix[i][j] = 0;
				}
			}
		}

		// set first column and row
		if ( firstColumnZero )
		{
			for ( int i = 0; i < matrix.length; i++ )
				matrix[i][0] = 0;
		}

		if ( firstRowZero )
		{
			for ( int i = 0; i < matrix[0].length; i++ )
				matrix[0][i] = 0;
		}
 }
}
