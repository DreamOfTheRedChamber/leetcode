package forwardbackwardtraversal;

import java.util.Arrays;

import org.junit.Test;

/**
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.) 
 */
public class ProductOfArrayExceptSelf
{
    public int[] productExceptSelf( int[] nums )
    {
    	if ( nums == null || nums.length <= 1 )
    	{
    		return new int[0];
    	}
    	
        int[] result = new int[nums.length];

        int prefixProduct = 1;
        result[0] = 1;
        for ( int i = 1; i < result.length; i++ )
        {
        	prefixProduct *= nums[i-1];
        	result[i] = prefixProduct;
        }
        
        int suffixProduct = 1;
        result[nums.length-1] = prefixProduct;
        for ( int i = nums.length - 2; i >= 0; i-- )
        {
        	suffixProduct *= nums[i+1];
        	result[i] *= suffixProduct;
        }
        
        return result;
    }
    
    @Test
    public void test()
    {
    	System.out.println( Arrays.toString( productExceptSelf( new int[]{ 1, 2, 3, 4} ) ) );
    }
}
