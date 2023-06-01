import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
	// 멤버변수
	private String email;
	private String password;
	private String nickName;
	private String phone;
	private String address;
	private float heart; //온도	
	public ArrayList<Integer> pickedProducts;
		
	// 생성자
	public Member() {
		pickedProducts = new ArrayList<Integer>();
		this.heart = 36.5f;
	}
	
	public Member(String e, String p, String n, String ph, String a) {
		this();
		this.email = e;
		this.password = p;
		this.nickName = n;
		this.phone = ph;
		this.address = a;		
	}
	
	// 메서드	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getHeart() {
		return heart;
	}

	public void setHeart(float heart) {
		this.heart = heart;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		// 이메일 형식을 체크하는 과정
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void initData() {
		email = null;
		password = null;
		nickName = null;
		phone = null;
		address = null;
		heart = 0.0f;
	}
}
