package com.guama.transactions.context.transactions.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Transactions page
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TransactionsPage {
  private static final int ONE_VALUE = 1;
  private static final int ZERO_VALUE = 0;

  private int totalPages;
  private long totalElements;
  private long pageSize;
  private int pageNumber;
  private boolean first;
  private boolean last;
  private boolean empty;
  private List<Transaction> elements;

  /**
   * Load method
   *
   * @param totalPages    The total pages
   * @param totalElements The total elements
   * @param pageSize      The page size
   * @param pageNumber    The page number
   * @param first         Is the first page
   * @param elements      The elements
   * @return A transactions page
   */
  public static TransactionsPage load(
    int totalPages,
    long totalElements,
    long pageSize,
    int pageNumber,
    boolean first,
    List<Transaction> elements
  ) {
    return new TransactionsPage(
      totalPages,
      totalElements,
      pageSize,
      pageNumber,
      first,
      pageNumber == (totalPages - ONE_VALUE),
      totalElements == ZERO_VALUE,
      elements
    );
  }
}
