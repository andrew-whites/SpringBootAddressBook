package com.example.addressBook.service;

import com.example.addressBook.consts.HttpResponseConst;
import com.example.addressBook.entities.EntryEntity;
import com.example.addressBook.models.Address;
import com.example.addressBook.models.ContactInfo;
import com.example.addressBook.models.Entry;
import com.example.addressBook.repositorys.JpaEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    JpaEntryRepository jpaEntryRepository;

    public ResponseEntity getAll(){
        return ResponseEntity.ok(entityListToEntryList(jpaEntryRepository.findAll()));
    }

    public ResponseEntity getEntryById(Integer id){
        if(entryExists(id)){
            return ResponseEntity.ok(entityToEntry(jpaEntryRepository.findById(id).get()));
        }
        return new ResponseEntity<String>(HttpResponseConst.NO_ENTRY_FOR_ID + id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity post(EntryEntity newEntry){
        return ResponseEntity.ok(jpaEntryRepository.save(newEntry));
    }

    public ResponseEntity updateEntry(@RequestBody EntryEntity updatedEntry, Integer id){
        if (entryExists(id)){
            return ResponseEntity.ok(
                    jpaEntryRepository.save(
                            jpaEntryRepository.findById(id).get().
                                    updateEntry(updatedEntry)));
        }else{
            updatedEntry.setId(id);
            return this.post(updatedEntry);
        }
    }

    public ResponseEntity deleteEntry(Integer id){
        jpaEntryRepository.deleteById(id);
        return ResponseEntity.ok(HttpResponseConst.ENTRY_DELETED);
    }

    public ResponseEntity getContactInfoById(Integer id) {
        if(entryExists(id)){
            return ResponseEntity.ok(getContactInfoFromEntryEntity(jpaEntryRepository.findById(id).get()));
        }
        return new ResponseEntity<String>(HttpResponseConst.NO_ENTRY_FOR_ID + id, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity getAddressById(Integer id) {
        if(entryExists(id)){
            return ResponseEntity.ok(getAddressFromEntryEntity(jpaEntryRepository.findById(id).get()));
        }
        return new ResponseEntity<String>(HttpResponseConst.NO_ENTRY_FOR_ID + id, HttpStatus.NOT_FOUND);
    }

    private Entry entityToEntry(EntryEntity entryEntity){
        return new Entry(entryEntity);
    }

    private List<Entry> entityListToEntryList(List<EntryEntity> entities){
        return entities.stream().map(e -> new Entry(e)).collect(Collectors.toList());
    }

    private boolean entryExists(Integer id){
        return jpaEntryRepository.findById(id).isPresent();
    }

    private ContactInfo getContactInfoFromEntryEntity(EntryEntity entry){
        return new ContactInfo(entry);
    }

    private Address getAddressFromEntryEntity(EntryEntity entry){
        return new Address(entry);
    }
}
