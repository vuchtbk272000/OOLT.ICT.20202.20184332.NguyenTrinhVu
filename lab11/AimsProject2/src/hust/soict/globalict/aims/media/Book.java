package hust.soict.globalict.aims.media;


import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Book extends Media {
	private ArrayList<String> contentTokens= new ArrayList<String>();
	private ArrayList<String> authors = new ArrayList<String>();
	private int length;
	private String content;
	
	public Book(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded.now();
	}
	public Book() {
		
	}
	private static TreeMap<String, Integer> allTokens;
	public void processContent() {
		allTokens = new TreeMap<String, Integer>();
		String[] tokens = content.split(" ");
		for (int i=0;i<tokens.length;i++) {
			if (allTokens.containsKey(tokens[i])==false) {
				allTokens.put(tokens[i], 0);
				contentTokens.add(tokens[i]);
			}
			if (allTokens.containsKey(tokens[i])) {
				int c = allTokens.get(tokens[i]);
				c++;
				allTokens.put(tokens[i],c);
			}
		}
		Collections.sort(contentTokens);
		length = allTokens.size();
	}
//	private int countTokens(String str) {
//		
//		ArrayList<String> count=new ArrayList<String>();
//		String[] tokens= str.split(" ");
//		for (int i=0;i<tokens.length;i++) {
//			boolean check=false;
//			for (String a:count) 
//					if (a.compareToIgnoreCase(tokens[i])==0) check=true;
//			if (check==false) count.add(tokens[i]);
//		}
//		return count.size();
//	}
	
	public ArrayList<String> getContentTokens() {
		return contentTokens;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	public void setContent(String str) {
		this.content=str;		
		processContent();
	}
	
//---------------------	
	public boolean addAuthor(String authorName) {
		for (String i : authors) {
			if (i.equals(authorName)){
					return false;
					
				}
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for (String i :authors) {
			if (i.equals(authorName)) {
				authors.remove(authorName);
				return true;
			}
		}
		return false;
		
	}
	@Override
	public String getDetail() {
		String s;
		s="BOOK:"+ id+"-   " + title + " -  "+category+" -  ";
		for (String name: authors) {
			s=s+name+"/";
		}
		s=s+"--length:  "+ length +" -   "+cost+"$";
		s= s+ "\n"+allTokens.toString();
		
		return s;
	}
	
	
	
	
}
