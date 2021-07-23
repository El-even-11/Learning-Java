package database;

import java.util.ArrayList;

public class Database {

	private ArrayList<Item> listItem = new ArrayList<>();

	public void add(Item i) {
		listItem.add(i);
	}

	public void list() {
		for (Item i : listItem) {
			i.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("Halo", "shawabi", 1, 100, "good"));
		db.list();
	}

}
