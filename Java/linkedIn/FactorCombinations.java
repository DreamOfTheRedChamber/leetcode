package linkedIn;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 * */
public class FactorCombinations 
{
    public List<List<Integer>> getFactors( int n )
    {
    	List<List<Integer>> allResults = new LinkedList<>();
    	LinkedList<Integer> oneResult = new LinkedList<>();
    	getFactors( allResults, oneResult, n, 2 );
    	return allResults;
    }
    
    private void getFactors( List<List<Integer>> allResults, LinkedList<Integer> oneResult, int n, int startVal )
    {
    	if ( n == 1 )
    	{
    		if ( oneResult.size() > 1 )
    		{
    			allResults.add( new LinkedList<>( oneResult ) );
    		}
    		return;
    	}
    	
    	for ( int i = startVal; i <= n; i++ )
    	{
    		if ( n % i == 0 )
    		{
    			oneResult.addLast( i );
    			getFactors( allResults, oneResult, n / i, i );
    			oneResult.removeLast();
    		}
    	}
    }
    
    @Test
    public void test()
    {
    	for ( List<Integer> list : getFactors( 12 ) )
    	{
    		System.out.println( list );
    	}
    }
}
