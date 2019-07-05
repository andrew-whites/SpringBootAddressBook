package com.example.addressBook.predicates;

import com.example.addressBook.entities.QEntryEntity;
import com.example.addressBook.models.EntryFilter;
import com.querydsl.core.types.Predicate;

public class EntryPredicate {

    private QEntryEntity qEntryEntity = QEntryEntity.entryEntity;

    public Predicate build(EntryFilter entryFilter){
        return new OptionalBooleanBuilder(qEntryEntity.isNotNull())
                .notEmptyAnd(qEntryEntity.firstName::equalsIgnoreCase, entryFilter.getFirstName())
                .notEmptyAnd(qEntryEntity.lastName::equalsIgnoreCase, entryFilter.getLastName())
                .notEmptyAnd(qEntryEntity.city::equalsIgnoreCase, entryFilter.getCity())
                .build();
    }
}
