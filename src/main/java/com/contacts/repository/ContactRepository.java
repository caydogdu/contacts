package com.contacts.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.contacts.entity.Contact;

@Transactional
public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

}
