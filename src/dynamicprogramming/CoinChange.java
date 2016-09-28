package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 */

// TODO: refactor
public class CoinChange
{
    public int coinChange( int[] coins, int amount )
    {
    	if ( amount < 0 
    			|| coins.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}    	
    	if ( amount == 0 )
    	{
    		return 0;
    	}
    	
    	Set<Integer> coinSet = new HashSet<>();
    	for ( Integer coin : coins )
    	{
    		coinSet.add( coin );
    	}
    	if ( coinSet.contains( amount ) )
    	{
    		return 1;
    	}
    	
    	int[] minNum = new int[amount + 1];
    	for ( int i = 1; i <= amount; i++ )
    	{    		
    		if ( coinSet.contains( i ) )
    		{
    			minNum[i] = 1;
    			continue;
    		}
    		minNum[i] = Integer.MAX_VALUE;
    		for ( Integer coin : coins )
    		{
    			if ( i - coin > 0 
    					&& minNum[i - coin] > 0 )
    			{
    				minNum[i] = Math.min( minNum[i], minNum[i - coin] + 1 );
    			}
    		}
    		if ( minNum[i] == Integer.MAX_VALUE )
    		{
    			minNum[i] = -1;
    		}
    	}
    	
    	return minNum[amount];
    }
    
    @Test
    public void test()
    {
    	assertEquals( 3, coinChange( new int[]{ 1, 2, 5 }, 11 ) );
    	assertEquals( -1, coinChange( new int[]{ 2 }, 3) );
    }
}
