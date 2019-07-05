package com.example.addressBook.repositorys;

import com.example.addressBook.entities.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEntryRepository extends JpaRepository<EntryEntity, Integer> {
}
