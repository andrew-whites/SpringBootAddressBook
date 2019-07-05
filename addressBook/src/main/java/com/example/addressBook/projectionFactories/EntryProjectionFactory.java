package com.example.addressBook.projectionFactories;

import static com.example.addressBook.entities.QEntryEntity.entryEntity;
import com.example.addressBook.models.Entry;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.MappingProjection;

public class EntryProjectionFactory extends MappingProjection<Entry> {
    public EntryProjectionFactory() {
        super(Entry.class,
                entryEntity.id,
                entryEntity.firstName,
                entryEntity.lastName,
                entryEntity.addressLine1,
                entryEntity.addressLine2,
                entryEntity.addressLine3,
                entryEntity.city,
                entryEntity.county,
                entryEntity.country,
                entryEntity.postalCode,
                entryEntity.phoneNumber,
                entryEntity.emailAddress);
    }

    @Override
    protected Entry map(Tuple row) {
        return new Entry(row.get(entryEntity.id),
                row.get(entryEntity.firstName),
                row.get(entryEntity.lastName),
                row.get(entryEntity.addressLine1),
                row.get(entryEntity.addressLine2),
                row.get(entryEntity.addressLine3),
                row.get(entryEntity.city),
                row.get(entryEntity.county),
                row.get(entryEntity.country),
                row.get(entryEntity.postalCode),
                row.get(entryEntity.phoneNumber), row.get(entryEntity.emailAddress));
    }
}
