package com.guama.transactions.api.controller.transactions.create;

import com.guama.transactions.context.transactions.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Create Transaction Request
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class CreateTransactionResponse implements Serializable {
  private static final long serialVersionUID = -912167604529463786L;

  private Long id;
  private String name;
  private Double amount;
  private String status;
  private String date;

  /**
   * From transaction to create response
   *
   * @param id     The id
   * @param name   The name
   * @param amount The amount
   * @param status The status
   * @param date   The date
   * @return An create transaction response
   */
  public static CreateTransactionResponse toResponse(Transaction transaction) {
    return CreateTransactionResponse.builder()
      .id(transaction.getId())
      .name(transaction.getName())
      .amount(transaction.getAmount())
      .status(transaction.getStatus())
      .date(transaction.getDate().toString())
      .build();
  }
}
