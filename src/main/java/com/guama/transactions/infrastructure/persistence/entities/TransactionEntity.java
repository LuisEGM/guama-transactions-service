package com.guama.transactions.infrastructure.persistence.entities;

import com.guama.transactions.context.transactions.domain.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Transaction entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "transactions")
public class TransactionEntity implements Serializable {
  private static final long serialVersionUID = -6954061421808405694L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "name", length = 250)
  private String name;
  @Column(name = "amount")
  private Double amount;
  @Column(name = "status", length = 50)
  private String status;
  @Column(name = "date")
  private LocalDateTime date;

  /**
   * Method that convert a Transaction to TransactionEntity
   *
   * @param transaction The transaction
   * @return a transaction entity
   */
  public static TransactionEntity fromTransaction(Transaction transaction) {
    return TransactionEntity.builder()
      .id(transaction.getId())
      .name(transaction.getName())
      .amount(transaction.getAmount())
      .status(transaction.getStatus())
      .date(transaction.getDate())
      .build();
  }
}
