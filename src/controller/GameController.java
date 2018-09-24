package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.GameModel;
import view.DisplayGame;
import model.BoardToken;
import controller.PlayerInput;

public class GameController {
	private GameModel _gameModel;
	private DisplayGame _gameView;
	private int _player = 1;
	private static final int PLAYERONENUMBER =1;
	private static final int PLAYERTWONUMBER =2;
	private String _playerToken;
	private int _totalMovesCount = 9;
	private static final String QUITPATTERN = "q";
	private int _xCoordinate;
	private int _yCoordinate;
	private boolean _gameEnd = false;

	public GameController(GameModel gameModel, DisplayGame gameView) {
		this._gameModel = gameModel;
		this._gameView = gameView;
		this._playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	}

	public void startGamePlay(){
		Scanner scanner = new Scanner( System.in );
		PlayerInput playerInput = new PlayerInput();

		_gameModel.setInitialBoard();
		_gameView.displayStartBoard();

		//Play game while the end conditions aren't met
		while(!_gameEnd){
			String input = playerInput.obtainPlayerInput(scanner, _player, _playerToken);
			if(input.equals(QUITPATTERN)){
				_gameView.displayGameQuit();
				scanner.close();
				break;
			}

			// Obtain a coordinate set from the input received from the user
			List<String> coordinateList = Arrays.asList(input.split(","));
			_xCoordinate = Integer.parseInt(coordinateList.get(0))-1;
			_yCoordinate = Integer.parseInt(coordinateList.get(1))-1;

			if(validMove()){
				carryOutMove();
				checkForGameEnd();
				switchPlayer();
			}
		}
	}



	/**
	 * Check whether a piece has already been placed at the coordinate
	 * @return boolean of whether the move is valid or not
	 */
	private boolean validMove(){
		boolean isValidMove = _gameModel.checkValidMove(_xCoordinate, _yCoordinate);
		if (!isValidMove){
			_gameView.displayPieceAlreadyInPlace();
		}
		return isValidMove;
	}


	private void carryOutMove(){
		_gameModel.updateBoard(_player,_xCoordinate, _yCoordinate);
		_totalMovesCount--;
	}

	/**
	 * Switch the current player and the current board token
	 */
	private void switchPlayer(){
		if(_player==PLAYERONENUMBER){
			_player = PLAYERTWONUMBER;
			_playerToken = BoardToken.PLAYERTWOTOKEN.getBoardToken();
		} else if (_player == PLAYERTWONUMBER){
			_player = PLAYERONENUMBER;
			_playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
		}
	}

	/**
	 * Check whether the conditions for game end have been met: win or draw.
	 * If game has not ended, display the move that was carried out
	 */
	private void checkForGameEnd(){
		Boolean gameHasEnded = _gameModel.boardHasWin(_player, _xCoordinate, _yCoordinate);
		if(gameHasEnded){
			_gameView.displayWin();
			_gameEnd = true;
		} else if (_totalMovesCount==0){
			_gameView.displayDraw();
			_gameEnd = true;
		} else {
			_gameView.displayMove();
		}
	}
}
