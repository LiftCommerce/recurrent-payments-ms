package com.mozido.recurrentpayments.repository;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.repository.Filters.ExecutedScheduledRecurrentPaymentFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ExecutedScheduledRecurrentPaymentFilterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<ExecutedScheduledRecurrentPayment> findByFilters(
            ExecutedScheduledRecurrentPaymentFilter filter,
            Pageable pageable
    ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ExecutedScheduledRecurrentPayment> cq = cb.createQuery(ExecutedScheduledRecurrentPayment.class);
        Root<ExecutedScheduledRecurrentPayment> root = cq.from(ExecutedScheduledRecurrentPayment.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getScheduledRecurrentPaymentId() != null) {
            predicates.add(cb.equal(root.get("scheduledRecurrentPayment").get("id"), filter.getScheduledRecurrentPaymentId()));
        }
        if (filter.getExecutionDate() != null) {
            predicates.add(cb.equal(root.get("executionDate"), filter.getExecutionDate()));
        }
        if (filter.getSuccess() != null) {
            predicates.add(cb.equal(root.get("success"), filter.getSuccess()));
        }
        if (filter.getRetries() != null) {
            predicates.add(cb.equal(root.get("retries"), filter.getRetries()));
        }
        if (filter.getTransactionStatus() != null) {
            predicates.add(cb.equal(root.get("transactionStatus"), filter.getTransactionStatus()));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(root.get("executionDate")));

        TypedQuery<ExecutedScheduledRecurrentPayment> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        // Total para paginación
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<ExecutedScheduledRecurrentPayment> countRoot = countQuery.from(ExecutedScheduledRecurrentPayment.class);
        countQuery.select(cb.count(countRoot)).where(predicates.toArray(new Predicate[0]));
        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(query.getResultList(), pageable, total);
    }
}
