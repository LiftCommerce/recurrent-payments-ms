package com.mozido.recurrentpayments.model.response;

import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import org.springframework.data.domain.Page;

import java.util.List;

public class RecurrentPaymentsPageResponse {
    private List<ScheduledRecurrentPayment> RecurrentPayments;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

    public RecurrentPaymentsPageResponse(Page<ScheduledRecurrentPayment> page) {
        this.RecurrentPayments = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.first = page.isFirst();
        this.last = page.isLast();
    }

    // ✅ Getters y setters (necesarios para que Jackson serialice el JSON)
    public List<ScheduledRecurrentPayment> getRecurrentPayments() {
        return RecurrentPayments;
    }

    public void setRecurrentPayments(List<ScheduledRecurrentPayment> recurrentPayments) {
        RecurrentPayments = recurrentPayments;
    }

    public int getPageNumber() { return pageNumber; }
    public void setPageNumber(int pageNumber) { this.pageNumber = pageNumber; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public long getTotalElements() { return totalElements; }
    public void setTotalElements(long totalElements) { this.totalElements = totalElements; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }

    public boolean isFirst() { return first; }
    public void setFirst(boolean first) { this.first = first; }

    public boolean isLast() { return last; }
    public void setLast(boolean last) { this.last = last; }
}