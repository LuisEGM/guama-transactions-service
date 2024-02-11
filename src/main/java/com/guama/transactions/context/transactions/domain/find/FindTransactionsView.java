package com.guama.transactions.context.transactions.domain.find;

import com.guama.transactions.context.shared.IView;
import com.guama.transactions.context.transactions.domain.TransactionsPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Find transactions view
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class FindTransactionsView implements IView<TransactionsPage> {
  private PageableParameters pageable;
  private FilterParameters filters;

  /**
   * Pageable parameters
   */
  @AllArgsConstructor
  @Getter
  @Builder
  public static class PageableParameters {
    private Integer pageNumber;
    private Integer pageSize;
    private String sort;
    private String sortDirection;
  }

  /**
   * Filter parameters
   */
  @AllArgsConstructor
  @Getter
  @Builder
  public static class FilterParameters {
    private String name;
    private String status;
    private String fromDate;
    private String toDate;
  }
}
