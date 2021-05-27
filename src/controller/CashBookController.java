package controller;

import java.util.List;
import java.util.Scanner;

import model.CashBookCategoryVO;
import model.CashBookDAO;
import model.CashBookVO;

import view.CashBookView;

 
public class CashBookController {
	
	public static void main(String[] args) {

		CashBookDAO CashBookDAO = new CashBookDAO();
		CashBookVO book = null;
		int memberId=0;
		int result = 0;
		String pass="";
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("==================================");
			System.out.println("     1.로그인 2.사용자생성 3.종료        ");
			System.out.println("==================================");
			System.out.print("선택하세요>>");
			int work = sc.nextInt();
			switch (work) {
			case 1:		
			
				System.out.println("==================================");
				System.out.println("               로그인               ");
				System.out.println("==================================");
				System.out.print("아이디>>");
				memberId = sc.nextInt();
				System.out.print("비밀번호>>");
				pass = sc.next();

				int a=CashBookDAO.bookLogin(memberId ,pass);

				//---------------------------
						switch (a) {
						case 1:
							loginSuccess(memberId);
							break;
						case 0:
							System.out.println("불일치");
							break;
						case -1:
							System.out.println("아이디 없음");
							break;
						default:
							break;
						}
				//---------------------------
				
				break;
				
			case 2:
				System.out.println("==================================");
				System.out.println("              회원가입               ");
				System.out.println("==================================");
				book = new CashBookVO();
				System.out.print("아이디 입력>>" );
				int insertid = sc.nextInt();
				System.out.print("패스워드 입력>>" );
				String insertpass = sc.next();
				System.out.print("이메일 입력>>" );
				String insertmail = sc.next();
				
			
				result = CashBookDAO.memberInsert(insertid, insertpass, insertmail);
				CashBookView.boardPrint(result>0?"가입성공":"가입실패");
				break;
				
			case 3:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
				
			default:
				break;
			}
		}

	}
	
	
	
	private static void loginSuccess(int memberId) {
		int result = 0;
		String startDate =null;
		String endDate = null;
		CashBookVO book  = null;
		CashBookDAO CashBookDAO = new CashBookDAO();
		List<CashBookCategoryVO> categoryList=CashBookDAO.selectCategoryList();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("==================================");
		System.out.println("          ■ 회원페이지 ■             ");
		System.out.println("==================================");
		System.out.println("1.입력 2.수정 3.삭제 ");
		System.out.println("----------------------------------");
		System.out.println("4.모두조회 5.기간별조회 6.기간별 수입/지출합계");
		System.out.println("----------------------------------");
		System.out.println("7.사용자정보수정 8.사용자삭제 9.종료");
		System.out.println("==================================");
		System.out.print("선택하세요>>");
		
		int work = sc.nextInt();
		
		switch (work) {
		case 1: //입력
			System.out.println("==================================");
			System.out.println("              내역입력               ");
			System.out.println("==================================");
			book = new CashBookVO();
		
			System.out.print("날짜>>");				
			book.setCashbook_date(sc.next());
			System.out.print("사용내역>>");	
			book.setCashbook_title(sc.next());
			System.out.print("금액>>");	
			book.setCashbook_cash(sc.nextInt());						
			CashBookView.categoryPrint(categoryList); //카테고리 리스트
			System.out.print("항목>>");	
			book.setCashbook_category(sc.next());
			book.setCashbook_memberid(memberId);
			
			result = CashBookDAO.bookInsert(book);
			CashBookView.boardPrint(result>0?"입력성공":"입력실패");
			break;
			
		case 2: //수정
			book = new CashBookVO();
			
			System.out.println("==================================");
			System.out.println("              내역수정               ");
			System.out.println("==================================");
			
			List<CashBookVO> listall1=CashBookDAO.selectCashbookList(memberId);
			CashBookView.boardPrint(listall1);
			
			System.out.print("수정할 게시물 번호>>");
			book.setCashbook_cashno(sc.nextInt());
			System.out.print("날짜 변경>>");
			book.setCashbook_date(sc.next());
			System.out.print("제목 변경>>");
			book.setCashbook_title(sc.next());
			System.out.print("금액 변경>>");
			book.setCashbook_cash(sc.nextInt());
			CashBookView.categoryPrint(categoryList);  //카테고리 리스트
			System.out.print("카테고리 변경>>");
			book.setCashbook_category(sc.next());

			result = CashBookDAO.cashbookUpdate(book);
			CashBookView.boardPrint(result>0?"Update성공":"Update실패");			
			break;
			
		case 3: //가계부 내역 삭제
			book = new CashBookVO();
			
			System.out.println("==================================");
			System.out.println("              내역삭제               ");
			System.out.println("==================================");
			
			List<CashBookVO> deleteForList=CashBookDAO.selectCashbookList(memberId);
			CashBookView.boardPrint(deleteForList);
			
			System.out.print("삭제할 항목 번호>>");
			book.setCashbook_cashno(sc.nextInt());	
			result = CashBookDAO.bookDelete(book);
			CashBookView.boardPrint(result>0?"삭제성공":"삭제실패");
			
//			System.out.println("삭제할 항목 번호>>");
//			CashBookDAO.bookDelete(sc.nextInt());
//			int aaa=0;
//			result = CashBookDAO.bookDelete(aaa); 		
//			CashBookView.boardPrint(result>0?"삭제성공":"삭제실패");
			break;
			
		case 4: //모두조회
			System.out.println("==================================");
			System.out.println("              모두조회               ");
			System.out.println("==================================");
			
			List<CashBookVO> listall=CashBookDAO.selectCashbookList(memberId);
			CashBookView.boardPrint(listall);
			break;
			
		case 5: //기간조회
			System.out.println("==================================");
			System.out.println("             기간별조회              ");
			System.out.println("==================================");
			book = new CashBookVO();

			book.setCashbook_memberid(memberId);
			System.out.print("시작날짜>>");				
			startDate = sc.next();
			System.out.print("종료날짜>>");	
			endDate = sc.next();					
			
			List<CashBookVO> searchCondition = CashBookDAO.searchCondition(memberId, startDate, endDate);
			CashBookView.boardPrint(searchCondition);
			break;
			
		case 6: //기간별 수입 지출 합계
			book = new CashBookVO();
			System.out.println("==================================");
			System.out.println("         기간별 수입 지출 합계           ");
			System.out.println("==================================");
			
			book.setCashbook_memberid(memberId);
			System.out.print("시작날짜>>");	
			startDate = sc.next();
			System.out.print("종료날짜>>");	
			endDate = sc.next();
			System.out.print("항목(수입/지출)>>");	
			book.setCashcategory_type(sc.next());	
			int reportRs= CashBookDAO.report(memberId, startDate, endDate, book);
			CashBookView.boardPrint(reportRs);
			break;
			
		case 7: //사용자 정보 수정
			book = new CashBookVO();

			System.out.println("==================================");
			System.out.println("            사용자정보수정             ");
			System.out.println("==================================");
			
			System.out.println("변경할 암호>>");
			book.setCashmember_pass(sc.next());
			System.out.println("변경할 메일>>");
			book.setCashmember_mail(sc.next());
			book.setCashmember_id(memberId);
			
			result = CashBookDAO.memberUpdate(book, memberId);
			CashBookView.boardPrint(result>0?"Update성공":"Update실패");
			break;
			
		case 8: //사용자 삭제
			book = new CashBookVO();
			
			System.out.println("==================================");
			System.out.println("             사용자삭제               ");
			System.out.println("==================================");
			
			System.out.print("삭제하시겠습니까?(1.yes/2.no)>>");	
			
			if (1 == sc.nextInt()) {
				CashBookDAO.memberDelete(memberId);	
				
				System.out.println("삭제");
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
			System.out.println("돌아갑니다.");
			break;
			
		case 9: //종료
			System.out.println("==================================");
			System.out.println("           프로그램종료               ");
			System.out.println("==================================");
			System.out.println("프로그램 종료");
			System.exit(0);
			break;
		default:
			break;
		}
	}

}
	


}
