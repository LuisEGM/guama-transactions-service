package com.guama.transactions.context.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * Guama transaction error
 */
@AllArgsConstructor
@Builder
@Getter
public class GuamaTransactionError implements Serializable {
  private static final long serialVersionUID = 16952900837455337L;

  private final String error;
  private final String description;
  private final String code;
  private final String date;
}
