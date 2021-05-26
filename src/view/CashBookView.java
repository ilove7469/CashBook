package view;

import java.util.List;

import model.CashBookCategoryVO;
import model.CashBookVO;

public class CashBookView {
	

	public static void categoryPrint(List<CashBookCategoryVO> categorylist) {
		System.out.println("===================================카테고리출력===========================================");
		for (CashBookCategoryVO CashBookCategoryVO : categorylist) {
			System.out.println(CashBookCategoryVO);
		}

	}

	public static void boardPrint(List<CashBookVO> listall) {

		for (CashBookVO cashBookVO : listall) {
			System.out.println(cashBookVO);

		}

	}

	public static void boardPrint(String message) {
		System.out.println("[알림]" + message);

	}

	public static void boardPrint(int message) {
		System.out.println("지정한 조건의 총 합계는 : " + message);

	}

}

