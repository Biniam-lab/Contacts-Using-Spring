package com.mydemoproject.contacts.service;

import com.mydemoproject.contacts.error.ContactNotFoundException;
import com.mydemoproject.contacts.model.ContactsModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ContactsService {

   ContactsModel saveContacts(ContactsModel contactsModel);

   List<ContactsModel> findContacts();

   ContactsModel findContactById(UUID contactId) throws ContactNotFoundException;
}
