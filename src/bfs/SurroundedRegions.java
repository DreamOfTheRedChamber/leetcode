package bfs;

/**
 * 
 */

public class SurroundedRegions
{
    public void solve(char[][] board) 
    {
    	if ( board.length <= 1 
    			|| board[0].length <= 1 )
    	{
    		return;
    	}
    	
    	int heighth = board.length;
    	int width = board[0].length;
    	
    	// bfs from upper boarder
    	for ( int i = 0; i < width; i++ )
    	{
    		if ( board[0][i] == 'O' )
    		{
    			markUnsurrounded( board, 0, i );
    		}
    	}
    	
    	// bfs from lower boarder
    	for ( int i = 0; i < width; i++ )
    	{
    		if ( board[heighth-1][0] == 'O' )
    		{
    			markUnsurrounded( board, heighth - 1, i );
    		}
    	}
    	
    	// bfs from left boarder
    	for ( int i = 0; i < heighth; i++ )
    	{
    		if ( board[i][0] == 'O' )
    		{
    			markUnsurrounded( board, i, 0 );
    		}
    	}
    	
    	// bfs from right border
    	for ( int i = 0; i < heighth; i++ )
    	{
    		if ( board[i][width-1] == 'O' )
    		{
    			markUnsurrounded( board, i, 0 );
    		}
    	}
    	
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
    }
    
    private void markUnsurrounded( char[][] board, int xStart, int yStart )
    {
    	int heighth = board.length;
    	int width = board[0].length;
    	if ( xStart < 0
    			|| xStart >= heighth
    			|| yStart < 0 
    			|| yStart >= width
    			|| board[xStart][yStart] != 'O' )
    	{
    		return;
    	}
    	
    	board[xStart][yStart] = 'O';
    	markUnsurrounded( board, xStart + 1, yStart );
    	markUnsurrounded( board, xStart - 1, yStart );
    	markUnsurrounded( board, xStart, yStart + 1 );
    	markUnsurrounded( board, xStart, yStart - 1 );
    }
}
