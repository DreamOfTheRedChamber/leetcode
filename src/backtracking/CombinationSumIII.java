package backtracking;

import java.util.LinkedList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 * */
//TO_TEST
public class CombinationSumIII 
{
    public List<List<Integer>> combinationSum3( int k, int n ) 
    {
    	List<List<Integer>> allCombs = new LinkedList<>();
    	List<Integer> oneComb = new LinkedList<>();
    	generateCombs( allCombs, oneComb, k, n, 1, 9 );
    	return allCombs;
    }
    
    private void generateCombs( List<List<Integer>> allCombs, List<Integer> oneComb, int targetNum, int targetSum, int startPos, int endPos )
    {
    	// recursion base
    	if ( oneComb.size() > targetNum 
    			|| targetSum < 0 )
    	{
    		return;
    	}
    	
    	if ( oneComb.size( ) == targetNum
    			&& targetSum == 0 )
    	{
    		allCombs.add( new LinkedList<>( oneComb ) );
    		return;
    	}
    	
    	// recursion
    	for ( int i = startPos; i <= endPos; i++ )
    	{
    		oneComb.add( i );
    		generateCombs( allCombs, oneComb, targetNum + 1, targetSum - i, i + 1, endPos );
    		oneComb.remove( oneComb.size( ) - 1 );
    	}
    }
}