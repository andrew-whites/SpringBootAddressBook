package com.example.addressBook;

import com.example.addressBook.models.EntryFilter;
import com.example.addressBook.predicates.EntryPredicate;
import com.querydsl.core.types.Predicate;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EntryPredicateTest {

    @Test
    public void testFiltersAreAddedToPredicate(){
        EntryFilter filters = new EntryFilter("Test", "Data", "City");
        Predicate test = new EntryPredicate().build(filters);

        assertTrue(test.toString().contains("eqIc(entryEntity.firstName,Test)"));
        assertTrue(test.toString().contains("eqIc(entryEntity.lastName,Data)"));
        assertTrue(test.toString().contains("eqIc(entryEntity.city,City)"));
    }
}
