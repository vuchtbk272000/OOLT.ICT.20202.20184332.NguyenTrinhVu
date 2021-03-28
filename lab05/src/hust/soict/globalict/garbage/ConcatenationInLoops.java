package hust.soict.globalict.garbage;

public class ConcatenationInLoops {
	
	public static String concatWithString(int loop){
		String t = "hello";
		for (int i=0;i<loop;i++) {
			t = t+"world";
		}
		return t;
	}
	public static String concatWithBuffer(int loop) {
		StringBuffer t = new StringBuffer("hello");
		for (int i=0; i<loop;i++)
			t.append("world");
		return t.toString();
		
	}
	public static String concatWithBuilder(int loop){
		StringBuilder t = new StringBuilder("hello");
		for (int i=0; i<loop;i++)
			t.append("world");
		return t.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start;
		start = System.currentTimeMillis();
		concatWithString(10000);
		System.out.println("String time:"+ (System.currentTimeMillis()-start)+"ms");
		start = System.currentTimeMillis();
		concatWithBuffer(10000);
		System.out.println("Buffer time:"+ (System.currentTimeMillis()-start)+"ms");
		start = System.currentTimeMillis();
		concatWithBuilder(10000);
		System.out.println("Builder time:"+ (System.currentTimeMillis()-start)+"ms");
		
	}

}
