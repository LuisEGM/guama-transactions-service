package com.guama.transactions.context.shared.exceptions;

import com.guama.transactions.context.shared.GuamaTransactionError;
import lombok.Getter;

/**
 * Guama transaction exception
 */
@Getter
public class GuamaTransactionException extends RuntimeException {
  private static final long serialVersionUID = 4190714948241657682L;

  private final GuamaTransactionError error;

  /**
   * Constructor.
   *
   * @param title       the title
   * @param description the description
   * @param code        the error code
   * @param date        the date
   */
  public GuamaTransactionException(String title, String description, String code, String date) {
    this.error = new GuamaTransactionError(title, description, code, date);
  }

  /**
   * Constructor.
   *
   * @param title       the title
   * @param description the description
   * @param code        the error code
   * @param date        the date
   * @param cause       the throwable cause
   */
  public GuamaTransactionException(String title, String description, String code, String date, Throwable cause) {
    super(cause);
    this.error = new GuamaTransactionError(title, description, code, date);
  }

  /**
   * Get Error
   *
   * @return the guama transaction error
   */
  public GuamaTransactionError getError() {
    if (error != null) {
      return error;
    }
    return new GuamaTransactionError("RuntimeException", null, null, null);
  }

  @Override
  public String getMessage() {
    return getError().getDescription();
  }
}
