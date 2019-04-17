package facebook.easy;

/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII 
{
    public int removeDuplicates( int[] nums ) 
    {
        if ( nums.length <= 2 )
        {
        	return nums.length;
        }
        
        int count = 1;
        int validPos = 0;
        for ( int i = 1; i < nums.length; i++ )
        {        	
        	if ( nums[i] == nums[validPos] 
        			&& count == 2 )
        	{
        		continue;
        	}
        	
        	if ( nums[i] == nums[validPos] )
        	{
        		count++;
        	}
        	else
        	{
        		count = 1;
        	}

        	validPos++;
        	nums[validPos] = nums[i];        		
        }
        
        return validPos + 1;
    }
}