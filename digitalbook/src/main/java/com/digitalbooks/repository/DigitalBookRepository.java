package com.digitalbooks.repository;

import com.digitalbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DigitalBookRepository extends JpaRepository<Book, Integer> {

}
