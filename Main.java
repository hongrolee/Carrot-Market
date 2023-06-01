import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scn;
	static ArrayList<Member> members;
	static ArrayList<Product> products;
	static int member_counter = 0;
	static int product_counter = 0;
	static FileManager fm = new FileManager("members.txt");
	static FileManager pFm = new FileManager("products.txt");
	
	public Main() {
		
	}

	public static void main(String[] args) {
		File f = new File("members.txt");
		boolean isFile = f.exists();
		if(isFile) {
			members = (ArrayList<Member>)fm.load();
		} else {
			members = new ArrayList<Member>();
		}
		
		File pf = new File("products.txt");
		boolean isPFile = pf.exists();
		if(isPFile) {
			products = (ArrayList<Product>)pFm.load();
		} else {
			products = new ArrayList<Product>();
		}

		
					
		scn = new Scanner(System.in);

		System.out.println("사과마켓에 오신 것을 환영합니다.");

		while (true) { // 로그인 및 회원가입 반복
			int login_menu = printLoginMenu();
			if (login_menu == 1) {
				boolean isLogined = printLoginForm();
				if(isLogined == true) {					
					break;
				}else {
					System.out.println("로그인 실패. 다시 로그인 바랍니다.");
				}				
			} else if (login_menu == 2) {
				boolean isSignedUp = printSignUpForm();
				if (isSignedUp == true) {
					System.out.println("회원가입을 축하드립니다.");
				} else {
					System.out.println("회원가입에 실패하셨습니다.");
				}				
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}

		while (true) { // 메인메뉴 관련 반복
			
			int main_menu = printMainMenu();

			if (main_menu == 1) {
				// 중고물품 화면 출력
				printProductForm();				
			} else if (main_menu == 2) {
				// 중고물품 등록하기 화면 출력
				printProductRegistForm();				
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
			} else if (main_menu == 5) {
				System.out.println("안녕히 가십시요~");
				fm.save(members);
				System.exit(1);
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}
	}

	private static boolean printLeave() {
		boolean isLeave = false;
		System.out.println();
		System.out.println("<회원 탈퇴 화면>");
		System.out.println("탈퇴하실 아래의 정보를 입력하세요.");
		System.out.print("이메일 입력: ");
		String email = scn.next();
		System.out.print("패스워드 입력: ");
		String password = scn.next();
		
		for(int i=0; i<=99; i++) {
			if(email.equals(members.get(i).getEmail())&&password.equals(members.get(i).getPassword())) {
				members.get(i).initData();
				isLeave = true;
			}
		}			
		return isLeave;
	}

	private static void printMyPickProductList() {
		for(int i=0; i<members.size();i++) {
			for(int j=0; j<members.get(i).pickedProducts.size();j++) {
				int p_id = members.get(i).pickedProducts.get(j);
				for(int k=0;k<products.size();k++) {
					Product p = products.get(k);
					if(p.id == p_id) {
						System.out.println("물품명 : " + p.name);
						System.out.println("구입년도 : " + p.year);
						System.out.println("위치 : " + p.address);
						System.out.println("판매자 : " + p.email);
						System.out.println("가격 : "+ p.price);
					}
				}				
			}
		}
		
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
		String email = scn.next();
		System.out.print("가격 :");
		int pPrice = scn.nextInt();
		
		Product p = new Product(pName, pYear, pLocation, email, pPrice);
//		p.email = pId;
//		p.name = pName;
//		p.year = pYear;
//		p.address = pLocation;
//		p.price = pPrice;
		
		products.add(p);
		pFm.save(products);
	}

	private static void printProductForm() {
		System.out.println();
		System.out.println("<중고물품 목록보기>");
		
		for(int i=0; i<products.size(); i++) {
			System.out.println();
			System.out.println("<"+(i+1)+">");
			System.out.println("물품명 : " + products.get(i).name);
			System.out.println("구입년도 : " + products.get(i).year);
			System.out.println("위치 : " + products.get(i).address);
			System.out.println("판매자 : " + products.get(i).email);
			System.out.println("가격 : "+ products.get(i).price);
		}				
	}

	private static int printMainMenu() {
		System.out.println();
		System.out.println("<메인메뉴>");
		System.out.println("1.중고물품 목록보기");
		System.out.println("2.중고물품 등록하기");
		System.out.println("3.회원정보 관리");
		System.out.println("4.로그아웃");
		System.out.println("5.종료하기");
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
		
		Member user = new Member(email, password, nickname, phone, address);
		
		boolean result = members.add(user);
		
		return result;
	}

	private static boolean printLoginForm() {
		boolean isLogin = false;
		System.out.println();
		System.out.println("<로그인 화면>");
		System.out.print("이메일 입력: ");
		String email = scn.next();
		System.out.print("패스워드 입력: ");
		String password = scn.next();
		
		for(int i=0; i<members.size(); i++) {
			if(email.equals(members.get(i).getEmail())&&password.equals(members.get(i).getPassword())) {
				System.out.println("로그인 되었습니다.");
				isLogin = true;
				break;
			}
		}
		
		return isLogin;
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
