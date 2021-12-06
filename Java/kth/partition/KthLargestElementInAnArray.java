package kth.partition;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * */

public class KthLargestElementInAnArray 
{
	@Test
	public void test()
	{
		assertEquals( 5, findKthLargestPartition( new int[]{ 3, 2, 1, 5, 6, 4 }, 2 ) );
	}
	
 public int findKthLargest( int[] nums, int k )
 {
  PriorityQueue<Integer> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> o2 - o1 );
  for ( int num : nums )
  {
  	maxQueue.add( num );
  }
  
  int count = 0;
  int result = 0;
  while ( count < k )
  {
  	result = maxQueue.remove();
  	count++;
  }
  
  return result;
 }
 
 public int findKthLargestPartition( int[] nums, int k ) 
 {
  if ( nums == null || nums.length == 0 ) 
  {
   return 0;
  }
   
  return findKthLargestHelper( nums, 0, nums.length - 1, nums.length - k );
 }
  
 private int findKthLargestHelper(int[] nums, int left, int right, int k) 
 {
  if ( left >= right ) 
  {
   return nums[left];
  }
   
  int pivot = partition(nums, left, right);
  if ( pivot == k ) 
  {
   return nums[k];
  }
   
  if ( pivot > k ) 
  {
   return findKthLargestHelper( nums, left, pivot - 1, k );
  } 
  else 
  {
   return findKthLargestHelper( nums, pivot + 1, right, k );
  }
 }
  
 private int partition( int[] nums, int left, int right ) 
 {
  int pivot = nums[left];
  int i = left + 1;
  int j = right;
   
  while ( i <= j ) 
  {
   while ( i <= j && nums[i] < pivot ) 
   {
    i++;
   }
    
   while ( i <= j && nums[j] >= pivot ) 
   {
    j--;
   }
    
   if ( i <= j ) 
   {
    swap( nums, i, j );
   }
  }
   
  swap( nums, left, j );
   
  return j;
 }
  
 private void swap( int[] nums, int i, int j ) 
 {
  int temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
 }

}
