package dynamicProgramming;

/**
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 
*/

public class HouseRobber
{
    public int rob( int[] nums )
    {
        if ( nums.length == 0 )
        {
        	return 0;
        }
        if ( nums.length == 1 )
        {
        	return nums[0];
        }
        if ( nums.length == 2 )
        {
        	return Math.max( nums[0], nums[1] );
        }
        
        int[] maxAmountLocal = new int[nums.length + 1]; 
        maxAmountLocal[1] = nums[0];
        maxAmountLocal[2] = nums[1];
        for ( int i = 2; i < nums.length; i++ )
        {
        	maxAmountLocal[i+1] = Math.max( maxAmountLocal[i - 1], maxAmountLocal[i - 2] ) + nums[i];
        }
        return Math.max( maxAmountLocal[maxAmountLocal.length - 1], maxAmountLocal[maxAmountLocal.length - 2] );
    }
}