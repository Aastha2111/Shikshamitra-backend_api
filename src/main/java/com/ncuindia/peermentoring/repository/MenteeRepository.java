package com.ncuindia.peermentoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncuindia.peermentoring.model.Mentee;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Integer>{

}
