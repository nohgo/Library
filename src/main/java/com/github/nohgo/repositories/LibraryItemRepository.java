package com.github.nohgo.repositories;

import com.github.nohgo.models.LibraryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryItemRepository extends JpaRepository<LibraryItem, Integer>{
    List<LibraryItem> findAll();
    LibraryItem save(LibraryItem libraryItem);
    Optional<LibraryItem> findByTitle(String title);
    List<LibraryItem> findByIsBorrowed(Boolean isBorrowed);
    void delete(LibraryItem libraryItem);

}
