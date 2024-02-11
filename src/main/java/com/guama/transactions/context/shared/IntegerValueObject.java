package com.guama.transactions.context.shared;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Generic value object for integer.
 */
@EqualsAndHashCode
public abstract class IntegerValueObject implements Serializable {
  private static final long serialVersionUID = 524137032572988201L;

  protected final Integer value;

  /**
   * Constructor
   *
   * @param value The value
   */
  protected IntegerValueObject(Integer value) {
    this.value = value;
  }

  /**
   * Get the value
   *
   * @return The value
   */
  public Integer value() {
    return value;
  }
}
