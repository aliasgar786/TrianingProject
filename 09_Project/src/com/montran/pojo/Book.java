package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book_master")
public class Book {
	@Id
	@Column(name ="book_code")
	private String bookCode;
	
	private String title;
	private String author;
	
	@Column(name="issue_status")
	private String issueStatus;
	
	@Column(name="is_issued")
	private int isIssued;
	
	public Book() {
		
	}

	public Book(String bookCode, String title, String author, String issueStatus, int isIssued) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.issueStatus = issueStatus;
		this.isIssued = isIssued;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public int getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(int isIssued) {
		this.isIssued = isIssued;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", author=" + author + ", issueStatus=" + issueStatus
				+ ", isIssued=" + isIssued + "]";
	}

	
	
}
