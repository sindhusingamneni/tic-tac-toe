package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.GameModel;

public class TestDraw {
	private GameModel _gameModel = new GameModel();
	private int _playerOne =1;
	private int _playerTwo =2;

	@Before
	public void setUp(){
		_gameModel.setInitialBoard();
	}

	@Test
	public void test_Draw() {
		_gameModel.updateBoard(_playerOne, 0,0);
		_gameModel.updateBoard(_playerTwo, 0,1);
		_gameModel.updateBoard(_playerOne, 0,2);
		_gameModel.updateBoard(_playerTwo, 1,0);
		_gameModel.updateBoard(_playerOne, 1,2);
		_gameModel.updateBoard(_playerTwo, 1,1);
		_gameModel.updateBoard(_playerOne, 2,0);
		_gameModel.updateBoard(_playerTwo, 2,2);
		_gameModel.updateBoard(_playerOne, 2,1);
		assertEquals(_gameModel.boardHasWin(_playerOne,2,1), false);
	}


}
