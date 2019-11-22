
public class Driver {
	public static int numPlayers = 4;
	public static int numSpaces = 40;
	public final static int DICE_SIDES = 6;
	public final int NUM_SUITS = 4;
	static final int SCORE_GOAL = 3;
	static int turnNum = 0;
	static int[] numSuits = new int[4];
	static int[] numRoll = new int[6];

	static Player[] players = new Player[numPlayers];

	public static void main(String[] args) {
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new Player();
		}

		while (!over()) {
			doTurn();
			checkBoard();

			turnNum++;
		}
		
		System.out.println("Number of Spades: "+numRoll[0]);
		System.out.println("Number of Diamonds: "+numRoll[1]);
		System.out.println("Number of Hearts: "+numRoll[2]);
		System.out.println("Number of Clubs: "+numRoll[3]);
		System.out.println();
		
		for(int i =0; i<numRoll.length;i++) {
			System.out.println("Number of "+ (i+1)+"s rolled "+numRoll[i]);
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
		//System.out.println("_______________________________________________________");
		//System.out.println("Turn: " + turnNum);
		for (int i = 0; i < numPlayers; i++) {
			String suit = getSuit();
			double multiplier = getMultiplier(suit);
			int dice = roll();
			int roll = (int) Math.round(dice * multiplier);
			players[i].setCurSpace(players[i].getCurSpace() + roll);

			//System.out.println("\t Suit: " + suit + "\t roll: " + dice + "\t numSpaces: " + roll);
		}
	}

	private static double getMultiplier(String suit) {
		switch (suit) {
		case "H": // hearts
			return 0;
		case "C":
			return 0.5;
		case "S":
			return 1;
		default:
			return 1.5;

		}
	}

	private static int roll() {

		int n = (int) (Math.random() * DICE_SIDES) + 1;
		numRoll[n-1]++;
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
