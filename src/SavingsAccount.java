
public class SavingsAccount extends Object {

	//fields or instance variables or non-static variables
	int accountNo;
	private float balance;
	String status;
	private int pin;
	
	final static float interestRate =	2.25f;
	
	
	
	//default constructor ctrl+space to get it
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}
	
	//right click in class -> source -> generate constructor using fields to get parameters
						 //parameters
	public SavingsAccount(int accountNo, float balance, String status, int pin) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.status = status;
		this.pin = pin;
	}
		
	public float getBalance() {
		return balance;
	}
	
	void printDetails() {
		System.out.println("AccountNo : "+accountNo+"\nBalance : "+balance+"\nStatus : "+status);
	}
	
	public boolean isPinValid(int pin) {
		if(this.pin == pin) {
			return true;			
		}
		return false;
		
	}
	
	public static float getInterestrate() {
		return interestRate;
	}
	
	// instance methods or non-static methods
	// withdraw(int)
	public void withdraw(int withdrawalAmount) {

		//business logic
		if(this.status == "active"){
			
			if(withdrawalAmount <= this.balance) {
				
				this.balance = this.balance - withdrawalAmount;
			
			}else{
				System.out.println("You have insufficient funds");
			}
					
		}else{
			System.err.println("Account is inactive");
		}
	}
	
	//withdraw(int,int)
	public void withdraw(int withdrawalAmount,int pin) {
		
		if (isPinValid(pin)) {
			
			if(withdrawalAmount <= 40000) {
				
				withdraw(withdrawalAmount);
				
			}else {
				System.err.println("Withdrawal limit exceeded");
			}
			
		}else {			
			System.err.println("invalid Pin");
		}
		
		
	}
	
	
	
	public void deposit(int depositAmount) {
		
		if(depositAmount > 0) {
		
			balance = balance + depositAmount;
		
		}else {
		
			System.err.println("Invalid deposit amount");
			
		}
		
	}
	
}
