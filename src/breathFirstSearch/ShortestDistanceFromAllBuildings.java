package breathFirstSearch;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x – p1.x| + |p2.y – p1.y|.

For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 – 0 – 2 – 0 – 1
|    |     |     |    |
0 – 0 – 0 – 0 – 0
|     |     |     |    |
0 – 0 – 1 – 0 – 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */

public class ShortestDistanceFromAllBuildings
{

    public int shortestDistance(int[][] grid)
    {   
    	if ( grid == null || grid.length == 0 || grid[0].length == 0 )
    	{
    		return -1;
    	}
    	
    	int heighth = grid.length;
    	int width = grid[0].length;
    	int[][] distSum = new int[heighth][width];
    	int[][] numReached = new int[heighth][width];     	// num buildings reached from current land
    	int[][] directions = new int[][]{ { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    	int houseNum = 0;
    	
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			// start bfs from each building
    			if ( grid[i][j] == 1 )
    			{
    				houseNum++;
    				int bfsLevel = 0;
    				boolean[][] visited = new boolean[heighth][width];
    				Queue<Integer> bfsQueue = new LinkedList<>();
    				bfsQueue.add( i * width + j );
    				visited[i][j] = true;
    				while ( !bfsQueue.isEmpty() )
    				{
    					int levelSize = bfsQueue.size();
    					for ( int t = 0; t < levelSize; t++ )
    					{
    						int head = bfsQueue.remove();
    						int xCoor = head / width;
    						int yCoor = head % width;
    						
    						// bfs four directions for traversing
    						for ( int[] direction : directions )
    						{
    							int xCoorNeighbor = xCoor + direction[0];
    							int yCoorNeighbor = yCoor + direction[1];
    							if ( xCoorNeighbor >= 0
    									&& xCoorNeighbor < heighth
    									&& yCoorNeighbor >= 0
    									&& yCoorNeighbor < width
    									&& !visited[xCoorNeighbor][yCoorNeighbor]
    									&& grid[xCoorNeighbor][yCoorNeighbor] == 0 )
    							{
    								bfsQueue.add( xCoorNeighbor * width + yCoorNeighbor );
    								visited[xCoorNeighbor][yCoorNeighbor] = true;
    								distSum[xCoorNeighbor][yCoorNeighbor] += bfsLevel + 1;
    								numReached[xCoorNeighbor][yCoorNeighbor]++;
    							}
    						}
    					}
    					bfsLevel++;
    				}
    			}
    		}    		
    	}
    	
    	int minDist = Integer.MAX_VALUE;
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == 0 
    					&& numReached[i][j] == houseNum )
    			{
    				minDist = Math.min( minDist, distSum[i][j] );
    			}
    		}
    	}
    	return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    @Test
    public void singleSpace()
    {
    	assertEquals( -1, shortestDistance( new int[][]{ { 1 } } ) );
    	assertEquals( -1, shortestDistance( new int[][]{ { 2 } } ) );
    	assertEquals( 0, shortestDistance( new int[][]{ { 0 } } ) );
    }
    
    @Test
    public void singleBuilding()
    {
    	assertEquals( 1, shortestDistance( new int[][]{ {0, 0, 1} }) );
    }
    
    @Test
    public void noSpace()
    {
    	assertEquals( -1, shortestDistance( new int[][]{ { 1, 1, 1} } ) );
    }
    
    @Test
    public void notAllReacheable()
    {
    	assertEquals( -1, shortestDistance( new int[][]{ {1, 2, 0} } ) );
    	assertEquals( -1, shortestDistance( new int[][]{ {0, 2, 1}, {1, 0, 2}, {0, 1, 0} } ) );
    }
    
    @Test
    public void normalElem()
    {
    	assertEquals( 7, shortestDistance( new int[][]{ {1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0} } ) );
    }    
}