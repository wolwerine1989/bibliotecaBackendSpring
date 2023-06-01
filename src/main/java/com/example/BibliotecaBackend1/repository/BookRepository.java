package com.example.BibliotecaBackend1.repository;

import com.example.BibliotecaBackend1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
