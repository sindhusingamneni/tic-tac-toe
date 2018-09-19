package model;
import model.BoardToken;

public class Model {
	private String[][] _gameBoard;
	private final String _playerOneBoardToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	private final String _playerTwoBoardToken = BoardToken.PLAYERTWOTOKEN.getBoardToken(); 
	private final String _emptySlotBoardToken = BoardToken.EMPTYSLOTTOKEN.getBoardToken(); 
	private int _tokenCountToWin = 3;

	public Model() {
		this._gameBoard = new String[3][3];
	}

	public String[][] getBoard() {
		return _gameBoard;
	}

	public void setInitialBoard() {
		for (int i = 0; i < _gameBoard.length; i++) { 
			for (int j = 0; j < _gameBoard[i].length; j++) {
				_gameBoard[i][j] = "."; 
			} 
		} 
	}

	public void updateBoard(int playerNumber, int rowCoordinate, int columnCoordinate) {
		String boardInput = "";
		if (playerNumber == 1){
			boardInput = _playerOneBoardToken;
		} else if (playerNumber == 2){
			boardInput = _playerTwoBoardToken;
		}
		_gameBoard[rowCoordinate][columnCoordinate]=boardInput;
	}

	public boolean boardHasWin(int playerNumber, int xCoordinate, int yCoordinate){
		String playerToken = null;
		if (playerNumber == 1){
			playerToken = _playerOneBoardToken;
		} else if (playerNumber == 2){
			playerToken = _playerTwoBoardToken;
		}

		int rowCount = 0;
		int columnCount = 0;
		int leftDiagonalCount = 0;
		int rightDiagonalCount = 0;

		for(int i=0; i<_gameBoard.length;i++) {
			if(_gameBoard[i][i] == playerToken){
				leftDiagonalCount++;
			}
			if(_gameBoard[(_gameBoard.length-1)-i][i] == playerToken){
				rightDiagonalCount++;	
			}
			if(_gameBoard[xCoordinate][i] == playerToken){
				rowCount++;
			}
			if(_gameBoard[i][yCoordinate] == playerToken){
				columnCount++;
			}
		}

		if(rightDiagonalCount== _tokenCountToWin || leftDiagonalCount== _tokenCountToWin || rowCount == _tokenCountToWin || columnCount == _tokenCountToWin){
			return true;
		}

		return false;
	}

	public boolean checkValidMove(int rowCoordinate, int columnCoordinate){
		if(_gameBoard[rowCoordinate][columnCoordinate].equals(_emptySlotBoardToken)){
			return true;
		}
		return false;
	}

}
