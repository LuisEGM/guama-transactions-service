package com.guama.transactions.context.transactions.application.find;

import com.guama.transactions.context.shared.IViewHandler;
import com.guama.transactions.context.transactions.domain.TransactionsPage;
import com.guama.transactions.context.transactions.domain.find.FindTransactionsView;
import com.guama.transactions.context.transactions.domain.find.IFindTransactions;

/**
 * Find transactions view handler
 */
public class FindTransactionsViewHandler implements IViewHandler<TransactionsPage, FindTransactionsView> {
  private final IFindTransactions findTransactions;

  /**
   * Constructor
   *
   * @param findTransactions The find transactions implementation
   */
  public FindTransactionsViewHandler(IFindTransactions findTransactions) {
    this.findTransactions = findTransactions;
  }

  @Override
  public TransactionsPage handle(FindTransactionsView findTransactionsView) {
    return findTransactions.execute(findTransactionsView);
  }
}
