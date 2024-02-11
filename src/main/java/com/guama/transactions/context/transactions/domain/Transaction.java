package com.guama.transactions.context.transactions.domain;

import com.guama.transactions.infrastructure.persistence.entities.TransactionEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Transaction class domain
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {
  private Long id;
  private String name;
  private Double amount;
  private String status;
  private LocalDateTime date;

  public static Transaction build(String name, Double amount, String status, LocalDateTime date) {
    return new Transaction(null, name, amount, status, date);
  }

  public static Transaction load(Long id, String name, Double amount, String status, LocalDateTime date) {
    return new Transaction(id, name, amount, status, date);
  }

  public static Transaction fromEntity(TransactionEntity transactionEntity) {
    return Transaction.load(
      transactionEntity.getId(),
      transactionEntity.getName(),
      transactionEntity.getAmount(),
      transactionEntity.getStatus(),
      transactionEntity.getDate()
    );
  }
}
