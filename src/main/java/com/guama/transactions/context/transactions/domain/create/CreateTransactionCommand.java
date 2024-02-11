package com.guama.transactions.context.transactions.domain.create;

import com.guama.transactions.context.shared.ICommand;
import com.guama.transactions.context.transactions.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Create transaction command
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class CreateTransactionCommand implements ICommand<Transaction> {
  private String name;
  private Double amount;
  private String status;
  private String date;
}
