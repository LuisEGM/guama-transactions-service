package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.StringValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.SortDirectionIsInvalidException;

/**
 * Sort direction value object
 */
public class SortDirection extends StringValueObject {
  private static final long serialVersionUID = -5048089209831243382L;

  /**
   * Constructor.
   *
   * @param value the value.
   */
  public SortDirection(String value) {
    super(value.toUpperCase());

    if (!("desc".equalsIgnoreCase(value) || "asc".equalsIgnoreCase(value))) {
      throw new SortDirectionIsInvalidException(value);
    }
  }
}
