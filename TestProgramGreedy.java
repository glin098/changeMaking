//package changeMaking;

public class TestProgramGreedy {

    /*
     * The change-making problem solved using a greedy algorithm: coins are sorted from higher to lower values 
     */
		
	public static void printChange(String s, int [] coins, double [] money) {
		System.out.println("\n" + s + "\n");
		
		for (int i=0; i < coins.length; i++)
			System.out.println(" " + coins[i] + " coins with value " + money[i]);	
	}
	
	public static void main(String[] args) {	
        ChangeGreedy change;
        double amount;       
        
        System.out.println("Change-making problem using a greedy algorithm");
        
        // Coins { 2.0, 1.0, 0.50, 0.20, 0.10, 0.050 }, amount 3.45
        
        amount = 3.45;
        
        double [] money1 = { 2.0, 1.0, 0.50, 0.20, 0.10, 0.050 };
        
		change = new ChangeGreedy(money1);
						
		printChange("Coins { 2.0, 1.0, 0.50, 0.20, 0.10, 0.050 }, change 3.45", change.getChange(amount), money1);
				
		// Coins { 100.0, 80.0, 10 }, amount 160

        amount = 160;
        
        double[] money2 = { 100.0, 80.0, 10 };
        
        change = new ChangeGreedy(money2);
        
        printChange("Coins { 100.0, 80.0, 10 }, change 160", change.getChange(amount), money2);          
	}
}
