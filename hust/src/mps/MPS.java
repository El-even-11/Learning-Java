package mps;

import java.util.ArrayList;
import java.util.Scanner;

public class MPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		m = (int) (m * 1.5);

		ArrayList<Participant> participants = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int No = in.nextInt();
			int score = in.nextInt();
			participants.add(new Participant(No, score));
		}

		sort(participants);

		int line = participants.get(m - 1).score;
		int cnt = 0;

		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).score >= line) {
				cnt++;
			} else {
				break;
			}
		}

		System.out.println(line + " " + cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(participants.get(i).No + " " + participants.get(i).score);
		}
		in.close();
	}

	public static void sort(ArrayList<Participant> participants) {

		for (int lh = 0; lh < participants.size(); lh++) {
			int max = lh;
			for (int rh = lh + 1; rh < participants.size(); rh++) {
				if (participants.get(rh).rank > participants.get(max).rank) {
					max = rh;
				}
			}
			Participant temp = participants.get(lh);
			participants.set(lh, participants.get(max));
			participants.set(max, temp);
		}

	}

}

class Participant {
	public int No;
	public int score;
	public int rank;

	public Participant(int no, int score) {
		No = no;
		this.score = score;
		rank = score * 10000 + 10000 - no;
	}

}