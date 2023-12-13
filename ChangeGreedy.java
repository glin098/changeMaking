//package changeMaking;

public class ChangeGreedy {
	private double [] money;
	private int [] coins;
	
	public ChangeGreedy(double [] money) {
		this.money = money.clone();
        this.coins = new int[this.money.length];       
	}
	
	public int [] getChange(double change) {
        for (int i=0; i < this.money.length; i++) {
            while (change >= this.money[i]) {
         	   change = change - this.money[i];
         	   this.coins[i]++;
            }               
         }

		return this.coins;
	}
}
