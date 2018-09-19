package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import model.Model;
import view.View;

public class TestGame {
	
	private Model _model = new Model();
	private View _view = new View(_model);
	private Controller _controller = new Controller(_model, _view);
	private int _playerOne =1;
	private int _playerTwo =2;

	@Before
	public void setUp(){
		_model.setInitialBoard();
	}
	
	@Test
	public void test_Board_Input_For_Player_One() {
		_model.updateBoard(_playerOne, 1, 1);
		String [][]board = _model.getBoard();
		assertEquals(board[1][1], "X");
	}
	
	@Test
	public void test_Board_Input_For_Player_Two() {
		_model.updateBoard(_playerTwo, 2, 1);
		String [][]board = _model.getBoard();
		assertEquals(board[2][1], "O");
	}
	
	@Test
	public void test_Row_Win_For_Player_One() {
		_model.updateBoard(_playerOne, 0,0);
		_model.updateBoard(_playerOne, 0,1);
		_model.updateBoard(_playerOne, 0,2);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerOne, 0, 2), true);
	}
	
	@Test
	public void test_Column_Win_For_Player_One() {
		_model.updateBoard(_playerOne, 0,2);
		_model.updateBoard(_playerOne, 1,2);
		_model.updateBoard(_playerOne, 2,2);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerOne, 2, 2), true);
	}
	
	@Test
	public void test_Left_Diagonal_Win_For_Player_One() {
		_model.updateBoard(_playerOne, 0,0);
		_model.updateBoard(_playerOne, 1,1);
		_model.updateBoard(_playerOne, 2,2);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerOne, 2, 2), true);
	}
	
	@Test
	public void test_Right_Diagonal_Win_For_Player_One() {
		_model.updateBoard(_playerOne, 0,2);
		_model.updateBoard(_playerOne, 1,1);
		_model.updateBoard(_playerOne, 2,0);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerOne, 2, 0), true);
	}
	
	@Test
	public void test_Row_Win_For_Player_Two() {
		_model.updateBoard(_playerTwo, 1,0);
		_model.updateBoard(_playerTwo, 1,1);
		_model.updateBoard(_playerTwo, 1,2);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerTwo, 1, 2), true);
	}
	
	@Test
	public void test_Column_Win_For_Player_Two() {
		_model.updateBoard(_playerTwo, 2,0);
		_model.updateBoard(_playerTwo, 0,0);
		_model.updateBoard(_playerTwo, 1,0);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerTwo, 1, 0), true);
	}
	
	@Test
	public void test_Left_Diagonal_Win_For_Player_Two() {
		_model.updateBoard(_playerTwo, 0,0);
		_model.updateBoard(_playerTwo, 1,1);
		_model.updateBoard(_playerTwo, 2,2);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerTwo, 2, 2), true);
	}
	
	@Test
	public void test_Right_Diagonal_Win_For_Player_Two() {
		_model.updateBoard(_playerTwo, 0,2);
		_model.updateBoard(_playerTwo, 1,1);
		_model.updateBoard(_playerTwo, 2,0);
		String [][]board = _model.getBoard();
		assertEquals(_model.boardHasWin(_playerTwo, 2, 0), true);
	}
	
	@Test
	public void test_Invalid_Move_Player_One() {
		_model.updateBoard(_playerOne, 1,2);
		assertEquals(_model.checkValidMove(1,2), false);
	}
	
	@Test
	public void test_Valid_Move_Player_One() {
		_model.updateBoard(_playerOne, 1,2);
		assertEquals(_model.checkValidMove(0,2), true);
	}
	
	@Test
	public void test_Invalid_Move_Player_Two() {
		_model.updateBoard(_playerTwo, 0,2);
		assertEquals(_model.checkValidMove(0,2), false);
	}
	
	@Test
	public void test_Valid_Move_Player_Two() {
		_model.updateBoard(_playerTwo, 0,2);
		assertEquals(_model.checkValidMove(0,1), true);
	}
	
	@Test
	public void test_Draw() {
		_model.updateBoard(_playerOne, 0,0);
		_model.updateBoard(_playerTwo, 0,1);
		_model.updateBoard(_playerOne, 0,2);
		_model.updateBoard(_playerTwo, 1,0);
		_model.updateBoard(_playerOne, 1,2);
		_model.updateBoard(_playerTwo, 1,1);
		_model.updateBoard(_playerOne, 2,0);
		_model.updateBoard(_playerTwo, 2,2);
		_model.updateBoard(_playerOne, 2,1);
		assertEquals(_model.boardHasWin(_playerOne,2,1), false);
	}
	
	@Test
	public void test_Win() {
		_model.updateBoard(_playerOne, 0,1);
		_model.updateBoard(_playerTwo, 0,0);
		_model.updateBoard(_playerOne, 0,2);
		_model.updateBoard(_playerTwo, 1,0);
		_model.updateBoard(_playerOne, 1,2);
		_model.updateBoard(_playerTwo, 1,1);
		_model.updateBoard(_playerOne, 2,0);
		_model.updateBoard(_playerTwo, 2,2);
		assertEquals(_model.boardHasWin(_playerTwo,2,2), true);
	}
	
	@Test(expected = Exception.class)
	public void test_Invalid_Coordinate_Input() {
		
	    String input = "0,0";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    _controller.startGamePlay();
	}
	
	@Test(expected = Exception.class)
	public void test_Invalid_Input() {
		
	    String input = "Wrong Input";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    _controller.startGamePlay();
	}
	@Test
	public void test_Quit() {
		
	    String input = "q";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    _controller.startGamePlay();
	    return;
	}
	
}
