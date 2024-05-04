package com.github.nohgo.services;

import com.github.nohgo.repositories.LibraryItemRepository;
import com.github.nohgo.models.LibraryItem;

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
    public LibraryItem findByTitle(String title) {
        return libraryItemRepository.findByTitle(title).orElse(null);
    }
    public List<LibraryItem> findByIsBorrowed(Boolean isBorrowed) {
        return libraryItemRepository.findByIsBorrowed(isBorrowed);
    }
    public LibraryItem findById(int id) {
        return libraryItemRepository.findById(id).orElse(null);
    }

}
