
package design;

public class TicTacToe
{

	private int[] player1Row;
	private int[] player1Col;
	private int player1Diagnal;
	private int player1ReverseDiagnal;
	private int[] player2Row;
	private int[] player2Col;
	private int player2Diagnal;
	private int player2ReverseDiagnal;
	private int boardSize;
	
	/** Initialize your data structure here. */
	public TicTacToe( int n )
	{
		player1Row = new int[n];
		player1Col = new int[n];
		player2Row = new int[n];
		player2Col = new int[n];
		boardSize = n;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move( int row, int col, int player )
	{
		if ( player == 1 )
		{
			// record current move
			player1Row[row] += 1;
			player1Col[col] += 1;
			if ( row == col )
			{
				player1Diagnal += 1;
			}
			if ( row + col == boardSize - 1 )
			{
				player1ReverseDiagnal += 1;
			}
			
			// check if win
			if ( player1Row[row] == boardSize
					|| player1Col[col] == boardSize
					|| player1Diagnal == boardSize
					|| player1ReverseDiagnal == boardSize )
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			player2Row[row] += 1;
			player2Col[col] += 1;
			if ( row == col )
			{
				player2Diagnal += 1;
			}
			if ( row + col == boardSize - 1 )
			{
				player2ReverseDiagnal += 1;
			}
			
			// check if win
			if ( player2Row[row] == boardSize
					|| player2Col[row] == boardSize
					|| player2Diagnal == boardSize 
					|| player2ReverseDiagnal == boardSize )
			{
				return 2;
			}
			else
			{
				return 0;
			}
		}
	}
}

/**
 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
 */