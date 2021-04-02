package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	
	private ArrayList<String> authors = new ArrayList<String>();

	public Book(int id, String title, String category) {
		super(id, title, category, cost);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	
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
	
	
	
	
	
}
