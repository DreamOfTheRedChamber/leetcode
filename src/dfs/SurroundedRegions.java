package dfs;

import org.junit.Test;

/**
	Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	For example,
	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:
	X X X X
	X X X X
	X X X X
	X O X X
 */

public class SurroundedRegions
{
	@Test
	public void test()
	{
		char[][] board = new char[][]{ { 'X', 'X', 'X', 'X' }, 
									   { 'X', 'O', 'O', 'X' },
									   { 'X', 'X', 'O', 'X' },
									   { 'X', 'O', 'X', 'X' } };		
		solve( board );
	}
	
    public void solve(char[][] board)
    {
    	if ( board.length <= 1 
    			|| board[0].length <= 1 )
    	{
    		return;
    	}
    	
    	int heighth = board.length;
    	int width = board[0].length;
    	
    	// bfs from upper/lower boarder
    	for ( int i = 0; i < width; i++ )
    	{
    		if ( board[0][i] == 'O' )
    		{
    			markUnsurrounded( board, 0, i );
    		}
    		if ( board[heighth-1][i] == 'O' )
    		{
    			markUnsurrounded( board, heighth - 1, i );
    		}
    	}
    	    	
    	// bfs from left/right boarder
    	for ( int i = 0; i < heighth; i++ )
    	{
    		if ( board[i][0] == 'O' )
    		{
    			markUnsurrounded( board, i, 0 );
    		}
    		if ( board[i][width-1] == 'O' )
    		{
    			markUnsurrounded( board, i, 0 );
    		}
    	}
    	    	
    	printBoard( board );
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			if ( board[i][j] == 'O' )
    			{
    				board[i][j] = 'X';
    			}
    			if ( board[i][j] == '#' )
    			{
    				board[i][j] = 'O';
    			}
    		}
    	}
    	printBoard( board );
    }
    
    // use '#' to mark visited 'O'
    private void markUnsurrounded( char[][] board, int xStart, int yStart )
    {
    	int heighth = board.length;
    	int width = board[0].length;
    	if ( xStart < 0
    			|| xStart >= heighth
    			|| yStart < 0 
    			|| yStart >= width
    			|| board[xStart][yStart] != 'O' ) // avoid visiting visited 'O's and 'X's
    	{
    		return;
    	}
    	
    	board[xStart][yStart] = '#';
    	markUnsurrounded( board, xStart + 1, yStart );
    	markUnsurrounded( board, xStart - 1, yStart );
    	markUnsurrounded( board, xStart, yStart + 1 );
    	markUnsurrounded( board, xStart, yStart - 1 );
    }
    
    private void printBoard( char[][] board )
    {
    	int heighth = board.length;
    	int width = board[0].length;
    	for ( int i = 0; i < heighth; i++ )
    	{
    		for ( int j = 0; j < width; j++ )
    		{
    			System.out.print( board[i][j] + " ");
    		}
    		System.out.println("");
    	}
    	System.out.println("");
    }
}
