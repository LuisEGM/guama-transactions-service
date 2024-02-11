package com.guama.transactions.infrastructure.persistence.repositories;

import com.guama.transactions.infrastructure.persistence.entities.TransactionEntity;
import com.guama.transactions.context.transactions.shared.PageSettings;
import com.guama.transactions.context.transactions.domain.TransactionFilters;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Transaction criteria repository
 */
@Repository
public class TransactionCriteriaRepository {

  private final EntityManager entityManager;
  private final CriteriaBuilder criteriaBuilder;

  /**
   * Constructor
   *
   * @param entityManager The entity manager
   */
  public TransactionCriteriaRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
    this.criteriaBuilder = entityManager.getCriteriaBuilder();
  }

  /**
   * Find all with filters
   *
   * @param transactionFilters The transaction search criteria
   * @param pageSettings       The transaction page
   * @return A page of transaction entities
   */
  public Page<TransactionEntity> findAllWithFilters(TransactionFilters transactionFilters, PageSettings pageSettings) {
    var criteriaQuery = criteriaBuilder.createQuery(Long.class);
    var transactionEntityRoot = criteriaQuery.from(TransactionEntity.class);

    // Count query
    criteriaQuery.select(criteriaBuilder.count(transactionEntityRoot));
    var predicate = getPredicate(transactionFilters, transactionEntityRoot);
    criteriaQuery.where(predicate);

    long totalCount = entityManager.createQuery(criteriaQuery).getSingleResult();

    // Data query
    CriteriaQuery<TransactionEntity> dataQuery = criteriaBuilder.createQuery(TransactionEntity.class);
    transactionEntityRoot = dataQuery.from(TransactionEntity.class);
    predicate = getPredicate(transactionFilters, transactionEntityRoot);
    dataQuery.where(predicate);
    setOrder(pageSettings, dataQuery, transactionEntityRoot);

    var typedQuery = entityManager.createQuery(dataQuery);
    typedQuery.setFirstResult(pageSettings.getPageNumber() * pageSettings.getPageSize());
    typedQuery.setMaxResults(pageSettings.getPageSize());

    var pageable = getPageable(pageSettings);

    return new PageImpl<>(typedQuery.getResultList(), pageable, totalCount);
  }

  /**
   * Get predicate
   *
   * @param transactionFilters    The transaction filters
   * @param transactionEntityRoot The transaction entity root
   * @return A predicate
   */
  private Predicate getPredicate(TransactionFilters transactionFilters, Root<TransactionEntity> transactionEntityRoot) {
    List<Predicate> predicates = new ArrayList<>();

    if (!"".equals(transactionFilters.getName())) {
      predicates.add(criteriaBuilder.like(transactionEntityRoot.get("name"), String.format("%%%s%%", transactionFilters.getName())));
    }

    if (!"".equals(transactionFilters.getStatus())) {
      predicates.add(criteriaBuilder.like(transactionEntityRoot.get("status"), transactionFilters.getStatus()));
    }

    if (Objects.nonNull(transactionFilters.getFromDate()) && Objects.nonNull(transactionFilters.getToDate())) {
      predicates.add(criteriaBuilder.between(transactionEntityRoot.get("date"), transactionFilters.getFromDate(), transactionFilters.getToDate()));
    } else if (Objects.nonNull(transactionFilters.getFromDate())) {
      predicates.add(criteriaBuilder.greaterThanOrEqualTo(transactionEntityRoot.get("date"), transactionFilters.getFromDate()));
    } else if (Objects.nonNull(transactionFilters.getToDate())) {
      predicates.add(criteriaBuilder.lessThanOrEqualTo(transactionEntityRoot.get("date"), transactionFilters.getToDate()));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

  /**
   * Set order
   *
   * @param pageSettings          The page settings
   * @param criteriaQuery         The criteria query
   * @param transactionEntityRoot The transaction entity root
   */
  private void setOrder(PageSettings pageSettings, CriteriaQuery<TransactionEntity> criteriaQuery, Root<TransactionEntity> transactionEntityRoot) {
    if (pageSettings.getSortDirection().equals(Sort.Direction.ASC)) {
      criteriaQuery.orderBy(criteriaBuilder.asc(transactionEntityRoot.get(pageSettings.getSortBy())));
    } else {
      criteriaQuery.orderBy(criteriaBuilder.desc(transactionEntityRoot.get(pageSettings.getSortBy())));
    }
  }

  /**
   * Get pageable
   *
   * @param pageSettings The page settings
   * @return A pageable
   */
  private Pageable getPageable(PageSettings pageSettings) {
    var sort = Sort.by(pageSettings.getSortDirection(), pageSettings.getSortBy());
    return PageRequest.of(pageSettings.getPageNumber(), pageSettings.getPageSize(), sort);
  }
}
