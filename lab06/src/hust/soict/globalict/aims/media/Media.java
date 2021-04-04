package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {
	protected static Media total[]= new Media[1000];
	protected String title;
	protected String category;
	protected float cost;
	protected int length;
	protected static int nbMedia=0;
	protected int id=nbMedia;
	protected LocalDate dateAdded;
	

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return this.length;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public Media(String title, String category, float cost) {
		this.id = nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded=LocalDate.now();
		total[nbMedia]=this;	
		nbMedia++;
		
	}
	

	public Media() {
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
		total[nbMedia]=this;
		nbMedia++;
	}
	public String getDetail() {
		String s = new String();
		if (this instanceof Book) {
			Book book = (Book)this;
			s= book.getDetail();
		}
		else if(this instanceof DVD) {
			DVD dvd = (DVD)this;
			s = dvd.getDetail();
		}
		return s;
	}
	
	
	
}
