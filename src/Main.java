
import controller.GameController;

import model.GameModel;
import view.DisplayGame;

public class Main {

	public static void main(String[] args) {
		GameModel model = new GameModel();
		DisplayGame view = new DisplayGame(model);
		GameController controller = new GameController(model, view);
		controller.startGamePlay();
	}
}
