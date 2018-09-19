package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.GameModel;
import view.DisplayGame;
import model.BoardToken;

public class GameController {
	private GameModel _gameModel;
	private DisplayGame _gameView;
	private int _playerNumber;
	private String _playerToken;
	private int _totalMovesCount = 9;
	private String _inputPattern = "[1-3],[1-3]";
	private String _quitPattern = "q";
	private int _xCoordinate;
	private int _yCoordinate;
	private boolean _gameEnd = false;

	public GameController(GameModel gameModel, DisplayGame gameView) {
		this._gameModel = gameModel;
		this._gameView = gameView;
		this._playerNumber = 1;
		this._playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	}

	/**
	 * Game play
	 */
	public void startGamePlay(){
		// Game start
		_gameModel.setInitialBoard();
		_gameView.displayStartBoard();

		//Play game while the end conditions aren't met
		while(!_gameEnd){

			String playerInput = obtainPlayerInput();
			if(playerInput.equals("q")){
				_gameView.displayGameQuit();
				break;
			}

			// Obtain a coordinate set from the input received from the user
			List<String> coordinateList = Arrays.asList(playerInput.split(","));
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
	 * Obtain a valid input from the player
	 * @return coordinate input from player
	 */
	private String obtainPlayerInput(){

		boolean validInput = false;
		String inputString = null;
		// Continue asking user for input if incorrect input has been provided
		while (!validInput) { 
			try {
				Scanner scanner = new Scanner( System.in );
				System.out.print( "Player "+ _playerNumber +" enter a coord x,y to place your " + _playerToken + " or enter 'q' to give up: ");

				inputString = scanner.next();
				// Check that the input is valid
				if(Pattern.matches(_inputPattern, inputString) || Pattern.matches(_quitPattern, inputString)){
					validInput=true;
				} else {
					// throw exception if input is invalid
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\n" + "Please enter a valid coordinate with numbers between 1-3 and with a format of 'x,y' or quit the game with 'q'" + "\n");
			}
		}
		return inputString;
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

	/**
	 * Carry out the move by placing the piece at the coordinate in the board
	 */
	private void carryOutMove(){
		_gameModel.updateBoard(_playerNumber,_xCoordinate, _yCoordinate);
		_totalMovesCount--;
	}

	/**
	 * Switch the current player and the current board token
	 */
	private void switchPlayer(){
		if(_playerNumber==1){
			_playerNumber =2;
			_playerToken = BoardToken.PLAYERTWOTOKEN.getBoardToken();
		} else if (_playerNumber ==2){
			_playerNumber =1;
			_playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
		}
	}

	/**
	 * Check whether the conditions for game end have been met: win or draw.
	 * If game has not ended, display the move that was carried out
	 */
	private void checkForGameEnd(){
		Boolean gameHasEnded = _gameModel.boardHasWin(_playerNumber, _xCoordinate, _yCoordinate);
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
