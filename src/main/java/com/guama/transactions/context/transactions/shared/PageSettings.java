package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.transactions.domain.find.FindTransactionsView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

/**
 * Page settings
 */
@AllArgsConstructor
@Getter
@Setter
public class PageSettings {
  private int pageNumber;
  private int pageSize;
  private Sort.Direction sortDirection;
  private String sortBy;

  /**
   * Build method
   *
   * @param pageableParameters The pageable parameters
   * @return A PageSettings
   */
  public static PageSettings build(FindTransactionsView.PageableParameters pageableParameters) {
    var pageNumber = new PageNumber(pageableParameters.getPageNumber());
    var pageSize = new PageSize(pageableParameters.getPageSize());
    var sort = new SortDirection(pageableParameters.getSortDirection());

    var sortDirection = Sort.Direction.fromString(sort.value());
    return new PageSettings(pageNumber.value(), pageSize.value(), sortDirection, pageableParameters.getSort());
  }
}
