package com.guama.transactions.context.transactions.application.find;

import com.guama.transactions.context.transactions.domain.ITransactionService;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.TransactionFilters;
import com.guama.transactions.context.transactions.domain.TransactionsPage;
import com.guama.transactions.context.transactions.domain.find.FindTransactionsView;
import com.guama.transactions.context.transactions.domain.find.IFindTransactions;
import com.guama.transactions.context.transactions.shared.PageSettings;

/**
 * Find transactions use case
 */
public class FindTransactions implements IFindTransactions {

  private final ITransactionService transactionService;

  /**
   * Constructor
   *
   * @param transactionService The transaction service
   */
  public FindTransactions(ITransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public TransactionsPage execute(FindTransactionsView findTransactionsView) {
    var transactionFilters = TransactionFilters.build(findTransactionsView.getFilters());
    var pageSettings = PageSettings.build(findTransactionsView.getPageable());

    var results = transactionService.findTransactions(transactionFilters, pageSettings);
    var transactions = results.getContent().stream().map(Transaction::fromEntity).toList();

    return TransactionsPage.load(
      results.getTotalPages(),
      results.getTotalElements(),
      results.getSize(),
      results.getNumber(),
      !results.getPageable().hasPrevious(),
      transactions
    );
  }
}
