package sum;

/**
Given an array of n integers nums and a target, 
find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?
 */

public class ThreeSumSmaller
{
    public int threeSumSmaller( int[] nums, int target )
    {
    	if ( nums.length < 3 )
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	int totalNum = 0;
    	for ( int i = 0; i < nums.length - 2; i++ )
    	{    		
    		totalNum += twoSumSmaller( nums, target - nums[i], i + 1 );
    	}
    	return totalNum;
    }
    
    private int twoSumSmaller( int[] nums, int target, int start )
    {
    	int totalNum = 0;
    	for ( int i = start; i < nums.length - 1; i++ )
    	{
        	int left = i;
        	int right = nums.length - 1;

        	// could be replaced with binary search
        	while ( left < right && nums[left] + nums[right] >= target )
    		{
    			right--;
    		}
        	
    		if ( nums[left] + nums[right] < target )
    		{
    			totalNum += right - left;
    		}
    	}
    	return totalNum;
    }
}