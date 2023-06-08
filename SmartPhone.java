
public class SmartPhone {
	String os;
	String color;
	int volume;
	static int soldCounter = 0;
	
	public SmartPhone() {
		soldCounter++;
	}
	
	public String myOS() {
		return os;
	}
	
	public int myVolume() {
		return volume;
	}
	
	public void call() {
		System.out.print("나 전화 걸었어");
		myVolume();
	}
	
	public void sendMessage() {
		
	}
	
	public void volumeUp() {
		
	}
	
	public void volumeDown() {
		
	}
	
	public void display() {
		System.out.println("일반적인 스마트폰 화면 출력");
	}
	
}
