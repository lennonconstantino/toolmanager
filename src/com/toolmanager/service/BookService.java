package com.toolmanager.service;

import java.util.List;

import com.SimpleEntityManager;
import com.toolmanager.dao.BookDAO;
import com.toolmanager.dao.impl.BookDaoImpl;
import com.toolmanager.model.Book;

public class BookService {
	private BookDAO dao;
	private SimpleEntityManager simpleEntityManager;
	
    public BookService(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new BookDaoImpl(simpleEntityManager.getEntityManager());
    }
    
    public void insert(Book book){
        try{
            simpleEntityManager.beginTransaction();
            dao.insert(book);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<Book> findAll(Long id_person){
        return dao.findAllBook(id_person);
    }
}
