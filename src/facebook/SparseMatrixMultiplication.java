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

    	Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
    	for ( int i = 0; i < A.length; i++ )
    	{
    		mapA.put( i, new HashMap<>() );
    		for ( int j = 0; j < A[0].length; j++ )
    		{
    			mapA.get( i ).put( j, A[i][j] );
    		}
    	}
    	
    	Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
    	for ( int j = 0; j < B[0].length; j++ )
    	{
    		mapB.put( j, new HashMap<>() );
    		for ( int i = 0; i < B.length; i++ )
    		{
    			mapB.get( j ).put( i, B[i][j] );
    		}
    	}
    	
    	int[][] result = new int[A.length][B[0].length];
    	for ( int i = 0; i < result.length; i++ )
    	{
    		Map<Integer, Integer> rowI = mapA.get( i );
    		for ( int j = 0; j < result[0].length; j++ )
    		{    			
    			Map<Integer, Integer> colJ = mapB.get( j );
    			int entrySum = 0;
    			for ( Integer col : rowI.keySet() ) // A[i][col]
    			{
    				if ( colJ.containsKey( col ) )
    				{
    					entrySum += rowI.get( col ) * colJ.get( col ); // B[col][j]
    				}
    			}    			
    			result[i][j] = entrySum;
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
