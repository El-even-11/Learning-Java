package castle;

public class HandlerHelp extends Handler {

	Game game;

	public void doCmd(String s) {
		System.out.print("��·������������������У�");
		for (String handlers : game.getHandlers()) {
			System.out.print(handlers + " ");
		}
		System.out.println("�磺\tgo east");
	}

	public HandlerHelp(Game game) {
		this.game = game;
	}
}
