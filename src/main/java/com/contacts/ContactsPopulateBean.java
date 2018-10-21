package com.contacts;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.contacts.dto.ContactDto;
import com.contacts.reader.Reader;
import com.contacts.service.ContactService;

@Component
public class ContactsPopulateBean implements InitializingBean {

    @Autowired
    private Reader reader;

    @Autowired
    private ContactService contactService;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ContactDto> contacts = reader.getData("people.csv");
        contacts.forEach(c -> contactService.saveContact(c));
    }
}
