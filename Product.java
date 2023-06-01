import java.io.Serializable;

public class Product implements Serializable{
	public int id;
	public String name;
	public int year;
	public String address;
	public String email;
	public int price;
	static public int pCnt=0;
	
	public Product() {
		id = pCnt++;
	}
	
	public Product(String pName,int pYear,String pLocation,String email,int pPrice) {
		this();
		this.name = pName;
		this.year = pYear;
		this.address = pLocation;
		this.email = email;
		this.price = pPrice;
	}
}
