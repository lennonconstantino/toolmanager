package com.toolmanager.dao;

import java.util.List;

import com.toolmanager.model.Book;

public interface BookDAO {
	public void update(Book book);
	public void insert(Book book);
	public void delete(Book book);
	public Book getBookById(Long id_book);
	public Book getBookByName(String name);
	public List<Book> findAllBook(Long id_person);
}
