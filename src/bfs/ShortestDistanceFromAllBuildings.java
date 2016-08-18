package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

public class ShortestDistanceFromAllBuildings
{

    public int shortestDistance(int[][] grid) 
    {   
    	if ( grid.length == 0 )
    	{
    		throw new IllegalArgumentException();
    	}
    	
        int[][] minDistSum = new int[grid.length][grid[0].length];
        // bfs from all houses and update distance sum in minDistSum
        for ( int i = 0; i < grid.length; i++ )
        {
        	for ( int j = 0; j < grid[0].length; j++ )
        	{
        		if ( grid[i][j] == 1 )
        		{
        			updateDistSum( grid, minDistSum, i, j);
        		}
        	}
        }
        
        // find minDistSum
        int minDist = Integer.MAX_VALUE;
        for ( int i = 0; i < grid.length; i++ )
        {
        	for ( int j = 0; j < grid[0].length; j++ )
        	{
        		if ( grid[i][j] == 0 )
        		{
        			minDist = Math.min( minDist, minDistSum[i][j] );
        		}
        	}
        }
        
        return minDist;
    }

    private void updateDistSum( int[][] grid, int[][] minDistSum, int startRow, int startCol )
    {
    	int heighth = grid.length;
    	int width = grid[0].length;
    	
    	// bfs from start position inside grid and update minDistSum while 
    	Queue<Coor> currLevelNodes = new LinkedList<>();
    	Queue<Coor> nextLevelNodes = new LinkedList<>();
    	
    	currLevelNodes.offer( new Coor( startRow, startCol ) );
    	
    	int levelDepth = 0;
    	
    	while ( !currLevelNodes.isEmpty( ) )
    	{
    		Coor queueHead = currLevelNodes.remove( );
    		int xCoor = queueHead.xCoor;
    		int yCoor = queueHead.yCoor;

    		// aggregate into minDistSum
    		minDistSum[xCoor][yCoor] += levelDepth;

	    	// check up, down, left, right and add to nextLevelNodes
    		if ( ( xCoor + 1 < heighth ) 
    				&& ( grid[xCoor + 1][yCoor] == 0 ) )
    		{
    			grid[xCoor+1][yCoor] = -1;
    			nextLevelNodes.add( new Coor( xCoor + 1, yCoor ) );
    		}
    		
    		if ( ( xCoor - 1 >= 0) 
    				&& ( grid[xCoor -1][yCoor] == 0 ) )
    		{
    			grid[xCoor-1][yCoor] = -1;
    			nextLevelNodes.add( new Coor( xCoor - 1, yCoor ) );
    		}
    		
    		if ( ( yCoor + 1 < width )
    				&& ( grid[xCoor][yCoor+1] == 0 ) )
    		{
    			grid[xCoor][yCoor+1] = -1;
    			nextLevelNodes.add( new Coor( xCoor, yCoor + 1 ) );
    		}
    		
    		if ( ( yCoor - 1 >= 0 )
    				&& ( grid[xCoor][yCoor-1] == 0) )
    		{
    			grid[xCoor][yCoor-1] = -1;
    			nextLevelNodes.add( new Coor( xCoor, yCoor - 1 ) );
    		}
    		
    		// exhausted curr level
    		if ( currLevelNodes.size( ) == 0 )
    		{
    			currLevelNodes.addAll( nextLevelNodes );
    			nextLevelNodes = new LinkedList<>();
    			levelDepth++;
    		}
    	}
    	
    	// recover grid
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( grid[i][j] == -1 )
    			{
    				grid[i][j] = 0;
    			}
    		}
    	}
    }

    
}

class Coor
{
	public final int xCoor;
	public final int yCoor;
	public Coor( int xCoor, int yCoor )
	{
		this.xCoor = xCoor;
		this.yCoor = yCoor;
	}
}
