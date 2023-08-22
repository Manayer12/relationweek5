package com.example.week5relations.Repository;

import com.example.week5relations.Model.Branche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends JpaRepository<Branche,Integer> {
    Branche findBranchesById(Integer id);
}
