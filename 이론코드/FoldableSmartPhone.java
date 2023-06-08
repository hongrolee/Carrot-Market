
public class FoldableSmartPhone extends SmartPhone {
	float foldableScreen_x;
	float foldableScreen_y;
	
	public FoldableSmartPhone() {
		foldableScreen_x = 3.5f;
		foldableScreen_y = 5.0f;
	}
	
	void folding() {
		foldableScreen_x = 1.5f;
		foldableScreen_y = 5.0f;
	}
	
	public void display( ) {
		System.out.println("폴더블 후 스마트폰 화면 출력");
	}
}
