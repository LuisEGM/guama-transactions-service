package com.guama.transactions.context.transactions.domain.update;

import com.guama.transactions.context.shared.ICommand;
import com.guama.transactions.context.transactions.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Update transaction command
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UpdateTransactionCommand implements ICommand<Transaction> {
  private Long id;
  private String name;
  private Double amount;
  private String status;
  private String date;
}
