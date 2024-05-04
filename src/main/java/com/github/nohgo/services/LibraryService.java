package com.github.nohgo.services;

import com.github.nohgo.models.Individual;
import com.github.nohgo.models.LibraryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private IndividualService individualService;
    @Autowired
    private LibraryItemService libraryItemService;

    public void borrowItem(Individual individual, String title) throws Exception{
        LibraryItem item = libraryItemService.findByTitle(title);
        if (item == null) {
            throw new Exception("Item not found");
        }
        if (individual.getItems() != null && individual.hasItem(item)) {
            throw new Exception("Individual already has this item");
        }
        if (item.getIsBorrowed()) {
            throw new Exception("Item is already borrowed");
        }

        item.setIsBorrowed(true);
        item.setBorrower(individual);
        libraryItemService.saveLibraryItem(item);
        individual.borrowItem(item);
        individualService.saveIndividual(individual);

    }

    public void returnItem(Individual individual, String title) throws Exception{
        LibraryItem item = libraryItemService.findByTitle(title);
        if (item == null) {
            throw new Exception("Item not found");
        }
        if (!item.getIsBorrowed()) {
            throw new Exception("Item is not borrowed");
        }
        if (individual.getItems() == null || !individual.hasItem(item)) {
            throw new Exception("Individual does not have this item");
        }

        item.setIsBorrowed(false);
        item.setBorrower(null);
        libraryItemService.saveLibraryItem(item);
        individual.returnItem(item);
        individualService.saveIndividual(individual);
    }
}
