package hust.soict.globalict.aims.media;

import java.time.LocalDate;

import hust.soict.globalict.aims.disc.DVD;

public class Media {
	protected static Media total[]= new Media[1000];
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbDVD=0;
	protected int id=nbDVD;
	protected LocalDate dateAdded;
	

	protected String getTitle() {
		return title;
	}


	protected void setTitle(String title) {
		this.title = title;
	}


	protected String getCategory() {
		return category;
	}


	protected void setCategory(String category) {
		this.category = category;
	}


	protected float getCost() {
		return cost;
	}


	protected void setCost(float cost) {
		this.cost = cost;
	}


	protected int getId() {
		return id;
	}


	protected LocalDate getDateAdded() {
		return dateAdded;
	}
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded=LocalDate.now();
		total[nbDVD]=this;	
		nbDVD++;
		
	}
	

	public Media() {
		// TODO Auto-generated constructor stub
	}

	
}
