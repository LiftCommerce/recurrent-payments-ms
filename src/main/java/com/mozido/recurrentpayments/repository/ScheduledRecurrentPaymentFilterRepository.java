package com.mozido.recurrentpayments.repository;

import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.repository.Filters.ScheduledRecurrentPaymentFilter;
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
public class ScheduledRecurrentPaymentFilterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<ScheduledRecurrentPayment> findByFilters(
            ScheduledRecurrentPaymentFilter filter,
            Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<ScheduledRecurrentPayment> cq = cb.createQuery(ScheduledRecurrentPayment.class);
        Root<ScheduledRecurrentPayment> root = cq.from(ScheduledRecurrentPayment.class);

        List<Predicate> predicates = buildPredicates(cb, root, filter);
        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(root.get("startDate")));

        TypedQuery<ScheduledRecurrentPayment> query = entityManager.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<ScheduledRecurrentPayment> countRoot = countQuery.from(ScheduledRecurrentPayment.class);
        List<Predicate> countPredicates = buildPredicates(cb, countRoot, filter);
        countQuery.select(cb.count(countRoot)).where(countPredicates.toArray(new Predicate[0]));

        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(query.getResultList(), pageable, total);
    }

    private List<Predicate> buildPredicates(
            CriteriaBuilder cb,
            Root<ScheduledRecurrentPayment> root,
            ScheduledRecurrentPaymentFilter filter) {

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getTenantName() != null)
            predicates.add(cb.equal(root.get("tenantName"), filter.getTenantName()));

        if (filter.getUserId() != null)
            predicates.add(cb.equal(root.get("userId"), filter.getUserId()));

        if (filter.getSvaId() != null)
            predicates.add(cb.equal(root.get("svaId"), filter.getSvaId()));

        if (filter.getBasketId() != null)
            predicates.add(cb.equal(root.get("basketId"), filter.getBasketId()));

        if (filter.getUsername() != null)
            predicates.add(cb.equal(root.get("username"), filter.getUsername()));

        if (filter.getCompanyCode() != null)
            predicates.add(cb.equal(root.get("companyCode"), filter.getCompanyCode()));

        if (filter.getAmount() != null)
            predicates.add(cb.equal(root.get("amount"), filter.getAmount()));

        if (filter.getStartDate() != null)
            predicates.add(cb.equal(root.get("startDate"), filter.getStartDate()));

        if (filter.getEndDate() != null)
            predicates.add(cb.equal(root.get("endDate"), filter.getEndDate()));

        if (filter.getEndAfter() != null && filter.getEndAfter() > 0)
            predicates.add(cb.equal(root.get("endAfter"), filter.getEndAfter()));

        if (filter.getType() != null)
            predicates.add(cb.equal(root.get("type"), filter.getType()));

        if (filter.getPaymentTransactionType() != null)
            predicates.add(cb.equal(root.get("paymentTransactionType"), filter.getPaymentTransactionType()));

        if (filter.getFrequency() != null)
            predicates.add(cb.equal(root.get("frequency"), filter.getFrequency()));

        if (filter.getStatus() != null)
            predicates.add(cb.equal(root.get("status"), filter.getStatus()));

        if (filter.getCancelUserId() != null)
            predicates.add(cb.equal(root.get("cancelUserId"), filter.getCancelUserId()));

        if (filter.getCancelDateTime() != null)
            predicates.add(cb.equal(root.get("cancelDateTime"), filter.getCancelDateTime()));

        if (filter.getUserAccepted() != null)
            predicates.add(cb.equal(root.get("userAccepted"), filter.getUserAccepted()));

        if (filter.getUserDecline() != null)
            predicates.add(cb.equal(root.get("userDecline"), filter.getUserDecline()));

        if (filter.getUserSuppressReminders() != null)
            predicates.add(cb.equal(root.get("userSuppressReminders"), filter.getUserSuppressReminders()));

        if (filter.getPendingSenderApproval() != null)
            predicates.add(cb.equal(root.get("pendingSenderApproval"), filter.getPendingSenderApproval()));

        if (filter.getLastProcessedDate() != null)
            predicates.add(cb.equal(root.get("lastProcessedDate"), filter.getLastProcessedDate()));

        if (filter.getNotes() != null)
            predicates.add(cb.like(root.get("notes"), "%" + filter.getNotes() + "%"));

        if (filter.getCurrencyCode() != null)
            predicates.add(cb.equal(root.get("currencyCode"), filter.getCurrencyCode()));

        return predicates;
    }
}
