package com.github.nohgo.services;

import com.github.nohgo.repositories.LibraryItemRepository;
import com.github.nohgo.models.LibraryItem;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryItemService {
    @Autowired
    private LibraryItemRepository libraryItemRepository;

    public List<LibraryItem> getAllLibraryItems() {
        return libraryItemRepository.findAll();
    }
    public LibraryItem saveLibraryItem(LibraryItem libraryItem) {
        return libraryItemRepository.save(libraryItem);
    }
    public Optional<LibraryItem> findByTitle(String title) {
        return libraryItemRepository.findByTitle(title);
    }
    public List<LibraryItem> findByIsBorrowed(Boolean isBorrowed) {
        return libraryItemRepository.findByIsBorrowed(isBorrowed);
    }
    public LibraryItem removeByTitle(String title) throws Exception {
        LibraryItem libraryItem = libraryItemRepository.findByTitle(title).orElse(null);
        if (libraryItem == null) {
            throw new Exception("Item not found");
        }

        libraryItemRepository.delete(libraryItem);

        return libraryItem;
    }

}
