package com.contacts.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.contacts.dto.ContactDto;
import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepository;
import com.contacts.search.PageableResult;
import com.contacts.search.SearchCriteria;
import com.contacts.specification.ContactSpecification;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public PageableResult<ContactDto> findContacts(SearchCriteria criteria) {

        PageRequest pagination = PageRequest.of((criteria.getPageNumber()) - 1, criteria.getSize());
        ContactSpecification spec = new ContactSpecification(criteria);
        Page<Contact> contacts = contactRepository.findAll(spec, pagination);

        PageableResult<ContactDto> result = new PageableResult<>();
        result.setTotalPages(contacts.getTotalPages());
        result.setPageNumber(contacts.getNumber() + 1);
        result.setSize(contacts.getSize());
        result.setTotalElements(contacts.getTotalElements());
        result.setResult(contacts.getContent().stream().map(Contact::asDTO).collect(Collectors.toList()));

        return result;
    }

    @Override
    public Contact saveContact(ContactDto contact) {
        return contactRepository.save(contact.asEntity());
    }

}
