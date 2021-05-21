package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;

public class DVD extends Disc implements Playable {
//	private static DVD total[]= new DVD[1000];
//	
//	
//	public DVD getDVDById(int i) {
//		return total[i];
//	}
//	private static int nbDVD=0;
//	private LocalDate dateAdded;
//	
	@Override
	public String getDetail() {
		String s;
		s = "DVD: "+ id + "- "+ title+ "- "+category+"- "+director+"- "+length+"- "+cost+"- "+dateAdded;
		return s;
	}
//	public void printDVD(DVD dvd) {
//		
//		
//		System.out.format("%2s%20s%20s%15s%10s%7s%15s\n",
//						  "Id","Title","Category","Director",
//						  "Length","Cost","CreatedDate");
//			System.out.format("%2s%20s%20s%15s%10s%7s%15s\n", dvd.getId(),
//							  dvd.getTitle(), dvd.getCategory(), dvd.getDirector(),
//							  dvd.getLength(), dvd.getCost(), dvd.getDateAdded());	
//	
//	}
//  +DVD
	

	public DVD(String title, String category, String director, int length, float cost) {
		super(title, category, cost, director);
		this.length = length;
	}

	
		
//	public boolean search(String title) {
//		
//		for (int i=0; i<nbDVD;i++ ) {
//			if (total[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
//				return true;
//			}			
//		}
//		return false;	
//	}	
	@Override
	public void play() throws PlayerException{
		if (this.length > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else throw new PlayerException("ERROR: the DVD's length is non-positive");
	}
	
	@Override
	public boolean equals(Object o) throws NullPointerException,ClassCastException{
		if (this != null) {				
			if (o instanceof DVD) {
				DVD media = (DVD)o;
				if (this.title==media.title && this.cost == media.cost)
					return true;
				else return false;
			}
			else throw new ClassCastException("Class Cast Exception");
		}
		else throw new NullPointerException("Null Exception");	
		
	}
	
}
