package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Size Page Can Not Be Less Than Zero Exception
 */
public class PageSizeCanNotBeLessThanZeroException extends GuamaTransactionException {
  private static final long serialVersionUID = 1664555975943641350L;

  /**
   * Constructor
   */
  public PageSizeCanNotBeLessThanZeroException() {
    super("PageSizeCanNotBeLessThanZeroException", "The page size can't be less than zero", "GUAMA-TS-003", LocalDateTime.now().toString());
  }
}
