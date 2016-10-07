package dynamicProgramming;

/**
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 */
public class PaintHouse
{
	private final static int RED = 0;
	private final static int GREEN = 1;
	private final static int BLUE = 2;
	
    public int minCost( int[][] costs )
    {
    	if ( costs.length == 0 )
    	{
    		return 0;
    	}
    	
    	int numHouse = costs.length;
    	int[][] minCostSum = new int[numHouse][3];
    	minCostSum[0][RED] = costs[0][RED];
    	minCostSum[0][GREEN] = costs[0][GREEN];
    	minCostSum[0][BLUE] = costs[0][BLUE];
    	
    	for ( int i = 1; i < numHouse; i++ )
    	{
    		for ( int color = RED; color <= BLUE; color++ )
    		{
    			minCostSum[i][RED] = Math.min( minCostSum[i-1][GREEN], minCostSum[i-1][BLUE] ) + costs[i][RED];
    			minCostSum[i][BLUE] = Math.min( minCostSum[i-1][RED], minCostSum[i-1][GREEN] ) + costs[i][BLUE];
    			minCostSum[i][GREEN] = Math.min( minCostSum[i-1][BLUE], minCostSum[i-1][RED] ) + costs[i][GREEN];
    		}
    	}
    	
    	return Math.min( Math.min( minCostSum[numHouse-1][RED], minCostSum[numHouse-1][GREEN]), minCostSum[numHouse-1][BLUE] );
    }
}
