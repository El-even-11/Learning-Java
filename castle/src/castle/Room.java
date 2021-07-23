package castle;

import java.util.HashMap;

public class Room {
	private String description;
	private HashMap<String, Room> exits = new HashMap<>();

	public Room(String description) {
		this.description = description;
	}

	public void setExit(String dir, Room room) {
		exits.put(dir, room);
	}

	public Room getExit(String dir) {
		return exits.get(dir);
	}

	public void showExits() {
		for (String s : exits.keySet()) {
			System.out.print(s + " ");
		}
	}

	@Override
	public String toString() {
		return description;
	}
}
