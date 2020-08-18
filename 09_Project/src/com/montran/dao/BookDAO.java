package com.montran.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.montran.pojo.Book;
import com.montran.pojo.BookIssue;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class BookDAO {
	private Session session;
	private Transaction transaction;

	public void addNewBook(BookIssue book) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}

	public List<BookIssue> getAllIssuedBooks() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("from book_issue");
		List<BookIssue> bookList = query.list();
		session.close();
		return bookList;
	}

	public Book getBook(String bookCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Book book = session.get(Book.class, bookCode);
		session.close();
		return book;
	}

	public Member getMember(String memberCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Member member = session.get(Member.class, memberCode);
		session.close();
		return member;
	}
	
	public int getSerialNo() {
		session=SessionFactoryUtil.getFactory().openSession();
		Query query=session.createQuery("from book_issue order by issue_serialno desc");
		List<BookIssue> bookIssue=query.list();
		int serialNo=bookIssue.size();
		session.close();
		return serialNo;
	}
	
	public void getIssueBook(int serialNo) {
		session = SessionFactoryUtil.getFactory().openSession();
		BookIssue issue=session.get(BookIssue.class, serialNo);
		session.delete(issue);
		session.close();
	}
}
