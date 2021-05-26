package model;

import java.sql.Date;

public class CashBookVO {
	
	//
	private int cashmember_id;
	private String cashmember_pass;
	private String cashmember_mail;
	//
	private int cashbook_cashno;
	private String cashbook_date;
	private String cashbook_title;
	private int cashbook_cash;
	private String cashbook_category;
	private int cashbook_memberid;
	//
	private int cashcategory_no;
	private String cashcategory_type;
	private String cashcategory_category;
	
	public CashBookVO() {
		super();
	}

	public CashBookVO(int cashmember_id, String cashmember_pass, String cashmember_mail, int cashbook_cashno,
			String cashbook_date, String cashbook_title, int cashbook_cash, String cashbook_category,
			int cashbook_memberid, int cashcategory_no, String cashcategory_type, String cashcategory_category) {
		super();
		this.cashmember_id = cashmember_id;
		this.cashmember_pass = cashmember_pass;
		this.cashmember_mail = cashmember_mail;
		this.cashbook_cashno = cashbook_cashno;
		this.cashbook_date = cashbook_date;
		this.cashbook_title = cashbook_title;
		this.cashbook_cash = cashbook_cash;
		this.cashbook_category = cashbook_category;
		this.cashbook_memberid = cashbook_memberid;
		this.cashcategory_no = cashcategory_no;
		this.cashcategory_type = cashcategory_type;
		this.cashcategory_category = cashcategory_category;
	}

	public int getCashmember_id() {
		return cashmember_id;
	}

	public void setCashmember_id(int cashmember_id) {
		this.cashmember_id = cashmember_id;
	}

	public String getCashmember_pass() {
		return cashmember_pass;
	}

	public void setCashmember_pass(String cashmember_pass) {
		this.cashmember_pass = cashmember_pass;
	}

	public String getCashmember_mail() {
		return cashmember_mail;
	}

	public void setCashmember_mail(String cashmember_mail) {
		this.cashmember_mail = cashmember_mail;
	}

	public int getCashbook_cashno() {
		return cashbook_cashno;
	}

	public void setCashbook_cashno(int cashbook_cashno) {
		this.cashbook_cashno = cashbook_cashno;
	}

	public String getCashbook_date() {
		return cashbook_date;
	}

	public void setCashbook_date(String cashbook_date) {
		this.cashbook_date = cashbook_date;
	}

	public String getCashbook_title() {
		return cashbook_title;
	}

	public void setCashbook_title(String cashbook_title) {
		this.cashbook_title = cashbook_title;
	}

	public int getCashbook_cash() {
		return cashbook_cash;
	}

	public void setCashbook_cash(int cashbook_cash) {
		this.cashbook_cash = cashbook_cash;
	}

	public String getCashbook_category() {
		return cashbook_category;
	}

	public void setCashbook_category(String cashbook_category) {
		this.cashbook_category = cashbook_category;
	}

	public int getCashbook_memberid() {
		return cashbook_memberid;
	}

	public void setCashbook_memberid(int cashbook_memberid) {
		this.cashbook_memberid = cashbook_memberid;
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
		builder.append("CashBookVO [cashbook_cashno=").append(cashbook_cashno).append(", cashbook_date=")
				.append(cashbook_date).append(", cashbook_title=").append(cashbook_title).append(", cashbook_cash=")
				.append(cashbook_cash).append(", cashcategory_no=").append(cashcategory_no)
				.append(", cashcategory_type=").append(cashcategory_type).append(", cashcategory_category=")
				.append(cashcategory_category).append("]");
		return builder.toString();
	}


}
