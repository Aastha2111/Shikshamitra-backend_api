package com.ncuindia.peermentoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncuindia.peermentoring.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,String> {
    
}
