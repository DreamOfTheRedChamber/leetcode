package backtracking;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * */

public class Combinations 
{
    public List<List<Integer>> combine( int n, int k )
    {
    	List<List<Integer>> allCombs = new LinkedList<>();
    	List<Integer> oneComb = new LinkedList<>();
    	generateCombs( allCombs, oneComb, 0, n, k );
    	return allCombs;
    }
    
    private void generateCombs( List<List<Integer>> allCombs, List<Integer> oneComb, int start, int end, int k )
    {
    	if ( k == 0 )
    	{
    		allCombs.add( new LinkedList<>( oneComb ) );
    	}
    	
    	for ( int i = start; i <= end; i++ )
    	{
    		oneComb.add( i );
    		generateCombs( allCombs, oneComb, i + 1, end, k - 1 );
    		oneComb.remove( oneComb.size() - 1 );
    	}
    }
    
    @Test
    public void test()
    {
    	System.out.print( combine(3 ,2) );
    }
}