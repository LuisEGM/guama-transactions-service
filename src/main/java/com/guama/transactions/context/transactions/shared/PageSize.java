package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.IntegerValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.PageSizeCanNotBeLessThanZeroException;

/**
 * The page size value object
 */
public class PageSize extends IntegerValueObject {
  private static final long serialVersionUID = 2708903881096588632L;

  /**
   * Constructor
   *
   * @param value The value
   */
  public PageSize(Integer value) {
    super(value);

    if (value < 0) {
      throw new PageSizeCanNotBeLessThanZeroException();
    }
  }
}
