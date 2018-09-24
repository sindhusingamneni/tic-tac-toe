package tests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import controller.GameController;
import model.GameModel;
import view.DisplayGame;

public class TestException {
	private GameModel _gameModel = new GameModel();
	private DisplayGame _gameView = new DisplayGame(_gameModel);
	private GameController _gameController = new GameController(_gameModel, _gameView);

	@Before
	public void setUp(){
		_gameModel.setInitialBoard();
	}

	/**
	 * Test for exception being thrown when invalid coordinate is entered
	 */
	@Test(expected = Exception.class)
	public void test_Invalid_Coordinate_Input() {

		String input = "0,0";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		_gameController.startGamePlay();
	}

	/**
	 * Test for exception being thrown when invalid input is entered
	 */
	@Test(expected = Exception.class)
	public void test_Invalid_Input() {

		String input = "Wrong Input";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		_gameController.startGamePlay();
	}
}
