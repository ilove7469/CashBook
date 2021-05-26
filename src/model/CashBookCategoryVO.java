package model;

import java.sql.Date;

public class CashBookCategoryVO {
	
	private int cashcategory_no;
	private String cashcategory_type;
	private String cashcategory_category;
	
	
	public CashBookCategoryVO() {
		super();
	}


	public CashBookCategoryVO(int cashcategory_no, String cashcategory_type, String cashcategory_category) {
		super();
		this.cashcategory_no = cashcategory_no;
		this.cashcategory_type = cashcategory_type;
		this.cashcategory_category = cashcategory_category;
	}


	public int getCashcategory_no() {
		return cashcategory_no;
	}


	public void setCashcategory_no(int cashcategory_no) {
		this.cashcategory_no = cashcategory_no;
	}


	public String getCashcategory_type() {
		return cashcategory_type;
	}


	public void setCashcategory_type(String cashcategory_type) {
		this.cashcategory_type = cashcategory_type;
	}


	public String getCashcategory_category() {
		return cashcategory_category;
	}


	public void setCashcategory_category(String cashcategory_category) {
		this.cashcategory_category = cashcategory_category;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CashBookCategory [cashcategory_no=").append(cashcategory_no).append(", cashcategory_type=")
				.append(cashcategory_type).append(", cashcategory_category=").append(cashcategory_category).append("]");
		return builder.toString();
	}


}
