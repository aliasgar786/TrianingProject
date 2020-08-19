package com.montran.pojo;

import java.sql.Date;  
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "book_issue")
public class BookIssue {
	//private static final long serialVersionID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Issue_serialno")
	private int issueNo;
	
	@Column(name="Issue_date")
	private Date issueDate;
	@Column(name="Return_date")
	private Date returnDate;
	
	@OneToOne
	@JoinColumn(name="book_code")
	private Book book;
	
	@OneToOne
	@JoinColumn(name="member_code")
	private Member member;
	
	public BookIssue() {

	}

	public BookIssue(int issueNo, Date issueDate, Date returnDate, Book book, Member member) {
		super();
		this.issueNo = issueNo;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.book = book;
		this.member = member;
	}

	public int getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(int issueNo) {
		this.issueNo = issueNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "BookIssue [issueNo=" + issueNo + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", book="
				+ book + ", member=" + member + "]";
	}

	

}
