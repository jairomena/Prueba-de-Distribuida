package com.distribuida.rest;

import java.util.List;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import com.distribuida.db.Book;
import jakarta.ws.rs.core.MediaType;
import com.distribuida.servicios.BookService;


@Path("/books")
public class BookRest {
    @Inject private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id){
        return bookService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book insert(Book book){
        return bookService.insert(book);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book update(Book book,@PathParam("id") Integer id){
        return bookService.update(book, id);
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean delete(@PathParam("id") Integer id) {
        return bookService.delete(id);
    }
}
