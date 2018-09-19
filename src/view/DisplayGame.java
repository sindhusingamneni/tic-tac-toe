package view;

import model.GameModel;

public class DisplayGame {
	private GameModel _gameModel;

	public DisplayGame(GameModel gameModel) {
		this._gameModel = gameModel;
	}
	/**
	 * Display initial board
	 */
	public void displayStartBoard(){
		System.out.println("Welcome to Tic Tac Toe!" + "\n");
		System.out.println("Here's the current board:" + "\n");
		displayBoard();
	}

	/**
	 * Display current board
	 */
	public void displayBoard(){
		String [][]board = _gameModel.getBoard();
		System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
		System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
		System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2]);
		System.out.println();
	}

	public void displayMove(){
		System.out.println("\n" + "Move accepted, here's the current board:" + "\n");
		displayBoard();
	}

	public void displayPieceAlreadyInPlace(){
		System.out.println("\n" + "Oh no, a piece is already at this place! Try again..." + "\n");
	}

	public void displayGameQuit(){
		System.out.println("\n" + "Thanks for playing!" + "\n");
	}

	public void displayDraw(){
		System.out.println("\n" + "No more possible moves. It's a draw!" + "\n");
		displayBoard();
	}

	public void displayWin(){
		System.out.println("\n" + "Move accepted, well done you've won the game!" + "\n");
		displayBoard();
	}
}
