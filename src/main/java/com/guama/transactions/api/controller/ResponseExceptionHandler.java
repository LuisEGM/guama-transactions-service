package com.guama.transactions.api.controller;

import com.guama.transactions.context.shared.GuamaTransactionError;
import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;
import com.guama.transactions.context.shared.exceptions.InvalidDateFormatException;
import com.guama.transactions.context.transactions.shared.exceptions.PageNumberCanNotBeLessThanZeroException;
import com.guama.transactions.context.transactions.shared.exceptions.PageSizeCanNotBeLessThanZeroException;
import com.guama.transactions.context.transactions.shared.exceptions.SortDirectionIsInvalidException;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionAmountCanNotBeNullOrLessThanZeroException;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionDateCanNotBeNullOrEmptyException;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionNameCanNotBeNullOrEmptyException;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionNotFound;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionStatusCanNotBeNullOrEmptyAndShouldValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler {

  /**
   * Bad request guama exception handle
   *
   * @param ex A guama transaction exception
   * @return A response entity
   */
  @ExceptionHandler({InvalidDateFormatException.class, PageNumberCanNotBeLessThanZeroException.class,
    PageSizeCanNotBeLessThanZeroException.class, SortDirectionIsInvalidException.class,
    TransactionNameCanNotBeNullOrEmptyException.class, TransactionStatusCanNotBeNullOrEmptyAndShouldValidException.class,
    TransactionAmountCanNotBeNullOrLessThanZeroException.class, TransactionDateCanNotBeNullOrEmptyException.class})
  protected ResponseEntity<GuamaTransactionError> badRequestGuamaExceptionHandle(GuamaTransactionException ex) {
    log.error(ex.getError().getError(), ex);
    return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
  }

  /**
   * Resource not found guama exception handle
   *
   * @param ex A guama transaction exception
   * @return A response entity
   */
  @ExceptionHandler({TransactionNotFound.class})
  protected ResponseEntity<GuamaTransactionError> resourceNotFoundGuamaExceptionHandle(GuamaTransactionException ex) {
    log.error(ex.getError().getError(), ex);
    return new ResponseEntity<>(ex.getError(), HttpStatus.NOT_FOUND);
  }
}
