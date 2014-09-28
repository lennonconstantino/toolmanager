package com.toolmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.toolmanager.dao.BookDAO;
import com.toolmanager.dao.GenericDAO;
import com.toolmanager.model.Book;

public class BookDaoImpl extends GenericDAO<Book> implements BookDAO {
	public BookDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public void insert(Book book) {
		super.save(book);
	}

	@Override
	public void update(Book book)
	{
		super.update(book);
	}

	@Override
	public void delete(Book book)
	{
		super.delete(book);
	}
	
	@Override
	public Book getBookById(Long id_book) {
		return super.getById(id_book);
	}

	@Override
	public Book getBookByName(String name) {
		String sql = "SELECT b FROM book b WHERE b.name = :param";
		return super.get(sql, name);
	}

	@Override
	public List<Book> findAllBook(Long id_person) {
		String sql = "SELECT b.id_book, b.dateCreation, b.description, b.name " + 
					 "FROM book b, person_book p " + 
					 "WHERE b.id_book = p.books_id_book " +
					 "AND p.person_id_person = " + id_person;
		return super.getList(sql);
	}

}
