package com.guama.transactions.context.shared;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Generic value object for double.
 */
@EqualsAndHashCode
public abstract class DoubleValueObject implements Serializable {
  private static final long serialVersionUID = 524137032572988201L;

  protected final Double value;

  /**
   * Constructor
   *
   * @param value The value
   */
  protected DoubleValueObject(Double value) {
    this.value = value;
  }

  /**
   * Get the value
   *
   * @return The value
   */
  public Double value() {
    return value;
  }
}
