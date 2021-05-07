package hust.soict.globalict.test;

public class Main {

	public static void main(String[] args) {
		Child obj1 = new Child();
        Parent obj2 = obj1;
	       // As per overriding rules this should call to class Derive's static 
	       // overridden method. Since static method can not be overridden, it 
	       // calls Base's display() 
	       obj1.display();  
	         
	       // Here overriding works and Derive's print() is called 
	       obj1.print();  
	       
	       obj2.display();
	       obj2.print();

	}

}
