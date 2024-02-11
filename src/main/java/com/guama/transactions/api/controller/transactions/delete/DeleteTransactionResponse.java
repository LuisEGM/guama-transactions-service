package com.guama.transactions.api.controller.transactions.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Delete transaction response
 */
@AllArgsConstructor
@Getter
@Builder
@ToString
public class DeleteTransactionResponse implements Serializable {
  private static final long serialVersionUID = -77516815452121938L;

  private String message;

  /**
   * Method that create a delete transaction response
   *
   * @param id The transaction id
   * @return A delete transaction response
   */
  public static DeleteTransactionResponse create(Long id) {
    return DeleteTransactionResponse.builder()
      .message(String.format("Transaction with id <%d> deleted successfully", id))
      .build();
  }
}
