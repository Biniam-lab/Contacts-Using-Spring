package com.mydemoproject.contacts.service;

import com.mydemoproject.contacts.model.ContactsModel;
import com.mydemoproject.contacts.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public ContactsModel findContactById(UUID contactId){
        return contactsRepository.findById(contactId).get();
    }

    @Override
    public ContactsModel updateContact(UUID contactId, ContactsModel contactsModel) {
        ContactsModel contactsDB = contactsRepository.findById(contactId).get();

        if(Objects.nonNull(contactsDB.getFirstName()) && !"".equalsIgnoreCase(contactsDB.getFirstName())){
            contactsDB.setFirstName(contactsModel.getFirstName());
        }
        if(Objects.nonNull(contactsDB.getLastName()) && !"".equalsIgnoreCase(contactsDB.getLastName())){
            contactsDB.setLastName(contactsModel.getLastName());
        }
        if(Objects.nonNull(contactsDB.getStreetName()) && !"".equalsIgnoreCase(contactsDB.getStreetName())){
            contactsDB.setStreetName(contactsModel.getStreetName());
        }
        if(Objects.nonNull(contactsDB.getPhoneNumber()) && !"".equalsIgnoreCase(contactsDB.getPhoneNumber())){
            contactsDB.setPhoneNumber(contactsModel.getPhoneNumber());
        }
        if(Objects.nonNull(contactsDB.getHouseNumber()) && contactsDB.getHouseNumber() != 0){
            contactsDB.setPhoneNumber(contactsModel.getPhoneNumber());
        }
        return contactsRepository.save(contactsDB);
    }
}
