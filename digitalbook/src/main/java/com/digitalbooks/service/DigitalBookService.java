package com.digitalbooks.service;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.User;
import com.digitalbooks.exception.DigitalBookException;
import com.digitalbooks.model.BookRequest;
import com.digitalbooks.model.BookResponse;
import com.digitalbooks.repository.DigitalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DigitalBookService {

    @Autowired
    DigitalBookRepository bookRepository;


    public Book createBook(BookRequest request, Integer authorId) throws SQLException, DigitalBookException {
        try {
            User user = new User();
            user.setId(authorId);
            Book book = new Book(request.getResponse().getTitle(), request.getResponse().getPublisher(), request.getResponse().getReleaseDate(), request.getResponse().getCategory(),
                    request.getResponse().getPrice(), request.getResponse().getActive(), user, request.getResponse().getContent());
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new DigitalBookException("Exception while persisting into db please try again later");
        }
    }

    public BookResponse updateBookDetails(BookRequest request, Integer authorId, Integer bookId) throws SQLException, DigitalBookException {
        try {
            User user = new User();
            user.setId(authorId);
            Book book = new Book(request.getResponse().getTitle(), request.getResponse().getPublisher(), request.getResponse().getReleaseDate(), request.getResponse().getCategory(),
                    request.getResponse().getPrice(), request.getResponse().getActive(), user, request.getResponse().getContent());
            book.setBookId(bookId);
            bookRepository.save(book);
        } catch (Exception e) {
            throw new DigitalBookException("Exception while persisting into db please try again later");
        }
        return request.getResponse();
    }

}
