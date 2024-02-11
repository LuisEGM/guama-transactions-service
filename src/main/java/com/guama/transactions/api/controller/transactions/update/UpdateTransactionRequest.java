package com.guama.transactions.api.controller.transactions.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Update transaction request
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class UpdateTransactionRequest implements Serializable {
  private static final long serialVersionUID = 6612155183189484074L;

  private String name;
  private Double amount;
  private String status;
  private String date;
}
