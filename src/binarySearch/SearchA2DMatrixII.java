package binarySearch;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 * */

//todo
public class SearchA2DMatrixII 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
    	if ( matrix.length == 0 
    			|| matrix[0].length == 0 )
    	{
    		return false;
    	}
    	
    	// better with an object
    	int[] candidateRows = findCandidateRows( matrix, target );
    	if ( candidateRows[0] == -1 )
    	{
    		return false;
    	}
    	int[] candidateCols = findCandidateCols( matrix, target );
    	if ( candidateRows[0] == -1 )
    	{
    		return false;
    	}
    	
    	return true;
    }
    
    // TODO: multiple binary search, combine into one ?
    private int[] findCandidateRows( int[][] matrix, int target )
    {
    	int[] rowIndexRange = new int[]{ -1, -1 };
    	
    	int lastSmallerRowHead = findLastSmallerRow( matrix, target );
    	if ( lastSmallerRowHead == -1 )
    	{
    		return rowIndexRange;
    	}
    	
    	int firstBiggerRowTail = findFirstBiggerRow( matrix, target );
    	if ( lastSmallerRowHead <= firstBiggerRowTail )
    	{
    		rowIndexRange[0] = lastSmallerRowHead;
    		rowIndexRange[1] = firstBiggerRowTail;
    		return rowIndexRange;
    	}
    	else
    	{    		
    		return rowIndexRange;
    	}
    }    
    
    
}