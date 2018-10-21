package com.contacts.service;

import com.contacts.dto.ContactDto;
import com.contacts.entity.Contact;
import com.contacts.search.PageableResult;
import com.contacts.search.SearchCriteria;

public interface ContactService {

    PageableResult<ContactDto> findContacts(SearchCriteria criteria);

    Contact saveContact(ContactDto contact);

}
