package model;

public class GameWin {
	private GameModel _gameModel;
	private String [][] gameBoard;
	private final String _playerOneBoardToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	private final String _playerTwoBoardToken = BoardToken.PLAYERTWOTOKEN.getBoardToken(); 
	private static final int TOKENCOUNTTOWIN = 3;

	public GameWin(GameModel gameModel) {
		this._gameModel = gameModel;
	}

	public boolean boardHasWin(int playerNumber, int xCoordinate, int yCoordinate){
		String currentPlayerToken = obtainCurrentPlayerToken(playerNumber);
		gameBoard = _gameModel.getBoard();
		// Check whether the token that has just been placed by the player has resulted in a win either in the row,
		// column or in the diagonals
		int leftDiagonalCount = getLeftDiagonalCount(currentPlayerToken);
		int rightDiagonalCount = getRightDiagonalCount(currentPlayerToken);
		int rowCount = getRowCount(currentPlayerToken, xCoordinate);
		int columnCount = getColumnCount(currentPlayerToken, yCoordinate);

		return checkWin(rightDiagonalCount,leftDiagonalCount, rowCount, columnCount);
	}

	private String obtainCurrentPlayerToken(int playerNumber){
		String currentPlayerToken = null;
		if (playerNumber == 1){
			currentPlayerToken = _playerOneBoardToken;
		} else if (playerNumber == 2){
			currentPlayerToken = _playerTwoBoardToken;
		}
		return currentPlayerToken;
	}

	private int getLeftDiagonalCount(String currentPlayerToken){
		int leftDiagonalCount = 0;
		for(int i=0; i<gameBoard.length;i++) {
			if(gameBoard[i][i] == currentPlayerToken){
				leftDiagonalCount++;
			}
		}
		return leftDiagonalCount;
	}

	private int getRightDiagonalCount(String currentPlayerToken){
		int rightDiagonalCount = 0;
		for(int i=0; i<gameBoard.length;i++) {
			if(gameBoard[(gameBoard.length-1)-i][i] == currentPlayerToken){
				rightDiagonalCount++;	
			}
		}
		return rightDiagonalCount;
	}

	private int getRowCount(String currentPlayerToken, int xCoordinate){
		int rowCount = 0;
		for(int i=0; i<gameBoard.length;i++) {
			// Only check the row where the token was placed for win
			if(gameBoard[xCoordinate][i] == currentPlayerToken){
				rowCount++;
			}
		}
		return rowCount;
	}

	private int getColumnCount(String currentPlayerToken, int yCoordinate){
		int columnCount = 0;
		for(int i=0; i<gameBoard.length;i++) {
			// Only check the column where the token was placed for win
			if(gameBoard[i][yCoordinate] == currentPlayerToken){
				columnCount++;
			}
		}
		return columnCount;
	}

	private boolean checkWin(int rightDiagonalCount, int leftDiagonalCount, int rowCount, int columnCount){
		// If any of these counts are at the required number for win, then there
		// is a win in the board according to the move that was just played
		if(rightDiagonalCount== TOKENCOUNTTOWIN || leftDiagonalCount== TOKENCOUNTTOWIN || 
				rowCount == TOKENCOUNTTOWIN || columnCount == TOKENCOUNTTOWIN){
			return true;
		}
		return false;
	}

}
