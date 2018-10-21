package com.contacts.search;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageableResult<T> {

    private Long totalElements;

    private int size;

    private int totalPages;

    private int pageNumber;

    @JsonIgnore
    private Collection<T> result;

    public int getPageNumber() {
        return pageNumber;
    }

    public Collection<T> getResult() {
        return result;
    }

    public int getSize() {
        return size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setResult(Collection<T> result) {
        this.result = result;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
