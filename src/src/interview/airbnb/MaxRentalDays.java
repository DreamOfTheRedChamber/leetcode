package interview.airbnb;

/**
给一个数组代表reservation request，suppose start date, end date back to back.
比如[5,1,1,5]代表如下预定：
Jul 1-Jul6
Jul6-Jul7
Jul7-Jul8
jul8-Jul13
当然最开始那个Jul 1是随便选就好的啦。
现在input的意义搞清楚了。还有一个限制，就是退房跟开始不能是同一天，比如如果接了Jul 1-Jul6，Jul6-Jul7就不能接了。那问题就是给你个数组，算算最多能把房子租出去多少天。这个例子的话就是10天。
[4,9,6]=10
[4,10,3,1,5]=15
 */

public class MaxRentalDays
{
	public int getMaxRentalDays( int[] reservations )
	{
		
	}
}
