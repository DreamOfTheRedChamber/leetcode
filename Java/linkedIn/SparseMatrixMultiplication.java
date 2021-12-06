package linkedIn;

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
 
 public int[][] multiplySparse( int[][] A, int[][] B )
 {
  if (A == null || A[0] == null || B == null || B[0] == null) return null;
  int m = A.length, n = A[0].length, l = B[0].length;
  int[][] C = new int[m][l];
  Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();
  
  for( int k = 0; k < n; k++ ) 
  {
   tableB.put( k, new HashMap<Integer, Integer>() );
   for( int j = 0; j < l; j++ ) 
   {
    if ( B[k][j] != 0 )
    {
     tableB.get( k ).put( j, B[k][j] );
    }
   }
  }

  for( int i = 0; i < m; i++ ) 
  {
   for( int k = 0; k < n; k++ ) 
   {
    if ( A[i][k] != 0 )
    {
     for ( Integer j: tableB.get(k).keySet() ) 
     {
      C[i][j] += A[i][k] * tableB.get(k).get(j);
     }
    }
   }
  }
  return C;   
 }
 
 public int[][] multiplyNaive( int[][] A, int[][] B )
 {
 	int[][] result = new int[A.length][B[0].length];
 	for ( int i = 0; i < A.length; i++ )
 	{
 		for ( int j = 0; j < B[0].length; j++ )
 		{
 			for ( int k = 0; k < A[0].length; k++ )
 			{
 				result[i][j] += A[i][k] * B[k][j];
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
