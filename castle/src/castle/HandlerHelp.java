package castle;

public class HandlerHelp extends Handler {

	Game game;

	public void doCmd(String s) {
		System.out.print("迷路了吗？你可以做的命令有：");
		for (String handlers : game.getHandlers()) {
			System.out.print(handlers + " ");
		}
		System.out.println("如：\tgo east");
	}

	public HandlerHelp(Game game) {
		this.game = game;
	}
}
