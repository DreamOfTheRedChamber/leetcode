package breathFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */

public class WallsAndGates
{

	private class Coor
	{
		public final int xCoor;
		public final int yCoor;
		public Coor( int xCoor, int yCoor )
		{
			this.xCoor = xCoor;
			this.yCoor = yCoor;
		}
	}
	
    public void wallsAndGates( int[][] rooms )
    {
    	if ( rooms == null
    			|| rooms.length == 0 
    			|| rooms[0].length == 0 )
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	int height = rooms.length;
    	int width = rooms[0].length;

    	// enqueue all gates
    	Queue<Coor> bfsQueue = new LinkedList<>();
    	for ( int i = 0; i < height; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( rooms[i][j] == 0 )
    			{
    				bfsQueue.offer( new Coor( i, j ) );
    			}
    		}
    	}

    	int[][] directions = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    	// bfs traverse
    	while ( !bfsQueue.isEmpty() )
    	{
    		Coor qHead = bfsQueue.poll();
    		for ( int[] direction : directions )
    		{
    			int neighborXCoor = qHead.xCoor + direction[0];
    			int neighborYCoor = qHead.yCoor + direction[1];
    			if ( neighborXCoor < height 
    					&& neighborYCoor < width
    					&& rooms[neighborXCoor][neighborYCoor] == Integer.MAX_VALUE )
    			{
    				rooms[neighborXCoor][neighborYCoor] = rooms[qHead.xCoor][qHead.yCoor] + 1;
    				bfsQueue.offer( new Coor( neighborXCoor, neighborYCoor ) );
    			}
    		}
    	}
    	
    	
    }
    
}
