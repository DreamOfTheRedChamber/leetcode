package linkedIn;

/**
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime? 
 */
public class PaintHouseII
{
    public int minCostII( int[][] costs )
    {
    	if ( costs.length == 0 || costs[0].length == 0 )
    	{
    		return 0;
    	}
    	int numHouse = costs.length;
    	int numColor = costs[0].length;
    	
    	int prevMin = 0, prevSecondMin = 0, prevMinIndex = 0;
    	for ( int i = 0; i < numHouse; i++ )
    	{
    		int currMin = Integer.MAX_VALUE;
    		int currMinIndex = 0;
    		int currSecondMin = Integer.MAX_VALUE;
    		for ( int j = 0; j < numColor; j++ )
    		{
    			int cost = costs[i][j] + ( prevMinIndex != j ? prevMin : prevSecondMin );
    			if ( cost < currMin )
    			{
    				currSecondMin = currMin;
    				currMin = cost;
    				currMinIndex = j;
    			}
    			else
    			{
    				currSecondMin = Math.min( currSecondMin, cost );
    			}
    		}
    		prevMin = currMin;
    		prevSecondMin = currSecondMin;
    		prevMinIndex = currMinIndex;
    	}
    	return prevMin;
    }
}
