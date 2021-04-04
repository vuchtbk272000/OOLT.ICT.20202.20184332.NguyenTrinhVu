package hust.soict.globalict.test.disc;

import hust.soict.globalict.aims.disc.DVD;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD jungleDVD = new DVD("jungle");
		DVD cinderellaDVD = new DVD("cinderella");
		
		swap(jungleDVD,cinderellaDVD);
		System.out.println("jung title:"+ jungleDVD.getTitle());
		System.out.println("cinderella title:"+ cinderellaDVD.getTitle());
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jung title:" + jungleDVD.getTitle());
		
		
	}
	public static void swap(DVD dvd1, DVD dvd2) {
		DVD tmp= dvd1;
//		tmp.setTitle(dvd1.getTitle());
//		tmp.setCategory(dvd1.getCategory());
//		tmp.setCost(dvd1.getCost());
//		tmp.setDirector(dvd1.getDirector());
//		tmp.setLength(dvd1.getLength());
		
		
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setCost(dvd2.getCost());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		
		
		dvd2.setTitle(tmp.getTitle());
		dvd2.setCategory(tmp.getCategory());
		dvd2.setCost(tmp.getCost());
		dvd2.setDirector(tmp.getDirector());
		dvd2.setLength(tmp.getLength());
		
	}
	public static void changeTitle(DVD dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new  DVD(oldTitle);
	}

}
