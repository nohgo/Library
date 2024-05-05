package com.github.nohgo.services;

import com.github.nohgo.repositories.LibraryItemRepository;
import com.github.nohgo.models.LibraryItem;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<LibraryItem> findByTitle(String title) {
        return libraryItemRepository.findByTitle(title);
    }
    public List<LibraryItem> findByIsBorrowed(Boolean isBorrowed) {
        return libraryItemRepository.findByIsBorrowed(isBorrowed);
    }
    public List<LibraryItem> removeByTitle(String title) throws Exception {
        List<LibraryItem> libraryItem = libraryItemRepository.findByTitle(title);
        if (libraryItem == null) {
            throw new Exception("Item not found");
        }

        libraryItemRepository.deleteAll(libraryItem);

        return libraryItem;
    }

}
