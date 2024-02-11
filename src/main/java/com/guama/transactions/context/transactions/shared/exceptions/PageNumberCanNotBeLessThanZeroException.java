package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Page Number Can Not be Less Than Zero Exception
 */
public class PageNumberCanNotBeLessThanZeroException extends GuamaTransactionException {
  private static final long serialVersionUID = 105651019189776132L;

  /**
   * Constructor
   */
  public PageNumberCanNotBeLessThanZeroException() {
    super("PageNumberCanNotBeLessThanZeroException", "The page number can't be less than zero", "GUAMA-TS-002", LocalDateTime.now().toString());
  }
}
