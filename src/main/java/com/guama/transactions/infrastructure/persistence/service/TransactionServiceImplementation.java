package com.guama.transactions.infrastructure.persistence.service;

import com.guama.transactions.context.transactions.domain.ITransactionService;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.shared.PageSettings;
import com.guama.transactions.context.transactions.domain.TransactionFilters;
import com.guama.transactions.infrastructure.persistence.entities.TransactionEntity;
import com.guama.transactions.infrastructure.persistence.repositories.ITransactionRepository;
import com.guama.transactions.infrastructure.persistence.repositories.TransactionCriteriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Transaction service implementation
 */
@Service
public class TransactionServiceImplementation implements ITransactionService {

  private final TransactionCriteriaRepository transactionCriteriaRepository;
  private final ITransactionRepository transactionRepository;

  /**
   * Constructor
   *
   * @param transactionCriteriaRepository The transaction criteria repository
   * @param transactionRepository         The transaction repository
   */
  public TransactionServiceImplementation(TransactionCriteriaRepository transactionCriteriaRepository, ITransactionRepository transactionRepository) {
    this.transactionCriteriaRepository = transactionCriteriaRepository;
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Page<TransactionEntity> findTransactions(TransactionFilters transactionFilters, PageSettings pageSettings) {
    return transactionCriteriaRepository.findAllWithFilters(transactionFilters, pageSettings);
  }

  @Override
  public TransactionEntity createOrUpdateTransaction(Transaction transaction) {
    var transactionEntity = TransactionEntity.fromTransaction(transaction);
    return transactionRepository.save(transactionEntity);
  }

  @Override
  public boolean existsTransaction(Long id) {
    return transactionRepository.findById(id).isPresent();
  }

  @Override
  public void deleteTransaction(Long id) {
    transactionRepository.deleteById(id);
  }
}
