package com;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Usuario;
import com.toolmanager.model.Book;
import com.toolmanager.model.Note;
import com.toolmanager.model.Role;
import com.toolmanager.model.Status;
import com.toolmanager.model.Task;
import com.toolmanager.model.User;
import com.toolmanager.service.BookService;
import com.toolmanager.service.NoteService;
import com.toolmanager.service.TaskService;
import com.toolmanager.service.UserService;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testeLixo6();
	}
	
	public static void testeLixo1()
	{
		/*
		// Funciona
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fusion-PU");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Usuario usuario = new Usuario();
		usuario.setEmail("contato@gmail.com.br");
		usuario.setDataDeCadastro(Calendar.getInstance());
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		*/		
	}
	public static void testeLixo2()
	{
		/*
        String persistenceUnitName = "fusion-PU";
        
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
         
        //
        // THE SERVICE LAYER ENCAPSULATES EVERY BEGIN/COMMIT/ROLLBACK
        // 
        UsuarioService usuarioService = new UsuarioService(simpleEntityManager);
         
        usuarioService.save(new Usuario("allain.delon@gmail.com", Calendar.getInstance(), null));
        usuarioService.save(new Usuario("kate.moss@gmail.com", Calendar.getInstance(), null));
        usuarioService.save(new Usuario("ted.brown@gmail.com", Calendar.getInstance(), null));
         
        for(Usuario c : usuarioService.findAll()){
            System.out.println(c.getEmail());
        }
<<<<<<< HEAD
                 
        ///
        // ALWAYS NEED TO BE CALLED!
        //
        simpleEntityManager.close();
        */		
=======
        //          
        /**
         * ALWAYS NEED TO BE CALLED!
         */
        simpleEntityManager.close();		
>>>>>>> origin/VERSION
	}
	public static void testeLixo3()
	{
		/*
		// Funciona
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fusion-PU");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Person person = new Person();
		person.setFirstname("Lennon");
		person.setLastname("Constantino");
		person.setBirthday(Calendar.getInstance());
		Set<Book> books = new HashSet<Book>();
		books.add(new Book("study","after I get up",Calendar.getInstance(),null));
		person.setBooks(books);
		
		Set<Note> notes = new HashSet<Note>();
		notes.add(new Note("Goals","I did 2 goals yesterday",Calendar.getInstance()));
		Book book = new Book("sport","afternoon",Calendar.getInstance(),notes);
		
		manager.persist(person);
		manager.persist(book);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		*/
	}	
	public static void testeLixo4()
	{
		/*
		// Funciona
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fusion-PU");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		User user = new User();//User("Oliveil2", "123456", "LennonConstantino",Calendar.getInstance());
		user.setFirstname("Allan");
		user.setLastname("Constantino");
		user.setBirthday(Calendar.getInstance());
		user.setLastLogin(Calendar.getInstance());
		//Set<Book> books = new HashSet<Book>();
		//Set<Note> notes = new HashSet<Note>();
		//notes.add(new Note("Goals","I did 2 goals yesterday",Calendar.getInstance()));		
		//books.add(new Book("study","after I get up",Calendar.getInstance(),notes));
		//user.setBooks(books);		
		
		manager.persist(user);
		
		System.out.println(user.toString());
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		*/
	}
	public static void testeLixo5()
	{
        String persistenceUnitName = "fusion-PU";
        
        SimpleEntityManager simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
        //
        // THE SERVICE LAYER ENCAPSULATES EVERY BEGIN/COMMIT/ROLLBACK
        // 
        UserService userService = new UserService(simpleEntityManager);
		TaskService taskService = new TaskService(simpleEntityManager);
		BookService bookService = new BookService(simpleEntityManager);
		NoteService noteService = new NoteService(simpleEntityManager);
        
        //User user = new User("Alinio2", "123456", "AllainConstantino",Calendar.getInstance());
		//user.setFirstname("Allain");
		//user.setLastname("Constantino");
		//user.setBirthday(Calendar.getInstance());
		//user.setLastLogin(Calendar.getInstance());
		Set<Task> tasks = new HashSet<Task>();
		Set<Book> books = new HashSet<Book>();
		Set<Note> notes = new HashSet<Note>();
		//notes.add(new Note("Goals","I did 2 goals yesterday",Calendar.getInstance(), Calendar.getInstance(), 2L, Role.OWNER));		
		//books.add(new Book("study","after I get up",Calendar.getInstance(),notes));
		//tasks.add(new Task("Complete all","todo",Calendar.getInstance(),Calendar.getInstance(),0,true,Status.TODO, Role.OWNER, 2L,books));
		//user.setBooks(books);	
		//user.setTasks(tasks);
		
        //userService.insert(user);
		//taskService.insert(new Task("Complete all","todo",Calendar.getInstance(),Calendar.getInstance(),0,true,Status.TODO, Role.OWNER, null,null));
		//bookService.insert(new Book("study","after I get up",Calendar.getInstance(),null));
		//noteService.insert(new Note("Goals","I did 2 goals yesterday",Calendar.getInstance(), Calendar.getInstance(), null, Role.OWNER));
		
		User user = userService.getUserById(2L);
		
		notes.add(new Note("Goals","I did 2 goals yesterday",Calendar.getInstance(), Calendar.getInstance(), user.getId_person(), Role.OWNER));
		user.setNotes(notes);
		
		userService.update(user);
		
        List<User> users = userService.findAll();
        for(User u : users){
            System.out.println(u.getFirstname());
        }
        //System.out.println(user.toString());
        ///
        // ALWAYS NEED TO BE CALLED!
        //
        simpleEntityManager.close();        
	}
	public static void testeLixo6()
	{
		
	}
}
