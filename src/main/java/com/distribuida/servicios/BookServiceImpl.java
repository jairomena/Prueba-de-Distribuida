package com.distribuida.servicios;

import java.util.*;
import jakarta.inject.Inject;
import com.distribuida.db.Book;
import org.jdbi.v3.core.Handle;
import com.distribuida.configuracion.Dbconfig;
import jakarta.enterprise.context.ApplicationScoped;
import org.jdbi.v3.core.Jdbi;

@ApplicationScoped
public class BookServiceImpl implements BookService {
    @Inject
    private Dbconfig dbConfig;

    public Book findById(Integer id){
        Jdbi jdbi = dbConfig.init();
        Handle buscar = jdbi.open();
        return buscar.createQuery("SELECT * FROM books WHERE id = :id")
                .bind("id",id)
                .mapToBean(Book.class)
                .first();
    }

    public List<Book> findAll(){
        Jdbi jdbi = dbConfig.init();
        Handle buscar = jdbi.open();
        return buscar.createQuery("SELECT * FROM books")
                .mapToBean(Book.class)
                .list();
    }

    public boolean delete(Integer id) {
        Jdbi jdbi = dbConfig.init();
        Handle eliminar = jdbi.open();
        return eliminar.createUpdate("DELETE FROM books WHERE id = :id")
                .bind("id",id)
                .execute()==1;
    }

    public Book update(Book book,Integer id) {
        Jdbi jdbi = dbConfig.init();
        Handle actualizar = jdbi.open();
        return actualizar.createUpdate("UPDATE books SET isbn = :isbn,title = :title, author = :author,price = :price WHERE id = :id")
                .bindBean(book)
                .bind("id",id)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }

    public Book insert(Book book) {
        Jdbi jdbi = dbConfig.init();
        Handle insertar = jdbi.open();
        return insertar.createUpdate("INSERT INTO books (isbn,title,author,price) Values (:isbn,:title,:author,:price)")
                .bindBean(book)
                .executeAndReturnGeneratedKeys()
                .mapToBean(Book.class)
                .findOnly();
    }
}
