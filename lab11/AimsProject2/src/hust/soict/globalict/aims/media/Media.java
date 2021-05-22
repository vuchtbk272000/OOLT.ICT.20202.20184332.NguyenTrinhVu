package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Media implements  Comparable{
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
//-----------------------------------COMPARATOR-------------------------

	
		
	public static Comparator<Media> byTitle = new Comparator<Media>() {
		public int compare(Media m1, Media m2) {
			String t1 = m1.getTitle();
			String t2 = m2.getTitle();
			float c1 = m1.getCost();
			float c2 = m2.getCost();
			int l1 = m1.getLength();
			int l2 = m2.getLength();
			int c= t1.compareToIgnoreCase(t2);
			if (c==0)
				c= t1.compareTo(t2);
			if(c==0)
				if(c2-c1>0) c=1;
				else if(c2-c1<0) c=-1;
				else c=0;
			if (c==0)
				c= (l2-l1);
				
			
			return c;
		}
	};
	public static Comparator<Media> byCost = new Comparator<Media>() {
		public int compare(Media m1, Media m2) {
			float c1 = m1.getCost();
			float c2 = m2.getCost();
			String t1 = m1.getTitle();
			String t2 = m2.getTitle();
			int l1 = m1.getLength();
			int l2 = m2.getLength();
			int c=0;
			if(c2-c1>0) c=1;
			else if(c2-c1<0) c=-1;
			else c=0;
			if (c==0) {
				c= t1.compareToIgnoreCase(t2);
				if (c==0)
					c= t1.compareTo(t2);
			}
			if (c==0)
				c= (l2-l1);
				
			
			return c;
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
			if (c==0) {
				if(c2-c1>0) c=1;
				else if(c2-c1<0) c=-1;
				else c=0;
			}
				
			if (c==0)
				c= (l2-l1);
				
			
			return c;
		}
	};
	//----------------------------------------COMPARABLE--------------------------

	public int compareTo(Object object) {
		if (object instanceof Media) {
			Media media = (Media)object;
			int c=0;
			c = this.title.compareToIgnoreCase(media.title);
			if (c==0) {
				c = this.title.compareTo(media.title);
				if (c==0){
					c=this.category.compareToIgnoreCase(media.category);
					if (c==0)
						c=this.category.compareTo(media.category);
				}
			}		
			return c;
		}
		else throw new ClassCastException("The object is not media.\n");
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean equals(Object o){
		if (this != null) {			
			
			if (o instanceof Media) {
				Media media = (Media)o;
				if (this.title==media.title && this.cost == media.cost)
					return true;
				else return false;
			}
			else 
				throw new ClassCastException("Class Cast Exception");	
				
		}
		else return false;
			
//			throw new NullPointerException("NULL");
			
		
	}
	
	
}
