package facebook;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */

public class SparseMatrixMultiplication
{
    public int[][] multiply( int[][] A, int[][] B )
    {
    	if ( A == null || A.length == 0 || A[0].length == 0 
    			|| B == null || B.length == 0 || B[0].length == 0 
    			|| A[0].length != B.length )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int[][] result = new int[A.length][B[0].length];
    	for ( int i = 0; i < A.length; i++ )
    	{
    		for ( int k = 0; k < A[0].length; k++ )
    		{
    			if ( A[i][k] != 0 )
    			{
		    		for ( int j = 0; j < B[0].length; j++ )
		    		{
		    			if ( B[k][j] != 0 )
		    			{
		    				result[i][j] += A[i][k] * B[k][j];
		    			}
		    		}
    			}
    		}
    	}
    	return result;
    }
    
    @Test
    public void test()
    {
    	int[][] A = new int[][]{ { 1, 0, 0}, { -1, 0, 3}};
    	int[][] B = new int[][]{ { 7, 0, 0}, { 0, 0, 0}, { 0, 0, 1}};
    	int[][] result = multiply( A, B );
    	for ( int i = 0; i < result.length; i++ )
    	{
    		for ( int j = 0; j < result[0].length; j++ )
    		{
    			System.out.print(result[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
