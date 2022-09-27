package com.digitalbooks.controller;

import com.digitalbooks.entity.Payment;
import com.digitalbooks.model.BookResponse;
import com.digitalbooks.model.PaymentModel;
import com.digitalbooks.model.PaymentRequest;
import com.digitalbooks.service.DigitalBookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DigitalBookReaderControllerTest {

    @Mock
    DigitalBookService userService;

    @InjectMocks
    DigitalBookReaderController digitalBookReaderController;

    @Test
    public void searchBook() {
        BookResponse bookResponse = new BookResponse("title", "publisher", new Date(), "category", 20l, "author", "content", true);
        List<BookResponse> bookResponseList = new ArrayList<>();
        bookResponseList.add(bookResponse);
        Mockito.when(userService.getBookDetails("category", "author", 20l, "publisher")).thenReturn(bookResponseList);
        ResponseEntity<?> res = digitalBookReaderController.searchBook("category", "author", 20l, "publisher");
        Assert.assertNotNull(res);
    }

    @Test
    public void buyBook() throws Exception {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setBookId(123);
        paymentRequest.setUserId(123);
        Mockito.when(userService.buyBook(paymentRequest)).thenReturn(new Payment(new Date(), null, null));
        ResponseEntity<?> res = digitalBookReaderController.buyBook(paymentRequest);
        Assert.assertNotNull(res);

    }

    @Test
    public void readPaymentDetails() {
        PaymentModel paymentModel = new PaymentModel(12l, new Date(), "abc", 123);
        List<PaymentModel> paymentModels = new ArrayList<>();
        paymentModels.add(paymentModel);
        Mockito.when(userService.getPaymentDetails(123)).thenReturn(paymentModels);
        ResponseEntity<?> paymentDetails = digitalBookReaderController.readPaymentDetails(123);
        Assert.assertNotNull(paymentDetails);
    }

    @Test
    public void readContent() {
        Mockito.when(userService.readContent(123)).thenReturn("content");
        ResponseEntity<?> res = digitalBookReaderController.readContent(123);
        Assert.assertNotNull(res);
    }

    @Test
    public void getPaymentById() {
        PaymentModel paymentModel = new PaymentModel(12l, new Date(), "abc", 123);
        List<PaymentModel> paymentModels = new ArrayList<>();
        paymentModels.add(paymentModel);
        Mockito.when(userService.getPaymentDetailsById(12l)).thenReturn(paymentModel);
        ResponseEntity<?> entity = digitalBookReaderController.getPaymentById(12l);
        Assert.assertNotNull(entity);
    }
}