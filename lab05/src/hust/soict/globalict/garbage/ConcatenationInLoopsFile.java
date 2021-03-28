package hust.soict.globalict.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

public class ConcatenationInLoopsFile {
	public static void main(String[] args) {
		String filename = "C:\\Users\\admin\\eclipse-workspace\\lab05\\OtherProject\\src\\hust\\soict\\globalict\\garbage\\test.txt";
		byte[] inputBytes = { 0 };
		long startTime,endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));		
			String content = new String(inputBytes);
		    
		    // print contents
		    System.out.println(content);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		startTime = System.currentTimeMillis();
		String output = "";
		for (byte b : inputBytes) {
			output +=(char)b;
		}
		System.out.println("String time:"+ (System.currentTimeMillis()-startTime)+"ms");
		
//		String filename= "test";
//		String string="";
//		StringBuilder stringbuilder= new StringBuilder();
//		StringBuffer stringbuffer=new StringBuffer();
//		//String stringin=sc.nextLine();
////		long startTime = System.nanoTime();
////			for(byte b : bytes) string +=(char)b;	
////		long endTime = System.nanoTime();
////		long duration = (endTime - startTime);
////		System.out.println("String takes : " + duration +"  nanoseconds");
//		try {
//            byte[] content = Files.readAllBytes(Paths.get("test"));
//            System.out.println(new String(content));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		long startTime = System.nanoTime();
//		for(byte b : content) string +=(char)b;	
//		
		
		
//		startTime = System.nanoTime();
//		for(byte b:inputByte) stringbuilder.append((char)b);	
//		endTime = System.nanoTime();
//		duration = (endTime - startTime);
//
//		System.out.println("StringBuilder takes : " + duration +"  nanoseconds");
//		startTime = System.nanoTime();
//		for(byte b:inputByte) stringbuffer.append((char)b);	
//		endTime = System.nanoTime();
//		duration = (endTime - startTime);
//
//		System.out.println("StringBuffer takes : " + duration +"  nanoseconds");
//		sc.close();
	}

}
 