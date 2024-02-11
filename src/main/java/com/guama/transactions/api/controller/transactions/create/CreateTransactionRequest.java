package com.guama.transactions.api.controller.transactions.create;

import com.guama.transactions.context.transactions.domain.create.CreateTransactionCommand;
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
public class CreateTransactionRequest implements Serializable {
  private static final long serialVersionUID = 6260563161845101962L;

  private String name;
  private Double amount;
  private String status;
  private String date;
}
