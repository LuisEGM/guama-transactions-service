package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Sort Direction Is Invalid Exception
 */
public class SortDirectionIsInvalidException extends GuamaTransactionException {
  private static final long serialVersionUID = -3280427322737556490L;

  /**
   * Constructor
   *
   * @param sortDirection The sort direction
   */
  public SortDirectionIsInvalidException(String sortDirection) {
    super("SortDirectionIsInvalidException", String.format("The sort direction %s isn't valid direction, use asc or desc", sortDirection), "GUAMA-TS-004", LocalDateTime.now().toString());
  }
}
