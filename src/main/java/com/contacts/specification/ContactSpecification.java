package com.contacts.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.contacts.entity.Contact;
import com.contacts.search.Operator;
import com.contacts.search.SearchCriteria;
import com.contacts.search.Sorter;

public class ContactSpecification implements Specification<Contact> {

    private static final long serialVersionUID = 1L;

    private transient SearchCriteria criteria;

    public ContactSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate predicate = cb.conjunction();

        if (criteria.getFilters() != null) {
            for (com.contacts.search.Filter filter : criteria.getFilters()) {

                if (root.get(filter.getKey()).getJavaType() == String.class) {
                    if (filter.getOperator() == Operator.EQ) {
                        predicate = cb.and(predicate, cb.equal(root.get(filter.getKey()), filter.getValue()));
                    } else if (filter.getOperator() == Operator.NEQ) {
                        predicate = cb.and(predicate, cb.notEqual(root.get(filter.getKey()), filter.getValue()));
                    } else if (filter.getOperator() == Operator.CONTAINS) {
                        predicate =
                                cb.and(predicate, cb.like(root.get(filter.getKey()), "%" + filter.getValue() + "%"));
                    }
                }
            }
        }

        List<Order> orderList = new ArrayList<>();

        if (criteria.getSorters() != null) {
            for (Sorter sorter : criteria.getSorters()) {
                if (sorter.getDir().equals("desc")) {
                    orderList.add(cb.desc(root.get(sorter.getKey())));
                } else if (sorter.getDir().equals("asc")) {
                    orderList.add(cb.asc(root.get(sorter.getKey())));
                }
            }
        }

        return predicate;
    }
}