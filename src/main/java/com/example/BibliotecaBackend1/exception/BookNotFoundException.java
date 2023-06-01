package com.example.BibliotecaBackend1.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id){
        super("No se ha podido encontrar el usuario con el codigo " + id + "Error 404");
    }

}
