package com.ncuindia.peermentoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.exception.ResourceNotFoundException;
import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.repository.UserDetailsRepository;
import com.ncuindia.peermentoring.service.UserDetailsService;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserDetailsRepository  uDetailsRepository;

    public UserDetailsServiceImp(UserDetailsRepository uDetailsRepository) {
        super();
        this.uDetailsRepository = uDetailsRepository;
    }

    @Override
    public UserDetails saveUserDetails(UserDetails uDetails) {
        // TODO Auto-generated method stub
        return uDetailsRepository.save(uDetails);
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        // TODO Auto-generated method stub
        return uDetailsRepository.findAll();
    }

    @Override
    public UserDetails getUserDetailsById(String id) {
        // TODO Auto-generated method stub
        return uDetailsRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("UserDetails", "Id", id));
		
    }

    @Override
    public UserDetails updateUserDetails(UserDetails uDetails, String id) {
        // TODO Auto-generated method stub
        UserDetails existingUDetails = uDetailsRepository.findById(id).orElseThrow(() -> 
                                    new ResourceNotFoundException("UserDetails", "Id", id));
       if(uDetails.getName()!= null){
        existingUDetails.setName(uDetails.getName());
        }
        if(uDetails.getEmailId()!= null){
        existingUDetails.setEmailId(uDetails.getEmailId());
        }
        if(uDetails.getProfilePic()!= null){
        existingUDetails.setProfilePic(uDetails.getProfilePic());
        }
        if(uDetails.getProfilePic()!= null){        
        existingUDetails.setBranch(uDetails.getBranch());
        }
        if(uDetails.getCourse()!= null){
        existingUDetails.setCourse(uDetails.getCourse());
        }
        if(uDetails.getYear()!= null){
        existingUDetails.setYear(uDetails.getYear());
        }
        if(uDetails.getDob()!= null){
        existingUDetails.setDob(uDetails.getDob());
        }
        if(uDetails.getPhone()!= null){
        existingUDetails.setPhone(uDetails.getPhone());
        }
        if(uDetails.getCgpa()!= null){
        existingUDetails.setCgpa(uDetails.getCgpa());
        }
        // if(uDetails.getIsVerified()!= null){
        // existingUDetails.setIsVerified(uDetails.getIsVerified());
        // }

        uDetailsRepository.save(existingUDetails);
        return existingUDetails;
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        uDetailsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("UserDetails", "Id", id));
        uDetailsRepository.deleteById(id);
    }
    
}
