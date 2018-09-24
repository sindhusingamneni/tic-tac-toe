package model;
import model.GameEnum;

public class GameModel {
	private String[][] _gameBoard;
	private final String _playerOneBoardToken = GameEnum.PLAYERONETOKEN.getBoardToken();
	private final String _playerTwoBoardToken = GameEnum.PLAYERTWOTOKEN.getBoardToken(); 
	private final String _emptySlotBoardToken = GameEnum.EMPTYSLOTTOKEN.getBoardToken(); 
	private static final int BOARDROWLENGTH =3;
	private static final int BOARDCOLUMNLENGTH =3;
	private GameWin _gameWin;

	public GameModel() {
		this._gameBoard = new String[BOARDROWLENGTH][BOARDCOLUMNLENGTH];
		this._gameWin = new GameWin(this);
	}

	public String[][] getBoard() {
		return _gameBoard;
	}

	public void setInitialBoard() {
		for (int i = 0; i < BOARDROWLENGTH; i++) { 
			for (int j = 0; j < BOARDCOLUMNLENGTH; j++) {
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


	public boolean boardHasWin(int playerNumber, int xCoordinate, int yCoordinate){
		return _gameWin.boardHasWin(playerNumber, xCoordinate, yCoordinate);
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
