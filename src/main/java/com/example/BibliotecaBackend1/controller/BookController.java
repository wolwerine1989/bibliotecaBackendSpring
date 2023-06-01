package com.example.BibliotecaBackend1.controller;

import com.example.BibliotecaBackend1.exception.BookNotFoundException;
import com.example.BibliotecaBackend1.model.Book;
import com.example.BibliotecaBackend1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //Guardar Libro
    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook){
        return bookRepository.save(newBook);
    }

    //Lista de libros
    @GetMapping("/books")
    List<Book>getAllBooks(){
        return bookRepository.findAll();
    }


    //Buscar id del libro, si no encuentra lanza un error 404
    @GetMapping("/book/{id}")
    Book getBookId(@PathVariable Long id){
        return bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));

    }

    @PutMapping("/book/{id}")
    Book updateBook(@RequestBody Book newBook,@PathVariable Long id){
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthorbook(newBook.getAuthorbook());
                    book.setEditionbook(newBook.getEditionbook());
                    book.setNamebook(newBook.getNamebook());
                    book.setPublishyear(newBook.getPublishyear());
                    return bookRepository.save(book);
                }).orElseThrow(()->new BookNotFoundException(id));
    }

    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
        return "El libro con el id " +id+ " ha sido borrado del sistema";
    }

}
