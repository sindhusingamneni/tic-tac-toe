package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.GameModel;
import view.DisplayGame;
import model.BoardToken;

public class GameController {
	private GameModel _model;
	private DisplayGame _view;
	private int _playerNumber;
	private String _playerToken;
	private int _movesCount = 9;
	private String _inputPattern = "[1-3],[1-3]";
	private String _quitPattern = "q";
	private int _xCoordinate;
	private int _yCoordinate;
	private boolean _gameEnd = false;

	public GameController(GameModel model, DisplayGame view) {
		this._model = model;
		this._view = view;
		this._playerNumber = 1;
		this._playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
	}

	public void startGamePlay(){

		_model.setInitialBoard();
		_view.displayStartBoard();

		while(!_gameEnd){

			String input = obtainPlayerInput();
			if(input.equals("q")){
				_view.displayGameQuit();
				break;
			}

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

	private String obtainPlayerInput(){

		boolean validInput = false;
		String inputString = null;
		while (!validInput) { 
			try {
				Scanner scanner = new Scanner( System.in );
				System.out.print( "Player "+ _playerNumber +" enter a coord x,y to place your " + _playerToken + " or enter 'q' to give up: ");

				inputString = scanner.next();
				if(Pattern.matches(_inputPattern, inputString) || Pattern.matches(_quitPattern, inputString)){
					validInput=true;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\n" + "Please enter a valid coordinate with numbers between 1-3 and with a format of 'x,y' or quit the game with 'q'" + "\n");
			}
		}
		return inputString;
	}

	private boolean validMove(){
		boolean isValidMove = _model.checkValidMove(_xCoordinate, _yCoordinate);
		if (!isValidMove){
			_view.displayPieceAlreadyInPlace();
		}
		return isValidMove;
	}

	private void carryOutMove(){
		_model.updateBoard(_playerNumber,_xCoordinate, _yCoordinate);
		_movesCount--;
	}

	private void switchPlayer(){
		if(_playerNumber==1){
			_playerNumber =2;
			_playerToken = BoardToken.PLAYERTWOTOKEN.getBoardToken();
		} else if (_playerNumber ==2){
			_playerNumber =1;
			_playerToken = BoardToken.PLAYERONETOKEN.getBoardToken();
		}
	}

	private void checkForGameEnd(){
		Boolean gameHasEnded = _model.boardHasWin(_playerNumber, _xCoordinate, _yCoordinate);
		if(gameHasEnded){
			_view.displayWin();
			_gameEnd = true;
		} else if (_movesCount==0){
			_view.displayDraw();
			_gameEnd = true;
		} else {
			_view.displayMove();
		}
	}
}
