package com.digitalbooks.service;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.User;
import com.digitalbooks.exception.DigitalBookException;
import com.digitalbooks.model.BookRequest;
import com.digitalbooks.model.BookResponse;
import com.digitalbooks.repository.DigitalBookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class DigitalBookServiceTest {

    @InjectMocks
    DigitalBookService digitalBookService;

    @Mock
    DigitalBookRepository digitalBookRepository;

    @Test
    public void createBook() throws Exception {
        User user = new User();
        user.setId(123);
        Book book = new Book("title", "publisher", new Date(), "category", 20l, true, user, "content");
        Mockito.when(digitalBookRepository.save(Mockito.any())).thenReturn(book);
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookId(123);
        BookResponse bookResponse = new BookResponse("title", "publisher", new Date(), "category", 20l, "author", "content", true);
        bookRequest.setResponse(bookResponse);
        bookRequest.setUserId(123);
        Book b = digitalBookService.createBook(bookRequest, 123);
        Assert.assertNotNull(b);
    }

    @Test(expected = DigitalBookException.class)
    public void createBookExceptionTest() throws Exception {
        User user = new User();
        user.setId(123);
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookId(123);
        Assert.assertNull(digitalBookService.createBook(bookRequest, 123));
    }

    @Test
    public void updateBookDetails() throws Exception {
        User user = new User();
        user.setId(123);
        Book book = new Book("title", "publisher", new Date(), "category", 20l, true, user, "content");
        Mockito.when(digitalBookRepository.save(Mockito.any())).thenReturn(book);
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookId(123);
        BookResponse bookResponse = new BookResponse("title", "publisher", new Date(), "category", 20l, "author", "content", true);
        bookRequest.setResponse(bookResponse);
        bookRequest.setUserId(123);
        BookResponse bookResponse1 = digitalBookService.updateBookDetails(bookRequest, 123, 123);
        Assert.assertNotNull(bookResponse1);
    }

    @Test(expected = DigitalBookException.class)
    public void updateBookExceptionTest() throws Exception {
        User user = new User();
        user.setId(123);
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBookId(123);
        Assert.assertNull(digitalBookService.updateBookDetails(bookRequest, 123, 123));
    }
}