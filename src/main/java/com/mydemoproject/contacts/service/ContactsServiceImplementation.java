package com.mydemoproject.contacts.service;

import com.mydemoproject.contacts.error.ContactNotFoundException;
import com.mydemoproject.contacts.model.ContactsModel;
import com.mydemoproject.contacts.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContactsServiceImplementation implements ContactsService{

    @Autowired
    private ContactsRepository contactsRepository;
    @Override
    public ContactsModel saveContacts(ContactsModel contactsModel) {
        return contactsRepository.save(contactsModel);
    }

    @Override
    public List<ContactsModel> findContacts() {
        return contactsRepository.findAll();
    }

    @Override
    public ContactsModel findContactById(UUID contactId) throws ContactNotFoundException {
        Optional<ContactsModel> contactsModel = contactsRepository.findById(contactId);
        if(contactsModel.isPresent())
            return  contactsModel.get();
        else
            throw new ContactNotFoundException("No contact available");


    }
}
