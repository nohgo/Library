package com.github.nohgo.repositories;

import com.github.nohgo.models.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagazineRepository extends JpaRepository<Magazine, Integer> {
    List<Magazine> findAllByIssueNumber(int issueNumber);
    List<Magazine> findAll();
    List<Magazine> findAllByIsBorrowed(Boolean isBorrowed);
    List<Magazine> findAllByTitle(String title);
}
