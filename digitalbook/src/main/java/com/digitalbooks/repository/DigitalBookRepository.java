package com.digitalbooks.repository;

import com.digitalbooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DigitalBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b FROM Book b where b.category=?1 and b.user.username=?2 and b.price=?3 and b.publisher=?4 and b.activeFlag=1")
    public List<Book> getBookDetails(String category, String author, Long price, String publisher);
}
