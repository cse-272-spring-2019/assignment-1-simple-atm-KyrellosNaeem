package asss_1;



class BankAccount {
 long cardnumber;
 double balance;
 private String[] history = new String[5];



public BankAccount(long cardnumber, double balance) {
	
	this.cardnumber = cardnumber;
	this.balance = balance;
	
}

public long getCardnumber() {
	return cardnumber;
}

public double getBalance() {
	return balance;
}

public String[] getHistory() {
	return history;
}

public void setHistory(String[] history) {
	this.history = history;
}

private int i=0,j=0; // i -> number of operations 
                 // j -> pointed at operation

public boolean Withdrawal (int amount) {
	if(amount > 0 && amount < balance) {
		j=i;
		this.balance = balance - amount ;
		String x = String.valueOf(amount);
		String y ="Withdrawal " + x; 
		SaveToHistoty(y);
	    return true ;
	}
	else {
		return false;
	}
}	

public String Deposit (int amount) {
		if(amount > 0) {
			j=i;
			this.balance = balance + amount ;
			String x = String.valueOf(amount);
			String y ="Deposit " + x;
			SaveToHistoty(y);
		    return null;
		}
		else {
			System.out.println("error");
			return null; //pop msg error
		}
}
public String BalanceInquiry () {
	j=i;
	SaveToHistoty("Balance Inquiry");
	return "Balance Inquiry";
}

public boolean Login (long r) {
	if(r == this.cardnumber)
		return true;
	else
		return false;
	
}

public String back() {
	if(j == 0) {
		return null;
	}else {
		j--;
		return history[j];
	}
}
public String next() {
if(j == i) {
	return null;
	}else {
		j++;
		return history[j];
	}	
}
private void SaveToHistoty(String y) {
	if(i==5) {
		for(int c=0;c<4;c++) {
			history[c]=history[c+1];
		}
		history[4]=y;
	}
	else 
	{
		history[i]= y ;
	    i++;
	    
    }
	System.out.println(history[0]+history[1]+history[2]+history[3]+history[4]);
}
}
