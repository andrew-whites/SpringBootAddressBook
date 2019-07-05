package com.example.addressBook.controllers;

import com.example.addressBook.entities.EntryEntity;
import com.example.addressBook.models.Entry;
import com.example.addressBook.models.EntryFilter;
import com.example.addressBook.predicates.EntryPredicate;
import com.example.addressBook.repositorys.EntryRepository;
import com.example.addressBook.service.AddressBookService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class AddressBookController {

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    AddressBookService addressBookService;

    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public List<Entry> getEntries(EntryFilter filter){
        Predicate predicate = new EntryPredicate().build(filter);

        return entryRepository.getListOfEntriesFromPredicate(predicate);
    }

    @RequestMapping(value = "entries/{id}", method = RequestMethod.GET)
    public ResponseEntity getEntryById(@PathVariable Integer id){
        return addressBookService.getEntryById(id);
    }

    @RequestMapping(value = "entries", method = RequestMethod.POST)
    public ResponseEntity createNewEntry(@RequestBody EntryEntity newEntry){
        return addressBookService.post(newEntry);
    }

    @RequestMapping(value = "entries/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateEntryOrCreateEntry(@RequestBody EntryEntity updateEntry, @PathVariable Integer id){
        return addressBookService.updateEntry(updateEntry, id);
    }

    @RequestMapping(value = "entries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEntryId(@PathVariable Integer id){
        return addressBookService.deleteEntry(id);
    }

    @RequestMapping(value = "entries/{id}/contactinfo", method = RequestMethod.GET)
    public ResponseEntity getContactInfoById(@PathVariable Integer id){
        return addressBookService.getContactInfoById(id);
    }

    @RequestMapping(value = "entries/{id}/address", method = RequestMethod.GET)
    public ResponseEntity getAddressById(@PathVariable Integer id){
        return addressBookService.getAddressById(id);
    }
}
