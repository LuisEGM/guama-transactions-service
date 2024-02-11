package com.guama.transactions.context.shared;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Generic vale object of type boolean.
 */
@ToString
@EqualsAndHashCode
public abstract class BooleanValueObject implements Serializable {

  private static final long serialVersionUID = -2602682323170497623L;

  protected final Boolean value;

  /**
   * Constructor
   *
   * @param value the value
   */
  protected BooleanValueObject(Boolean value) {
    this.value = value;
  }

  /**
   * Get the value.
   *
   * @return the value
   */
  public Boolean value() {
    return value;
  }
}
