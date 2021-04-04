package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	
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
	private int countTokens(String str) {
		
		ArrayList<String> count=new ArrayList<String>();
		String[] tokens= str.split(" ");
		for (int i=0;i<tokens.length;i++) {
			boolean check=false;
			for (String a:count) 
					if (a.compareToIgnoreCase(tokens[i])==0) check=true;
			if (check==false) count.add(tokens[i]);
		}
		return count.size();
	}
	
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	public void setContent(String str) {
		this.content=str;
		this.length=this.countTokens(this.content);
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
	
	public String getDetail() {
		String s;
		s="BOOK:"+ id+"-   " + title + " -  "+category+" -  ";
		for (String name: authors) {
			s=s+name+"/";
		}
		s=s+"--length:  "+ length +" -   "+cost+"$-  "+dateAdded;
		return s;
	}
	
	
	
	
}
