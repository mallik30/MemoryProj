import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFinalize {

	public static void main(String[] args) throws InterruptedException {
		
		FileProcessor fileProcessor = new FileProcessor();
		
		fileProcessor.processFile("c:/sample.txt");
		
		System.out.println("Before : "+fileProcessor);
		System.out.println();
		
		fileProcessor = null;
	
		System.gc();
		
		Thread.sleep(400);
		
		System.out.println("After : "+FileProcessor.processor);
		
		FileProcessor.processor = null;
		
		System.gc();
		
		System.out.println();
		
		Thread.sleep(400);
		
		System.out.println("After : "+FileProcessor.processor);
	}

}


class FileProcessor{
	
	FileReader fileReader = null;
	
	static FileProcessor processor;
	
	public void processFile(String fileName) {
		
		try {
			
			fileReader = new FileReader(fileName);

			//reading the data from the file using fileReader
			//reading the data from the file using fileReader
			
			fileReader.close();
			
		}	catch (IOException e) {
				
			e.printStackTrace();
				
		}	
	}
	
	@Override
	protected void finalize() throws Throwable {
	
		System.out.println("***FileProcessor : finalize()***");
		
		processor = this;
		
		if(fileReader != null) {
			fileReader.close();
		}
	}
}