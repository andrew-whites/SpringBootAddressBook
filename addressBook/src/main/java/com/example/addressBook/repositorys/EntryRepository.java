package com.example.addressBook.repositorys;

import com.example.addressBook.entities.QEntryEntity;
import com.example.addressBook.models.Entry;
import com.example.addressBook.projectionFactories.EntryProjectionFactory;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EntryRepository{

    @PersistenceContext
    private EntityManager em;

    public List<Entry> getListOfEntriesFromPredicate(Predicate predicate){
        JPAQuery query = new JPAQuery(em);

        QEntryEntity qEntryEntity = QEntryEntity.entryEntity;
        query.select(new EntryProjectionFactory())
                .from(qEntryEntity)
                .where(predicate);
        return query.fetch();
    }
}
