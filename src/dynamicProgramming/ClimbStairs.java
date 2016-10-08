package dynamicProgramming;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * */

public class ClimbStairs
{
	public int climbStairs( int n )
	{
		if ( n < 0 )
		{
			throw new IllegalArgumentException("");
		}
		if ( n <= 2 )
		{
			return n;
		}		
		
		int[] numWays = new int[n + 1];
		numWays[1] = 1;
		numWays[2] = 2;
		for ( int i = 3; i <= n; i++ )
		{
			numWays[i] = numWays[i-1] + numWays[i-2];
		}
		return numWays[n];
	}
}
