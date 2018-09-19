
import controller.GameController;

import model.GameModel;
import view.DisplayGame;

public class Main {

	public static void main(String[] args) {
		GameModel gameModel = new GameModel();
		DisplayGame gameView = new DisplayGame(gameModel);
		GameController gameController = new GameController(gameModel, gameView);
		gameController.startGamePlay();
	}
}
