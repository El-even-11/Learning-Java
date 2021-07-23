package castle;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game {
	private Room currentRoom;
	private HashMap<String, Handler> handlers = new HashMap<>();

	public Game() {
		createRooms();
	}

	private void createRooms() {
		Room outside, lobby, pub, study, bedroom, basement;

		// 制造房间
		outside = new Room("城堡外");
		lobby = new Room("大堂");
		pub = new Room("小酒吧");
		study = new Room("书房");
		bedroom = new Room("卧室");
		basement = new Room("地下室");

		// 初始化房间的出口
		outside.setExit("east", lobby);
		outside.setExit("south", study);
		outside.setExit("west", pub);
		lobby.setExit("west", outside);
		pub.setExit("east", outside);
		pub.setExit("down", basement);
		study.setExit("north", outside);
		study.setExit("east", bedroom);
		bedroom.setExit("west", study);
		basement.setExit("up", pub);

		// 初始化命令
		handlers.put("help", new HandlerHelp(this));
		handlers.put("bye", new HandlerBye());
		handlers.put("go", new HandlerGo(this));

		currentRoom = outside; // 从城堡门外开始
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入 'help' 。");
		System.out.println();
		showPrompt();
	}

	// 以下为用户命令

	public void goRoom(String direction) {
		Room nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null) {
			System.out.println("那里没有门！");
		} else {
			currentRoom = nextRoom;
			showPrompt();
		}
	}

	public Set<String> getHandlers() {
		return handlers.keySet();
	}

	public void showPrompt() {
		System.out.println("现在你在" + currentRoom);
		System.out.print("出口有：");
		currentRoom.showExits();
		System.out.println();
	}

	public void play() {
		Scanner in = new Scanner(System.in);
		printWelcome();

		while (true) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			Handler handler = handlers.get(words[0]);

			if (handler == null) {
				System.out.println("命令错误！");
				continue;
			}
			if (handler.isBye()) {
				break;
			}

			handler.doCmd(words.length > 1 ? words[1] : "");
		}

		System.out.println("感谢您的光临。再见！");
		in.close();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}

}
