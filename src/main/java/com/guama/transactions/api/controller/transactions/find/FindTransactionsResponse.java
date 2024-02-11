package com.guama.transactions.api.controller.transactions.find;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.TransactionsPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find transactions response
 */
@AllArgsConstructor
@Getter
@Builder
@ToString
public class FindTransactionsResponse implements Serializable {
  private static final long serialVersionUID = 5678296293453211683L;

  private int pageNumber;
  private int totalPages;
  private long pageSize;
  @JsonProperty("totalTransactions")
  private long totalElements;
  @JsonProperty("isFirst")
  private boolean first;
  @JsonProperty("isLast")
  private boolean last;
  @JsonProperty("isEmpty")
  private boolean empty;
  @JsonProperty("transactions")
  private List<TransactionInfo> elements;

  /**
   * Transaction information
   */
  @AllArgsConstructor
  @Getter
  @Builder
  public static class TransactionInfo implements Serializable {
    private static final long serialVersionUID = 6659192926423006612L;

    private Long id;
    private String name;
    private Double amount;
    private String status;
    private String date;
  }

  /**
   * Method that convert a list TransactionsPage to FindTransactionsResponse
   *
   * @param transactionsPage The transactions page
   * @return A Find Transaction Response
   */
  public static FindTransactionsResponse convertTransactionsPageToTransactionResponse(TransactionsPage transactionsPage) {
    var transactions = transactionsPage.getElements().stream()
      .map((Transaction t) -> TransactionInfo.builder()
        .id(t.getId())
        .name(t.getName())
        .amount(t.getAmount())
        .status(t.getStatus())
        .date(t.getDate().toString().replace("T", " "))
        .build())
      .collect(Collectors.toList());

    return FindTransactionsResponse.builder()
      .pageNumber(transactionsPage.getPageNumber() + 1)
      .totalPages(transactionsPage.getTotalPages())
      .pageSize(transactionsPage.getPageSize())
      .totalElements(transactionsPage.getTotalElements())
      .first(transactionsPage.isFirst())
      .last(transactionsPage.isLast())
      .empty(transactionsPage.isEmpty())
      .elements(transactions)
      .build();
  }
}
