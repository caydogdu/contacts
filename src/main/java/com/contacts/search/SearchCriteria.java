package com.contacts.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchCriteria {

    private List<Sorter> sorters;

    private List<Filter> filters;

    private int pageNumber;

    private int size;

    public SearchCriteria() {
        // default cons
    }

    public SearchCriteria(List<Sorter> sorters, List<Filter> filters, int pageNumber, int size) {
        this.sorters = sorters;
        this.filters = filters;
        this.pageNumber = pageNumber;
        this.size = size;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getSize() {
        return size;
    }

    public List<Sorter> getSorters() {
        return sorters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSorters(List<Sorter> sorters) {
        this.sorters = sorters;
    }

}
