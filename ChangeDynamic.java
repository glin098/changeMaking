//package changeMaking;

public class ChangeDynamic {
	int change;
	int [] money;
	int [][] T;
	boolean [][] S;
	
	public ChangeDynamic(int [] money, int change) {
		this.change = change;		
		this.money = money.clone();
		this.T = new int[this.money.length][this.change + 1];
		this.S = new boolean[this.money.length][this.change + 1];
		
	    // column 0 of table T takes the value 0

	    for (int i=0; i < this.money.length; i++) {
	    	// case (a)
            this.T[i][0] = 0;
		}

	    // row 0 of table T takes the value of the change, represented by column j
	    // row 0 of table S takes the value true
	        
	    for (int j=1; j <= this.change; j++) {
			// case (b)
            this.T[0][j] = 0;
            this.S[0][j] = true;
			
	    }

	    //  T[i, j] = T[i - 1, j] if money[i] > j
	    //  T[i, j] = min(T[i - 1, j], 1 + T[i, j - money[i])

	    for (int i=1; i < this.money.length; i++) {
	    	for (int j = 1; j <= this.change; j++) {
	    		if (j < this.money[i]) {
	                	
	    			// case (c)
                    this.T[i][j] = this.T[i-1][j];
                    this.S[i][j] = false;
	                    
	            } else {

					// case (d)
                    this.T[i][j] = min(this.T[i-1][j], 1+this.T[i][j-money[i]]);
                    this.S[i][j] = (this.T[i][j] == this.T[i-1][j]) ? false :true;
	                    
	            }
	        }
	    }
	}
	
    public int [] getChange(int change) {
        int[] coins = new int[this.money.length];

        int coin = this.money.length - 1;
        
        while (change > 0) {
            if (!this.S[coin][change])
                coin--;
            else {
            	coins[coin]++;

                change = change - this.money[coin];
            }
        }
		
        return coins;
    }

	private static int min(int a, int b) {
        return (a > b) ? b : a;
    }
	
    public String toString(String title) {    	
    	String s = title + "\n\nTable T \n";
    	
        for (int i=0; i < this.T.length; i++) {
            s = s + "\n[" + ((i < 10) ? " " + i : "" + i) + "]";

            for (int j = 0; j < this.T[0].length; j++)
                if (this.T[i][j] == 0)
                    s = s + "   0 ";
                else
                    if (this.T[i][j] < 10)
                    s = s + "   " + T[i][j] + " ";
                else
                	if (this.T[i][j] < 100)
                		s = s + "  " + T[i][j] + " ";
                	else
                		s = s + " " + T[i][j] + " ";
        }

        s = s + "\n\nTable S \n";
    	
        for (int i=0; i < this.S.length; i++) {
            s = s + "\n[" + ((i < 10) ? " " + i : "" + i) + "]";
            
            for (int j = 0; j < this.S[0].length; j++)
            	s = s + ((this.S[i][j]) ? " 1 " : " 0 ");
        }

        return s + "\n";
    }
}
