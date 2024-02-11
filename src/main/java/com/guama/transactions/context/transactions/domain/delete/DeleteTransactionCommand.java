package com.guama.transactions.context.transactions.domain.delete;

import com.guama.transactions.context.shared.ICommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Delete transaction command
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class DeleteTransactionCommand implements ICommand<Void> {
  private Long id;
}
