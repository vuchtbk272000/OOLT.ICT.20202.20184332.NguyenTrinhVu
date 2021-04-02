package hust.soict.globalict.aims.disc;
import java.time.LocalDate;

public class DVD {
	private static DVD total[]= new DVD[1000];
	
	private String title;
	public DVD getDVDById(int i) {
		return total[i];
	}

	private String  category;
	private String  director;
	private int length;
	private float cost;
	private static int nbDVD=0;
	private int id=nbDVD;
	private LocalDate dateAdded;
	
// get information
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public float getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}
	

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void printDetail(DVD dvd) {
		System.out.println(dvd.getId()+"- "+ dvd.getTitle()+"- " + dvd.getCategory()+
				"- " + dvd.getDirector()+"- " + dvd.getLength()+"- " +
				dvd.getCost()+"$- "+dateAdded);
	}
	public void printDVD(DVD dvd) {
		
		
		System.out.format("%2s%20s%20s%15s%10s%7s%15s\n",
						  "Id","Title","Category","Director",
						  "Length","Cost","CreatedDate");
			System.out.format("%2s%20s%20s%15s%10s%7s%15s\n", dvd.getId(),
							  dvd.getTitle(), dvd.getCategory(), dvd.getDirector(),
							  dvd.getLength(), dvd.getCost(), dvd.getDateAdded());	
	
	}
//  +DVD
	public DVD() {
		super();			
		this.dateAdded=LocalDate.now();
		total[nbDVD]=this;	
		nbDVD++;
		
	}
	public DVD(String title) {
		super();
		this.title = title;
		this.dateAdded= LocalDate.now();
		total[nbDVD]=this;
		nbDVD++;
	}

	public DVD(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded= LocalDate.now();
		total[nbDVD]=this;
		nbDVD++;	
	}

	public DVD(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded= LocalDate.now();
		total[nbDVD]=this;
		nbDVD++;		
	}

	public DVD(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded= LocalDate.now();
		total[nbDVD]=this;
		nbDVD++;		
	}
//	Set
	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public boolean search(String title) {
		
		for (int i=0; i<nbDVD;i++ ) {
			if (total[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				return true;
			}			
		}
		return false;	
	}	
	
}
