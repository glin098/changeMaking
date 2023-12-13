package changeMaking;

public class TestProgramDynamic {

    /*
     * The change-making problem solved using dynamic programming: coins are sorted from lower to higher values 	
     */

	public static void printChange(String s, int [] coins, int [] money) {
		System.out.println(s + "\n");
		
		for (int i=0; i < coins.length; i++)
			System.out.println(" " + coins[i] + " coins with value " + money[i]);	
		
		System.out.println("\n");
	}

	public static void printChange(String s, int [] coins, double [] money) {
		System.out.println(s + "\n");
		
		for (int i=0; i < coins.length; i++)
			System.out.println(" " + coins[i] + " coins with value " + money[i]);
		
		System.out.println("\n");
	}

	public static void main(String[] args) {
		ChangeDynamic change;
		int amount;
		        
        System.out.println("Change-making problem using dynamic programming\n");
        
	    // Coins { 1, 2, 4 }, amount 8
		
		amount = 8;
		
		int [] money1 = { 1, 2, 4 };
		
		change = new ChangeDynamic(money1, amount);
		
		System.out.println(change.toString("Change Making tables for {1, 2, 4} and change 8"));

		printChange("Coins { 1, 2, 4 }, change 8", change.getChange(amount), money1);
						        
	    // Coins { 1, 4, 6 }, amount 12
		
		amount = 12;
		
		int [] money2 = { 1, 4, 6 };
		
		change = new ChangeDynamic(money2, amount);

		System.out.println(change.toString("Change Making tables for {1, 4, 6} and change 12"));

		printChange("Coins { 1, 4, 6 }, change 12", change.getChange(amount), money2);		
		
	    // Coins { 1, 4, 6 }, amount 9
		
		amount = 9;
		
		printChange("Coins { 1, 4, 6 }, change 9", change.getChange(amount), money2);		
		
	    // Coins { 1, 6, 10 }, amount 12
		
		amount = 12;
		
		int [] money3 = { 1, 6, 10 };
		
		change = new ChangeDynamic(money3, amount);
							
		System.out.println(change.toString("Change Making tables for {1, 6, 10} and change 12"));
		
		printChange("Coins { 1, 6, 10 }, change 12", change.getChange(amount), money3);		

		// Coins { 0.05, 0.1, 0.2, 0.5, 1.0, 2.0 }, amount 3.45
		
	    amount = 345;

	    int [] money4 = { 5, 10, 20, 50, 100, 200 };

		change = new ChangeDynamic(money4, amount);
		
		printChange("Coins { 0.05, 0.1, 0.2, 0.5, 1.0, 2.0 }, change 3.45", change.getChange(amount), new double [] {0.05, 0.1, 0.2, 0.5, 1.0, 2.0});
	}
}
