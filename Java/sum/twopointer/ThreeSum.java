package sum.twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * */

public class ThreeSum 
{
 public List<List<Integer>> threeSum( int[] nums )
 {
  Arrays.sort( nums );
  return kSum( 3, 0, 0, nums );
 }
 
 private List<List<Integer>> kSum( int kVal, int target, int startIndex, int[] nums ) 
 {
  List<List<Integer>> result = new LinkedList<>();
  if ( kVal == 0 ) 
  {
   if ( target == 0 )
   {
    result.add( new LinkedList<>() );
   }
   return result;
  }
  
  for ( int i = startIndex; i < nums.length - kVal + 1; i++ ) 
  {
   if ( ( i > startIndex ) && ( nums[i] == nums[i - 1] ) ) 
   {
    continue;
   }
   for ( List<Integer> partialResult : kSum( kVal - 1, target - nums[i], i + 1, nums ) )
   {
    partialResult.add( 0, nums[i] );
    result.add( partialResult );
   }
  }
  return result;
 }
}
