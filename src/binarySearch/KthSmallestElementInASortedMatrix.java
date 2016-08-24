package binarySearch;

import java.util.PriorityQueue;

/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
 * */

// todo
public class KthSmallestElementInASortedMatrix 
{
    public int kthSmallest( int[][] matrix, int k )
    {
        if ( k <= 0 
        		|| matrix.length == 0 
        		|| matrix[0].length == 0
        		|| matrix.length * matrix[0].length < k )
        {
        	throw new IllegalArgumentException("");
        }
        
        int heighth = matrix.length;
        int width = matrix[0].length;
        boolean[][] isUsed = new boolean[heighth][width];
        PriorityQueue<MatrixEntry> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.val - o2.val ) );
        minQueue.offer( new MatrixEntry( 0, 0, matrix[0][0] ) );
        isUsed[0][0] = true;
        
        int numCounter = 0;
        int result = 0;
        while ( numCounter < k )
        {
        	numCounter++;
        	MatrixEntry qHead = minQueue.poll();
        	result = qHead.val;
        	if ( qHead.xCoor + 1 < heighth 
        			&& !isUsed[qHead.xCoor + 1][qHead.yCoor] )
        	{
        		isUsed[qHead.xCoor + 1][qHead.yCoor] = true;
        		minQueue.offer( new MatrixEntry( qHead.xCoor + 1, qHead.yCoor, matrix[qHead.xCoor][qHead.yCoor] ) );
        	}
        	if ( qHead.xCoor + 1 < heighth 
        			&& !isUsed[qHead.xCoor][qHead.yCoor + 1] )
        	{
        		isUsed[qHead.xCoor][qHead.yCoor] = true;
        		minQueue.offer( new MatrixEntry( qHead.xCoor, qHead.yCoor+1, matrix[qHead.xCoor][qHead.yCoor + 1] ) );
        	}
        }
        
        return result;
    }
}

class MatrixEntry
{
	public final int xCoor;
	public final int yCoor;
	public final int val;
	public MatrixEntry( int xCoor, int yCoor, int val )
	{
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.val = val;
	}
}