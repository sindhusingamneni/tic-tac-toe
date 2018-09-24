package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import controller.GameController;
import model.GameModel;
import view.DisplayGame;

public class TestInput {

	private GameModel _gameModel = new GameModel();
	private DisplayGame _gameView = new DisplayGame(_gameModel);
	private GameController _gameController = new GameController(_gameModel, _gameView);
	private int _playerOne =1;
	private int _playerTwo =2;

	@Before
	public void setUp(){
		_gameModel.setInitialBoard();
	}

	@Test
	public void test_Board_Input_For_Player_One() {
		_gameModel.updateBoard(_playerOne, 1, 1);
		String [][]board = _gameModel.getBoard();
		assertEquals(board[1][1], "X");
	}

	@Test
	public void test_Board_Input_For_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 2, 1);
		String [][]board = _gameModel.getBoard();
		assertEquals(board[2][1], "O");
	}

	@Test
	public void test_Quit() {
		String input = "q";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		_gameController.startGamePlay();
		return;
	}

}
