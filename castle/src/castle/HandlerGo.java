package castle;

public class HandlerGo extends Handler {
	private Game game;

	public void doCmd(String dir) {
		game.goRoom(dir);
	}

	public HandlerGo(Game game) {
		this.game = game;
	}
}
