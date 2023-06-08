
public class GlassesPhone extends SmartPhone {
	float foldableScreen_x;
	float foldableScreen_y;
	
	public GlassesPhone() {
		foldableScreen_x = 3.5f;
		foldableScreen_y = 5.0f;
	}
	
	void folding() {
		foldableScreen_x = 1.5f;
		foldableScreen_y = 5.0f;
	}
	
	public void display() {
		System.out.println("안경형 스마트폰 화면 출력");
	}
}
