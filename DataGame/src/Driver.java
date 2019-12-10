import java.io.*;
import java.util.*;

public class Driver {
	public static int numPlayers = 4;
	public static int numSpaces = 20;
	public final static int DICE_SIDES = 6;
	public final int NUM_SUITS = 4;
	static final int SCORE_GOAL = 3;
	static int turnNum = 1;
	static int[] numSuits = new int[4];
	static int[] numRoll = new int[6];

	static Player[] players = new Player[numPlayers];

	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Dev\\ICS4U\\DataGame\\src\\test1.txt"));
		for (int i = 0; i < 20; i++) {
			doIT(out);
		}
		out.close();
	}

	public static void doIT(BufferedWriter out) throws IOException {

		
	
		

		for (int j = 0; j < 6; j++) {
			numRoll[j] = 0;
		}
		for (int l = 0; l < 4; l++) {
			numSuits[l] = 0;
		}
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new Player();
		}

		while (!over()) {
			doTurn();
			checkBoard();
			turnNum++;

			String s1 = players[0].getArr()[0] + "\t" + players[0].getArr()[1] + "\t" + players[1].getArr()[2] + "\n";
			out.write(s1);
		}
		
	}

	private static void checkBoard() {
		for (int i = 0; i < numPlayers; i++) {
			if (players[i].getCurSpace() >= numSpaces) {
				players[i].setScore(players[i].getScore() + 1);
				players[i].setCurSpace(players[i].getCurSpace() - numSpaces);

			}
		}
	}

	private static void doTurn() {

		String rolls = "";

		for (int i = 0; i < numPlayers; i++) {
			String[] arr1 = new String[3];
			String suit = getSuit();

			arr1[0] = suit;
			double multiplier = getMultiplier(suit);
			int dice = roll();
			int roll = (int) Math.round(dice * multiplier);
			arr1[1] = "" + dice;
			arr1[2] = "" + roll;
			players[i].setCurSpace(players[i].getCurSpace() + roll);
			players[i].setArr(arr1);
			// System.out.println(players[i].getArr()[0]);
		}
	}

	private static void f1() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println((int) Math.round(j * getMultiplier(i)));
			}
		}

	}

	private static double getMultiplier(String suit) {
		switch (suit) {
		case "H":
			return 0;
		case "C":
			return 0.5;
		case "S":
			return 1;
		default:
			return 1.5;

		}
	}

	private static double getMultiplier(int suit) {
		switch (suit) {
		case 0:
			return 0;
		case 1:
			return 0.5;
		case 2:
			return 1;
		default:
			return 1.5;

		}
	}

	private static int roll() {

		int n = (int) (Math.random() * DICE_SIDES) + 1;
		numRoll[n - 1]++;
		return n;
	}

	private static String getSuit() {
		int x = (int) (Math.random() * 4);
		if (x == 0) {
			numSuits[x]++;
			return "S";
		} else if (x == 1) {
			numSuits[x]++;
			return "D";
		} else if (x == 2) {
			numSuits[x]++;
			return "H";
		} else {
			numSuits[x]++;
			return "C";
		}
	}

	public static boolean over() {
		boolean flag = false;
		for (int i = 0; i < numPlayers; i++) {
			if (players[i].getScore() >= SCORE_GOAL) {
				flag = true;
			}
		}
		return flag;
	}

}
