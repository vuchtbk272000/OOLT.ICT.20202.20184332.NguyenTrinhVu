package hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DVD;
import hust.soict.globalict.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Fiction","George Lucas",87, 24.95f);
		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
		DVD dvd4 = new DVD("bo gia","Science Ficiton","Tran Thanh",87, 24.95f);
		DVD dvd5 = new DVD("kong", "Animation","Roger Allers",87,19.95f);
		DVD dvd6 = new DVD("Avenger", "Action","Roger Allers",99,19.95f);
		ArrayList<Media> sample= new ArrayList<Media>();
		Store aStore= new Store();
		aStore.addMedia(dvd1);
		aStore.addMedia(dvd2);
		aStore.addMedia(dvd3);
		aStore.addMedia(dvd4);
		aStore.addMedia(dvd5);
		aStore.addMedia(dvd6);
		Book book1 = new Book("Truyen Kieu","poem",12f);
		book1.addAuthor("Nguyen Du");
		book1.setContent("t1 t1 t2 t1 t3 t4");
		Book book2 = new Book("Khong gia dinh","Novel",28f);
		book2.addAuthor("Remi");
		book2.addAuthor("Bomen");
		book2.addAuthor("Putin");
		book2.setContent("t2 t3 t3 t1 t4 t5 t6 t7 t8 t1 t1 t1 t1 t2");
		aStore.addMedia(book1);
		aStore.addMedia(book2);
		Cart anOrder = new Cart();
		anOrder.addMedia(dvd3);
//		anOrder.addDVD(dvd1,dvd2);
		
		int check=0, countLucky=0, rand = -1;
		
		
		do {
			aStore.showMenu();
			check = keyboard.nextInt();
			switch (check) {
				case 1:{
					int choice;
					do {
						
						aStore.printStore();
						aStore.storeMenu();
						
						choice = keyboard.nextInt();
						
						switch(choice) {
						case 1:
							System.out.println("input id to view DVD's details:");
							int i= keyboard.nextInt();
							System.out.println(aStore.getMedia(i).getDetail());
							System.out.println("Do you want to put it into your cart?\n1.Yes\n2.No\n");
							check = keyboard.nextInt();
							if (check== 1) {
								anOrder.addMedia(aStore.getMedia(i));
							}
							break;
						case 2:
							System.out.println("input id to add to your cart:");
							i= keyboard.nextInt();
							anOrder.addMedia(aStore.getMedia(i));
							break;
						case 3:
							if (anOrder.getQty()!=0) {
								int innerchoice;
								do {
									aStore.cartMenu();
									innerchoice = keyboard.nextInt();
									switch(innerchoice){
									case 1:
										System.out.println("Filter by:\n1. ID\n2. title\n");
										i = keyboard.nextInt();
										if (i==1) {
											System.out.println("input id: ");
											int id = keyboard.nextInt();
											sample = anOrder.searchById(id);
										}
										else {
											System.out.println("input keyword: ");
											keyboard.nextLine();
											String token= keyboard.nextLine();
											sample = anOrder.searchByTitle(token);
										}	
										
										if (sample.size()>0)
											for(Media m : sample) {											
												System.out.println(m.getDetail());
											}
										else System.out.println("no DVD matched");
										sample.clear();
										break;
									case 2: 
										System.out.println("Sort by:\n1. cost\n2. title\n3. title-cost-length\n");
										i = keyboard.nextInt();
										if (i==1) { 
											anOrder.sortByCost();										
										}
										else if (i==2)
											anOrder.sortByTitle();
//										else anOrder.sortAllField();
										anOrder.printCart();
										break;
									case 3:
										System.out.println("id of the DVD to removed:");
										int id= keyboard.nextInt();
										for (i=0;i<anOrder.getQty();i++) {
											if (anOrder.getMedia(i).getId()==id) {
												anOrder.removeMedia(anOrder.getMedia(i));
												break;
											}
										}
										break;
									case 4:{
										
										if (countLucky<1) { 
												rand=anOrder.getLuckyItem();
												countLucky++;
											}
										else System.out.println("you already got your Lucky item");
										break;
									}
									case 5:
										System.out.println("an order is created ");
										while(anOrder.getQty()!=0) {
											anOrder.clear();
										}
										break;										
									}									
								}while (innerchoice !=0);	
								break;
							}
							else System.out.println("the cart is empty");
						}
					}while (choice !=0);
					break;
				}
				
				case 2:
					System.out.println("Do you want to:\n1. add a DVD\nor\n2. remove a DVD\n");
					int  choice = keyboard.nextInt();
					if (choice==1) {
						System.out.println("input DVD id to add to store:");
						int id = keyboard.nextInt();
						aStore.addMedia(dvd1.getDVDById(id));
					}
					else {
						System.out.println("input DVD id to add to store:");
						int id = keyboard.nextInt();
						aStore.removeMedia(dvd1.getDVDById(id));
					}
					break;
				case 3:
					if (anOrder.getQty()!=0) {
					do {
						aStore.cartMenu();
						choice = keyboard.nextInt();
						switch(choice){
						case 1:
							System.out.println("Filter by:\n1. ID\n2. title\n");
							int i = keyboard.nextInt();
							if (i==1) {
								System.out.println("input id: ");
								int id = keyboard.nextInt();
								for (i=0;i<anOrder.searchById(id).size();i++)
									sample.add(anOrder.searchById(id).get(i));
							}
							else {
								System.out.println("input keyword: ");
								keyboard.nextLine();
								String token= keyboard.nextLine();
								for (i=0;i<anOrder.searchByTitle(token).size();i++)
									sample.add(anOrder.searchByTitle(token).get(i));
							}
							if (sample.size()>0)
							for(Media m : sample) {								
								System.out.println(m.getDetail());
							}
							else System.out.println("no DVD matched");
							sample.clear();
							break;
						case 2: 
							System.out.println("Sort by:\n1. cost\n2. title\n3. title-cost-length\n");
							i = keyboard.nextInt();
							if (i==1) { 
								anOrder.sortByCost();										
							}
							else if (i==2)
								anOrder.sortByTitle();
//							else anOrder.sortAllField();
							anOrder.printCart();
							break;
						case 3:
							System.out.println("id of the DVD to removed:");
							int id= keyboard.nextInt();
							for (i=0;i<anOrder.getQty();i++) {
								if (anOrder.getMedia(i).getId()==id) {
									anOrder.removeMedia(anOrder.getMedia(i));
									break;
								}
							}
							break;
						case 4:
						
							if (countLucky<1) { 
									rand=anOrder.getLuckyItem();
									countLucky++;
								}
							else System.out.println("you already got your Lucky item");
							break;
						
						case 5:
							System.out.println("an order\r\n"
									+ "is created and empty the current cart");
							break;
							
						}
						
					}while (choice !=0);	
					break;
					}
					else System.out.println("the cart is empty");
			}
		}while (check !=0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
//		DVD dvd2 = new DVD("Star Wars","Science Ficiton","George Lucas",87, 24.95f);
//		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
//		DVD [] arDVD= {new DVD("Naruto"), new DVD("Attack on titan")};
//		anOrder.addDVD(dvd1);
//		anOrder.addDVD(dvd2);
//		anOrder.addDVD(dvd3);
////		anOrder.addDVD(dvd1, dvd2);
//		anOrder.addDVD(arDVD);
//		for (int i =0; i<anOrder.getQty();i++)
//			System.out.println(anOrder.getDVD(i).getTitle());
//		System.out.println("the total cost is:"+ anOrder.totalcost());
//		System.out.println("enter DVD index to remove:(from 0 to "+(anOrder.getQty()-1)+ "):");
//		for (int i =0; i<anOrder.getQty();i++)
//			System.out.println((i) +". "+anOrder.getDVD(i).getTitle());
//		int index = keyboard.nextInt();
//		anOrder.removeDVD(index);
//		for (int i =0; i<anOrder.getQty();i++)
//			System.out.println(anOrder.getDVD(i).getTitle());
//		System.out.println("the total cost is:"+ anOrder.totalcost());
		
		
	}	
	
}
