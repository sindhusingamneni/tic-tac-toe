package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.GameModel;

public class TestWin {
	private GameModel _gameModel = new GameModel();
	private int _playerOne =1;
	private int _playerTwo =2;

	@Before
	public void setUp(){
		_gameModel.setInitialBoard();
	}

	@Test
	public void test_Row_Win_For_Player_One() {
		_gameModel.updateBoard(_playerOne, 0,0);
		_gameModel.updateBoard(_playerOne, 0,1);
		_gameModel.updateBoard(_playerOne, 0,2);
		assertEquals(_gameModel.boardHasWin(_playerOne, 0, 2), true);
	}

	@Test
	public void test_Column_Win_For_Player_One() {
		_gameModel.updateBoard(_playerOne, 0,2);
		_gameModel.updateBoard(_playerOne, 1,2);
		_gameModel.updateBoard(_playerOne, 2,2);
		assertEquals(_gameModel.boardHasWin(_playerOne, 2, 2), true);
	}

	@Test
	public void test_Left_Diagonal_Win_For_Player_One() {
		_gameModel.updateBoard(_playerOne, 0,0);
		_gameModel.updateBoard(_playerOne, 1,1);
		_gameModel.updateBoard(_playerOne, 2,2);
		assertEquals(_gameModel.boardHasWin(_playerOne, 2, 2), true);
	}

	@Test
	public void test_Right_Diagonal_Win_For_Player_One() {
		_gameModel.updateBoard(_playerOne, 0,2);
		_gameModel.updateBoard(_playerOne, 1,1);
		_gameModel.updateBoard(_playerOne, 2,0);
		assertEquals(_gameModel.boardHasWin(_playerOne, 2, 0), true);
	}

	@Test
	public void test_Row_Win_For_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 1,0);
		_gameModel.updateBoard(_playerTwo, 1,1);
		_gameModel.updateBoard(_playerTwo, 1,2);
		assertEquals(_gameModel.boardHasWin(_playerTwo, 1, 2), true);
	}

	@Test
	public void test_Column_Win_For_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 2,0);
		_gameModel.updateBoard(_playerTwo, 0,0);
		_gameModel.updateBoard(_playerTwo, 1,0);
		assertEquals(_gameModel.boardHasWin(_playerTwo, 1, 0), true);
	}

	@Test
	public void test_Left_Diagonal_Win_For_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 0,0);
		_gameModel.updateBoard(_playerTwo, 1,1);
		_gameModel.updateBoard(_playerTwo, 2,2);
		assertEquals(_gameModel.boardHasWin(_playerTwo, 2, 2), true);
	}

	@Test
	public void test_Right_Diagonal_Win_For_Player_Two() {
		_gameModel.updateBoard(_playerTwo, 0,2);
		_gameModel.updateBoard(_playerTwo, 1,1);
		_gameModel.updateBoard(_playerTwo, 2,0);
		assertEquals(_gameModel.boardHasWin(_playerTwo, 2, 0), true);
	}

	@Test
	public void test_Win() {
		_gameModel.updateBoard(_playerOne, 0,1);
		_gameModel.updateBoard(_playerTwo, 0,0);
		_gameModel.updateBoard(_playerOne, 0,2);
		_gameModel.updateBoard(_playerTwo, 1,0);
		_gameModel.updateBoard(_playerOne, 1,2);
		_gameModel.updateBoard(_playerTwo, 1,1);
		_gameModel.updateBoard(_playerOne, 2,0);
		_gameModel.updateBoard(_playerTwo, 2,2);
		assertEquals(_gameModel.boardHasWin(_playerTwo,2,2), true);
	}
}
