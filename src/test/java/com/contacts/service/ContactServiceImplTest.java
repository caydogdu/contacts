package com.contacts.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.contacts.Application;
import com.contacts.dto.ContactDto;
import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepository;
import com.contacts.search.Filter;
import com.contacts.search.Operator;
import com.contacts.search.PageableResult;
import com.contacts.search.SearchCriteria;
import com.contacts.specification.ContactSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ContactServiceImplTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void findContactsTest() throws Exception {

        Contact contact = new Contact();
        contact.setName("Bart");
        contact.setUrl("url");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);

        Page<Contact> pagedResponse = new PageImpl<>(contacts);

        List<Filter> filters = new ArrayList<>();
        Filter filter = new Filter("name", Operator.CONTAINS, "Bart");
        filters.add(filter);
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPageNumber(1);
        criteria.setSize(10);
        criteria.setFilters(filters);

        PageRequest pagination = PageRequest.of((criteria.getPageNumber()) - 1, criteria.getSize());
        ContactSpecification spec = new ContactSpecification(criteria);

        ContactRepository contactRepository = Mockito.mock(ContactRepository.class);
        Mockito.when(contactRepository.findAll(spec, pagination)).thenReturn(pagedResponse);

        PageableResult<ContactDto> data = contactService.findContacts(criteria);

        assertTrue(data.getResult().size() > 0);

    }

    @Test
    public void saveContactTest() throws Exception {

        Contact contact = new Contact();
        contact.setName("Bart");
        contact.setUrl("url");

        ContactRepository contactRepository = Mockito.mock(ContactRepository.class);
        Mockito.when(contactRepository.save(contact)).thenReturn(contact);

        Contact data = contactService.saveContact(contact.asDTO());

        assertTrue(data.getName().equals(contact.getName()));

    }
}
