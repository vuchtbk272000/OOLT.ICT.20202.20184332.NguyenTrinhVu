package hust.soict.globalict.aims.Aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.store.*;

public class Aims {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DVD dvd1 = new DVD("The Lion King", "Animation","Roger Allers",87,19.95f);
		DVD dvd2 = new DVD("Star Wars","Science Fiction","George Lucas",87, 24.95f);
		DVD dvd3 = new DVD("Aladdin","Animation",18.99f);
		DVD[] sample= new DVD[10];
		Store aStore= new Store();
		aStore.addDVD(dvd1);
		aStore.addDVD(dvd2);
		aStore.addDVD(dvd3);
		Cart anOrder = new Cart();
		anOrder.addDVD(dvd3);
		anOrder.addDVD(dvd1,dvd2);
		
		int check=0;
		
		
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
							aStore.getDVD(i).printDVD(aStore.getDVD(i));
							System.out.println("Do you want to put it into your cart?\n1.Yes\n2.No\n");
							check = keyboard.nextInt();
							if (check== 1) {
								anOrder.addDVD(aStore.getDVD(i));
							}
							break;
						case 2:
							System.out.println("input id to add to your cart:");
							i= keyboard.nextInt();
							anOrder.addDVD(aStore.getDVD(i));
							break;
						case 3:
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
									int c=0;
									for (DVD disc : sample) {
										if (disc != null)
												c++;
									}
									if (c>0)
										for(DVD disc : sample) {
											if (disc != null)
											disc.printDVD(disc);
										}
									else System.out.println("no DVD matched");
								
									break;
								case 2: 
									System.out.println("Sort by:\n1. cost\n2. title\n3. title-cost-length\n");
									i = keyboard.nextInt();
									if (i==1) { 
										anOrder.sortByCost();										
									}
									else if (i==2)
										anOrder.sortByTitle();
									else anOrder.sortAllField();
									anOrder.printCart();
									break;
								case 3:
									System.out.println("id of the DVD to removed:");
									int id= keyboard.nextInt();
									for (i=0;i<anOrder.getQty();i++) {
										if (anOrder.getDVD(i).getId()==id) {
											anOrder.removeDVD(anOrder.getDVD(i));
											break;
										}
									}
									break;
								case 4:
									System.out.println("an order\r\n"
											+ "is created and empty the current cart");
									break;
									
								}
								
							}while (innerchoice !=0);	
							break;
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
						aStore.addDVD(dvd1.getDVDById(id));
					}
					else {
						System.out.println("input DVD id to add to store:");
						int id = keyboard.nextInt();
						aStore.remove(dvd1.getDVDById(id));
					}
					break;
				case 3:
					
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
								sample = anOrder.searchById(id);
							}
							else {
								System.out.println("input keyword: ");
								keyboard.nextLine();
								String token= keyboard.nextLine();
								sample = anOrder.searchByTitle(token);
							}
							int c=0;
							for (DVD disc : sample) {
								if (disc != null)
										c++;
							}
							if (c>0)
								for(DVD disc : sample) {
									if (disc != null)
									disc.printDVD(disc);
								}
							else System.out.println("no DVD matched");
							break;
						case 2: 
							System.out.println("Sort by:\n1. cost\n2. title\n3. title-cost-length\n");
							i = keyboard.nextInt();
							if (i==1) { 
								anOrder.sortByCost();										
							}
							else if (i==2)
								anOrder.sortByTitle();
							else anOrder.sortAllField();
							anOrder.printCart();
							break;
						case 3:
							System.out.println("id of the DVD to removed:");
							int id= keyboard.nextInt();
							for (i=0;i<anOrder.getQty();i++) {
								if (anOrder.getDVD(i).getId()==id) {
									anOrder.removeDVD(anOrder.getDVD(i));
									break;
								}
							}
							break;
						case 4:
							System.out.println("an order\r\n"
									+ "is created and empty the current cart");
							break;
							
						}
						
					}while (choice !=0);	
					break;
				
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
