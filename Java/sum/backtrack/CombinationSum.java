package sum.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 * */
public class CombinationSum 
{
	public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
		List<List<Integer>> allCombs = new LinkedList<>();
		LinkedList<Integer> oneComb = new LinkedList<>();
		
		generateCombs( allCombs, oneComb, candidates, 0, target );
		
		return allCombs;
    }
	
	private void generateCombs( List<List<Integer>> allCombs, LinkedList<Integer> oneComb, int[] nums, int startPos, int targetSum )
	{
		if ( targetSum < 0 
				|| startPos >= nums.length )
		{
			return;
		}
		
		if ( targetSum == 0 )
		{
			allCombs.add( new LinkedList<>( oneComb ) );
			return;
		}
		
		for ( int i = startPos; i < nums.length; i++ )
		{
			oneComb.addLast( nums[i] );
			generateCombs( allCombs, oneComb, nums, i, targetSum - nums[i] );
			oneComb.removeLast( );
		}
	}
}