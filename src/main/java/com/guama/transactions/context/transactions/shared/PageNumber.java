package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.IntegerValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.PageNumberCanNotBeLessThanZeroException;

/**
 * The page number value object
 */
public class PageNumber extends IntegerValueObject {
  private static final long serialVersionUID = -3311549091361459186L;

  /**
   * Constructor
   *
   * @param value The value
   */
  public PageNumber(Integer value) {
    super(value);

    if (value < 0) {
      throw new PageNumberCanNotBeLessThanZeroException();
    }
  }
}
