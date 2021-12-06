package sum.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * */
public class CombinationSumII 
{
    public List<List<Integer>> combinationSum2( int[] candidates, int target )
    {
    	List<List<Integer>> allCombs = new LinkedList<>();
    	LinkedList<Integer> oneComb = new LinkedList<>();
    	Arrays.sort( candidates );
    	generateCombs( allCombs, oneComb, candidates, 0, target );
    	return allCombs;   	
    }
    
    private void generateCombs( List<List<Integer>> allCombs, LinkedList<Integer> oneComb, int[] candidates, int startPos, int targetSum )
    {
    	// if candidates all positive, then could avoid unnecessary scannings
    	if ( targetSum < 0 )
    	{
    		return;
    	}
    	
    	if ( targetSum == 0 )
    	{
    		allCombs.add( new LinkedList<>( oneComb ) );
    		return;
    	}
    	
    	for ( int i = startPos; i < candidates.length; i++ )
    	{
    		if ( i > startPos
    				&& candidates[i] == candidates[i-1] )
    		{
    			continue;
    		}
    		oneComb.addLast( candidates[i] );
    		generateCombs( allCombs, oneComb, candidates, i + 1, targetSum - candidates[i] );
    		oneComb.removeLast();
    	}
    }    
}
