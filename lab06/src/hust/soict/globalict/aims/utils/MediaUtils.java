package hust.soict.globalict.aims.utils;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;

public class MediaUtils {
	DVD min;
	public MediaUtils() {
		
	}
	public int compareByCost(Media dvd1, Media dvd2) {
		if (dvd1.getCost() < dvd2.getCost())	
			return -1;
		else if (dvd1.getCost() > dvd2.getCost()) return 1;
		else return 0;
			
	}
	public DVD compareByTitle(DVD dvd1, DVD dvd2) {
		String t1= dvd1.getTitle();
		String t2= dvd2.getTitle();
		int i;
		for (i=0;i< t1.length();i++)
			if (t1.compareToIgnoreCase(t2)>0) {
				return dvd2;
				}
		return dvd1;
	}
	
	public int compareByLength(Media dvd1, Media dvd2) {
		if (dvd1.getLength() < dvd2.getLength())	
			return -1;
		else if (dvd1.getLength() > dvd2.getLength()) return 1;
		else return 0;
	}
	public void swap(DVD dvd1, DVD dvd2) {
		DVD tmp= new DVD();
		tmp.setTitle(dvd1.getTitle());
		tmp.setCategory(dvd1.getCategory());
		tmp.setCost(dvd1.getCost());
		tmp.setDirector(dvd1.getDirector());
		tmp.setLength(dvd1.getLength());
		tmp.setId(dvd1.getId());
		
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setCost(dvd2.getCost());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setId(dvd2.getId());
		
		dvd2.setTitle(tmp.getTitle());
		dvd2.setCategory(tmp.getCategory());
		dvd2.setCost(tmp.getCost());
		dvd2.setDirector(tmp.getDirector());
		dvd2.setLength(tmp.getLength());
		dvd2.setId(tmp.getId());
	}
	public void swap(Book book1, Book book2) {
		Book tmp= new Book();
		tmp.setTitle(book1.getTitle());
		tmp.setCategory(book1.getCategory());
		tmp.setCost(book1.getCost());
		tmp.setAuthors(book1.getAuthors());	
		tmp.setId(book1.getId());
		
		book1.setTitle(book2.getTitle());
		book1.setCategory(book2.getCategory());
		book1.setCost(book2.getCost());
		book1.setAuthors(book2.getAuthors());
		book1.setId(book2.getId());
		
		book2.setTitle(tmp.getTitle());
		book2.setCategory(tmp.getCategory());
		book2.setCost(tmp.getCost());
		book2.setAuthors(tmp.getAuthors());
		book2.setId(tmp.getId());
	}
	
	public void swap(MediaWrapper wrapper1, MediaWrapper wrapper2) {
		Media tmp = wrapper1.media;
		wrapper1.media = wrapper2.media;
		wrapper2.media = tmp;
	}
	public ArrayList<MediaWrapper> sortByCost(ArrayList<MediaWrapper> medias){
		for(int i=0;i<medias.size();i++) {
			for(int j=i+1;j<medias.size();j++) {
				if (medias.get(j).media.getCost()>medias.get(i).media.getCost()) {
					swap(medias.get(i), medias.get(j));
					
				}
			}	
		}
		return medias;
	}
	public DVD[] sortByCost(DVD[] dvd){
		for(int i=0;i<dvd.length;i++) {
			for(int j=i+1;j<dvd.length;j++) {
				if (dvd[j].getCost()>dvd[i].getCost()) {
					swap(dvd[i], dvd[j]);
					
				}
				else if (dvd[j].getCost()>dvd[i].getCost()){
					sortByLength(dvd);
				}
			}	
		}
		return dvd;
	}	
	
	public DVD[] sortByTitle(DVD[] dvd) {
		for(int i=0;i<dvd.length;i++) {
			for(int j=i+1;j<dvd.length;j++) {
				if (dvd[i].getTitle().compareToIgnoreCase(dvd[j].getTitle())>0) {
					swap(dvd[i], dvd[j]);
				}
			}				
		}
		for(int i=0;i<dvd.length;i++) {
			for(int j=i+1;j<dvd.length;j++) {
				if (dvd[i].getTitle().compareToIgnoreCase(dvd[j].getTitle())==0) {
					if (dvd[i].getTitle().compareTo(dvd[j].getTitle())<0) {
						swap(dvd[i], dvd[j]);
					}
				}
			}
		}
		return dvd;
	}
	
	public ArrayList<MediaWrapper> sortByTitle(ArrayList<MediaWrapper> medias) {
		for(int i=0;i<medias.size();i++) {
			for(int j=i+1;j<medias.size();j++) {
				if (medias.get(i).media.getTitle().compareToIgnoreCase(medias.get(j).media.getTitle())>0) {
					swap(medias.get(i), medias.get(j));
				}
			}				
		}
		for(int i=0;i<medias.size();i++) {
			for(int j=i+1;j<medias.size();j++) {
				if (medias.get(i).media.getTitle().compareToIgnoreCase(medias.get(j).media.getTitle())==0) {
					if (medias.get(i).media.getTitle().compareTo(medias.get(j).media.getTitle())<0) {
						swap(medias.get(i), medias.get(j));
					}
				}
			}
		}
		return medias;
	}
	public DVD[] sortByLength(DVD[] dvd) {
		for(int i=0;i<dvd.length;i++) {
			for(int j=i+1;j<dvd.length;j++) {
				if (dvd[i].getLength()<(dvd[j].getLength())) {
					swap(dvd[i], dvd[j]);
				}
			}
		
		}
		return dvd;
	}
	
}
