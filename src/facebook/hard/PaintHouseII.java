package facebook.hard;

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
    	int numHouse = costs.length;
    	int numColor = costs[0].length;
    	
    	int[] minCost = new int[numColor];
    	int min1 = 0;
    	int min2 = 0;
    	
    	for ( int i = 0; i < numHouse; i++ )
    	{
    		int oldMin1 = min1;
    		int oldMin2 = min2;
    		
    		min1 = Integer.MAX_VALUE;
    		min2 = Integer.MAX_VALUE;
    		
    		for ( int j = 0; j < numColor; j++ )
    		{
    			if ( minCost[j] != oldMin1 || oldMin1 == oldMin2 )
    			{
    				minCost[j] = oldMin1 + costs[i][j];
    			}
    			else
    			{
    				minCost[j] = oldMin2 + costs[i][j];
    			}
    			
    			if ( min1 <= minCost[j] )
    			{
    				min2 = Math.min( min2, minCost[j] );
    			}
    			else
    			{
    				min2 = min1;
    				min1 = minCost[j];
    			}
    		}
    	}
    	
    	return min1;    	
    }
}
