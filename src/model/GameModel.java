package model;
import model.BoardToken;

public class GameModel {
	private String[][] _gameBoard;
	private final String _playerOneBoardToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	private final String _playerTwoBoardToken = BoardToken.PLAYERTWOTOKEN.getBoardToken(); 
	private final String _emptySlotBoardToken = BoardToken.EMPTYSLOTTOKEN.getBoardToken(); 
	private int _tokenCountToWin = 3;

	public GameModel() {
		this._gameBoard = new String[3][3];
	}

	public String[][] getBoard() {
		return _gameBoard;
	}

	/**
	 * Set the initial empty board
	 */
	public void setInitialBoard() {
		for (int i = 0; i < _gameBoard.length; i++) { 
			for (int j = 0; j < _gameBoard[i].length; j++) {
				_gameBoard[i][j] = "."; 
			} 
		} 
	}

	/**
	 * Update the board according to the coordinate input for the player by placing the player's token at the coordinate
	 */
	public void updateBoard(int playerNumber, int rowCoordinate, int columnCoordinate) {
		String boardInput = "";
		if (playerNumber == 1){
			boardInput = _playerOneBoardToken;
		} else if (playerNumber == 2){
			boardInput = _playerTwoBoardToken;
		}
		// Place player token at the coordinate
		_gameBoard[rowCoordinate][columnCoordinate]=boardInput;
	}

	/**
	 * Check whether the move carried out has produced a win
	 * @return boolean of whether there is a win in the board
	 */
	public boolean boardHasWin(int playerNumber, int xCoordinate, int yCoordinate){
		String currentPlayerToken = null;
		if (playerNumber == 1){
			currentPlayerToken = _playerOneBoardToken;
		} else if (playerNumber == 2){
			currentPlayerToken = _playerTwoBoardToken;
		}

		int rowCount = 0;
		int columnCount = 0;
		int leftDiagonalCount = 0;
		int rightDiagonalCount = 0;

		// Check whether the token that has just been placed by the player has resulted in a win either in the row,
		// column or in the diagonals
		for(int i=0; i<_gameBoard.length;i++) {
			if(_gameBoard[i][i] == currentPlayerToken){
				leftDiagonalCount++;
			}
			if(_gameBoard[(_gameBoard.length-1)-i][i] == currentPlayerToken){
				rightDiagonalCount++;	
			}
			// Only check the row where the token was placed for win
			if(_gameBoard[xCoordinate][i] == currentPlayerToken){
				rowCount++;
			}
			// Only check the column where the token was placed for win
			if(_gameBoard[i][yCoordinate] == currentPlayerToken){
				columnCount++;
			}
		}
		// If any of these counts are at the required number for win, then there
		// is a win in the board according to the move that was just played
		if(rightDiagonalCount== _tokenCountToWin || leftDiagonalCount== _tokenCountToWin || 
				rowCount == _tokenCountToWin || columnCount == _tokenCountToWin){
			return true;
		}

		return false;
	}

	/**
	 * Check whether the token can be placed in the coordinate location or not
	 * @return boolean of whether the token can be placed
	 */
	public boolean checkValidMove(int rowCoordinate, int columnCoordinate){
		if(_gameBoard[rowCoordinate][columnCoordinate].equals(_emptySlotBoardToken)){
			return true;
		}
		return false;
	}

}
