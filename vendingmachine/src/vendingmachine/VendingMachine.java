package vendingmachine;

import java.util.Scanner;

public class VendingMachine {

	int price = 80;
	int balance;
	int total;
	Scanner in = new Scanner(System.in);

	void showPrompt() {
		System.out.println("Good morning!");
	}

	void insertMoney() {
		int amount;
		System.out.println("Please insert money!");
		amount = in.nextInt();
		System.out.println("You've insert " + amount);
		balance += amount;
	}

	void showBalance() {
		System.out.println("balance:" + balance);
	}

	void getFood() {
		if (balance >= price) {
			System.out.println("Hera you are.");
			balance -= price;
			total += price;
		}

	}

	void showTotal() {
		System.out.println("total:" + total);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vmOne = new VendingMachine();
		vmOne.showPrompt();
		vmOne.insertMoney();
		vmOne.showBalance();
		vmOne.getFood();
		vmOne.showBalance();
		vmOne.showTotal();

	}

}
