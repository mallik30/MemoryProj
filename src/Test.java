public class Test {

	public static void main(String[] args) {
		
		int i = 100;
		
		SavingsAccount account = new SavingsAccount(101,5000,"active",1234);

		account = null;
		
		account.withdraw(2000);
		
//		System.gc();
		
		Runtime runtime = Runtime.getRuntime();
		
		runtime.gc();
		
		System.out.println("End of the main()");
	
	}

}