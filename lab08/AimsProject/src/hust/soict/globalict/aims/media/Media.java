package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Media {
	protected static ArrayList<Media> medias = new ArrayList<Media>();
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
	public String getDetail() {
		String s = new String();
		s = s+ this.getId() +"- "+this.getTitle()+"- "+this.getCost()+"- "+this.getLength();
		return s;
	}
	
	
//------------------------------CONSTRUCTORS--------------------------
	public Media() {
		this.id = medias.size();
		this.dateAdded = LocalDate.now();
		medias.add(this);
	}
	public Media(String title, String category, float cost, int length) {
		this.id = medias.size();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.length = length;
		this.dateAdded=LocalDate.now();
		medias.add(this);
		
	}
	public Media(String title, String category, float cost) {
		super();
		this.id = medias.size();
		this.title = title;
		this.category = category;
		this.cost = cost;
		medias.add(this);
	}
//--------------------------------------------------

	
		
	public static Comparator<Media> byTitle = new Comparator<Media>() {
		public int compare(Media m1, Media m2) {
			String t1 = m1.getTitle();
			String t2 = m2.getTitle();
			int c= t1.compareToIgnoreCase(t2);
			if (c==0)
				c= t1.compareTo(t2);
			
			return c;
		}
	};
	public static Comparator<Media> byCost = new Comparator<Media>() {
		public int compare(Media m1, Media m2) {
			float t1 = m1.getCost();
			float t2 = m2.getCost();
			return (int)(t2-t1);
		}
	};
	public static Comparator<Media> byFields = new Comparator<Media>() {
		public int compare(Media m1, Media m2) {
			float c1 = m1.getCost();
			float c2 = m2.getCost();
			String t1 = m1.getTitle();
			String t2 = m2.getTitle();
			int l1 = m1.getLength();
			int l2 = m2.getLength();
			
			int c= t1.compareToIgnoreCase(t2);
			if (c==0)
				c= t1.compareTo(t2);
			if (c==0)
				c= (int)(c2-c1);
			if (c==0)
				c= (l2-l1);
				
			
			return c;
		}
	};
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media media = (Media)o;
			if (this.id==media.id)
					return true;
			}
		
		return false;
	}
	
}
