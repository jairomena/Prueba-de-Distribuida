package com.distribuida.servicios;

import java.util.List;
import com.distribuida.db.Book;

public interface BookService {
    Book findById(Integer id);
    List<Book> findAll();
    boolean delete(Integer id);
    Book update(Book book, Integer id);
    Book insert(Book book);
}
