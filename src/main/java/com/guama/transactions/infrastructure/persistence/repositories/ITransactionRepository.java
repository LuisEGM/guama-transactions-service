package com.guama.transactions.infrastructure.persistence.repositories;

import com.guama.transactions.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Transaction repository interface
 */
@Repository
public interface ITransactionRepository extends CrudRepository<TransactionEntity, Long> {
}
