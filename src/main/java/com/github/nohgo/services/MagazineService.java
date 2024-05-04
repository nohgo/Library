package com.github.nohgo.services;

import com.github.nohgo.models.Magazine;
import com.github.nohgo.repositories.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineService {
    @Autowired
    private MagazineRepository MagazineRepository;

    public List<Magazine> getAllMagazines() {
        return MagazineRepository.findAll();
    }
    public List<Magazine> findAllMagazinesByIssueNumber(int issueNumber) {
        return MagazineRepository.findAllByIssueNumber(issueNumber);
    }
    public List<Magazine> findAllMagazinesByIsBorrowed(Boolean isBorrowed) {
        return MagazineRepository.findAllByIsBorrowed(isBorrowed);
    }
    public List<Magazine> findAllMagazinesByTitle(String title) {
        return MagazineRepository.findAllByTitle(title);
    }



}
