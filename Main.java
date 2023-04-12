import java.util.Scanner;

public class Main {

	static Scanner scn;

	public static void main(String[] args) {

		scn = new Scanner(System.in);

		System.out.println("사과마켓에 오신 것을 환영합니다.");

		while (true) { // 로그인 및 회원가입 반복
			int login_menu = printLoginMenu();
			if (login_menu == 1) {
				boolean isLogined = printLoginForm();
				break;
			} else if (login_menu == 2) {
				boolean isSignedUp = printSignUpForm();
				if (isSignedUp == true) {
					System.out.println("회원가입을 축하드립니다.");
				} else {
					System.out.println("회원가입에 실패하셨습니다.");
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}

		while (true) { // 메인메뉴 관련 반복
			
			int main_menu = printMainMenu();

			if (main_menu == 1) {
				// 중고물품 화면 출력
				printProductForm();
				break;
			} else if (main_menu == 2) {
				// 중고물품 등록하기 화면 출력
				printProductRegistForm();
				break;
			} else if (main_menu == 3) {
				// 회원정보 관리 화면 출력
				while(true) {
					int menu = printMemberMenu();
					if(menu == 1) {
						printMemberInfoModificationForm();
						break;
					} else if(menu == 2) {
						printMySellProductList();
						break;
					} else if(menu == 3) {
						printMyBuyProductList();
						break;
					} else if(menu == 4) {
						printMyPickProductList();
						break;
					} else if(menu == 5) {
						printLeave();
						break;
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				}				
				break;
			} else if (main_menu == 4) {
				// 로그아웃 실행
				System.out.print("정말로 로그아웃 하시겠습니까?(1.예, 2.아니오):");
				int confirm = scn.nextInt();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}

	private static void printLeave() {
		// TODO Auto-generated method stub
		
	}

	private static void printMyPickProductList() {
		// TODO Auto-generated method stub
		
	}

	private static void printMyBuyProductList() {
		// TODO Auto-generated method stub
		
	}

	private static void printMySellProductList() {
		// TODO Auto-generated method stub
		
	}

	private static void printMemberInfoModificationForm() {
		System.out.println();
		System.out.println("<회원정보 수정화면>");
		System.out.print("이메일 : ");
		String email = scn.next();
		System.out.print("패스워드 : ");
		String password = scn.next();
		System.out.print("닉네임 : ");
		String nickname = scn.next();
		System.out.print("전화번호 : ");
		String phone = scn.next();
		System.out.print("사는지역(대전시 O구): ");
		String address = scn.next();
	}

	private static int printMemberMenu() {
		System.out.println();
		System.out.println("<회원정보 관리>");
		System.out.println("1.회원정보 수정");
		System.out.println("2.나의 판매상품 목록보기");
		System.out.println("3.나의 구매이력 보기");
		System.out.println("4.나의 찜 목록 보기");
		System.out.println("5.탈퇴하기");
		System.out.print("*메뉴를 선택하세요:");
		int main_menu = scn.nextInt();
		return main_menu;
	}

	private static void printProductRegistForm() {
		System.out.println();
		System.out.println("<중고물품 등록하기>");
		System.out.print("물품명 :");
		String pName = scn.next();
		System.out.print("구입년도 :");
		int pYear = scn.nextInt();
		System.out.print("위치 :");
		String pLocation = scn.next();
		System.out.print("판매자 :");
		String pId = scn.next();
		System.out.print("가격 :");
		int pPrice = scn.nextInt();
		// 상품 파일에 저장하기		
	}

	private static void printProductForm() {
		System.out.println();
		System.out.println("<중고물품 목록보기>");
		System.out.println("1.");
		System.out.println("물품명 : 자전거");
		System.out.println("구입년도 : 2021년");
		System.out.println("위치 : 대전시 서구");
		System.out.println("판매자 : 아우리");
		System.out.println("가격 : 50,000원");		
	}

	private static int printMainMenu() {
		System.out.println();
		System.out.println("<메인메뉴>");
		System.out.println("1.중고물품 목록보기");
		System.out.println("2.중고물품 등록하기");
		System.out.println("3.회원정보 관리");
		System.out.println("4.로그아웃");
		System.out.print("*메뉴를 선택하세요:");
		int main_menu = scn.nextInt();
		return main_menu;
	}

	private static boolean printSignUpForm() {
		System.out.println();
		System.out.println("<회원가입 화면>");
		System.out.print("이메일 입력: ");
		String email = scn.next();
		System.out.print("패스워드 입력: ");
		String password = scn.next();
		System.out.print("닉네임 입력: ");
		String nickname = scn.next();
		System.out.print("전화번호 입력: ");
		String phone = scn.next();
		System.out.print("사는지역 입력(대전시 O구): ");
		String address = scn.next();

		// 실제 사용자 정보 저장
		return false;
	}

	private static boolean printLoginForm() {
		System.out.println();
		System.out.println("<로그인 화면>");
		System.out.print("이메일 입력: ");
		String email = scn.next();
		System.out.print("패스워드 입력: ");
		String password = scn.next();
		System.out.println("로그인 되었습니다.");
		return false;
	}

	private static int printLoginMenu() {
		System.out.println();
		System.out.println("1.로그인 2.회원가입");
		System.out.print("*메뉴를 선택하세요:");

		int menu = scn.nextInt();
		System.out.println("선택하신 메뉴는 " + menu + "입니다.");
		return menu;
	}
}
