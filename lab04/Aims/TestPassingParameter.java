package Aims;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD jungleDVD = new DVD("jungle");
		DVD cinderellaDVD = new DVD("cinderella");
		DVD tmp = jungleDVD;
		jungleDVD = cinderellaDVD;
		cinderellaDVD = tmp;
		System.out.println("jung title:"+ jungleDVD.getTitle());
		System.out.println("cinderella title:"+ cinderellaDVD.getTitle());
		String oldTiltle = jungleDVD.getTitle();
		jungleDVD.setTitle(cinderellaDVD.getTitle());
		
	}

}
