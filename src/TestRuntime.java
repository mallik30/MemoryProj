
public class TestRuntime {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("Total Memory : "+runtime.totalMemory());
		System.out.println("Free  Memory before creating objects: "+runtime.freeMemory());
		
		for (int i = 0; i < 40000;) {
			new SavingsAccount(++i, 5000, "active", 1234+i);
			
		}
		
		System.out.println("Free  Memory after creating objects: "+runtime.freeMemory());
	
		System.out.println("calling gc...");
		
		runtime.gc();
		
		System.out.println("Free memory after calling gc :"+runtime.freeMemory());
				
	}
	

}
