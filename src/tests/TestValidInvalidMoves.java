package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.GameModel;

public class TestValidInvalidMoves {

	private GameModel _gameModel = new GameModel();
	private int _playerOne =1;
	private int _playerTwo =2;

	@Before
	public void setUp(){
		_gameModel.setInitialBoard();
	}

	/**
	 * Test for token already in place for player one
	 */
	@Test
	public void test_Invalid_Move_Player_One() {
		_gameModel.updateBoard(_playerOne, 1,2);
		assertEquals(_gameModel.checkValidMove(1,2), false);
	}

	@Test
	public void test_Valid_Move_Player_One() {
		_gameModel.updateBoard(_playerOne, 1,2);
		assertEquals(_gameModel.checkValidMove(0,2), true);
	}

	/**
	 * Test for token already in place for player two
	 */
	@Test
	public void test_Invalid_Move_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 0,2);
		assertEquals(_gameModel.checkValidMove(0,2), false);
	}

	@Test
	public void test_Valid_Move_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 0,2);
		assertEquals(_gameModel.checkValidMove(0,1), true);
	}
}
