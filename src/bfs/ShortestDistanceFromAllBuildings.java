package bfs;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 
 */

public class ShortestDistanceFromAllBuildings
{

    public int shortestDistance(int[][] grid) 
    {   
    	
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