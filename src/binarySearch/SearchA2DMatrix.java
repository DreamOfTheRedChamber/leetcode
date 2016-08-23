package binarySearch;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 * */

public class SearchA2DMatrix 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
    	if ( matrix.length == 0 
    			|| matrix[0].length == 0 )
    	{
    		return false;
    	}
    	
    	int rowIndex = findLastSmallerRowHead( matrix, target );
    	if ( rowIndex == -1 )
    	{
    		return false;
    	}
    	int colIndex = binarySearch( matrix, rowIndex, target );
    	if ( colIndex == -1 )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    private int binarySearch( int[][] matrix, int rowIndex, int target )
    {
    	int start = 0;
    	int end = matrix[0].length - 1;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		if ( matrix[rowIndex][mid] < target )
    		{
    			start = mid + 1;
    		}
    		else if ( matrix[rowIndex][mid] > target )
    		{
    			end = mid - 1;
    		}
    		else
    		{
    			return mid;
    		}
    	}
    	
    	if ( matrix[rowIndex][start] == target )
    	{
    		return start;
    	}
    	else if ( matrix[rowIndex][end] == target )
    	{
    		return end;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    /**
     * @return  index of last smaller row head, -1 for nonexistence
     */
    private int findLastSmallerRowHead( int[][] matrix, int target )
    {
    	int start = 0;
    	int end = matrix.length - 1;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		if ( matrix[mid][0] <= target )
    		{
    			start = mid;
    		}
    		else //if ( matrix[mid][0] > target )
    		{
    			// TODO: binary search conditions
    			end = mid - 1;
    		}
    	}
    	
    	if ( matrix[end][0] <= target )
    	{
    		return end;
    	}
    	else if ( matrix[start][0] <= target )
    	{
    		return start;
    	}
    	else
    	{
    		return -1;
    	}
    }   
}