package com.ncuindia.peermentoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.service.UserDetailsService;

@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsService uDetailsService;

    public UserDetailsController(UserDetailsService uDetailsService) {
        super();
        this.uDetailsService = uDetailsService;
    }

    // build create employee REST API
	@PostMapping()
    public ResponseEntity<UserDetails> saveUserDetails(@RequestBody UserDetails uDetails){
        return new ResponseEntity<UserDetails>(uDetailsService.saveUserDetails(uDetails),HttpStatus.CREATED);
    }
	
	// build get all employees REST API
	@GetMapping()
	public List<UserDetails> getAllUserDetails(){
		return uDetailsService.getAllUserDetails();
	}

    @GetMapping("{id}")
    public ResponseEntity<UserDetails> getUDetailsById(@PathVariable("id") String UserId){
        return new ResponseEntity<UserDetails>(uDetailsService.getUserDetailsById(UserId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDetails> updateUDetails(@PathVariable("id") String UserId
                                                   , @RequestBody UserDetails uDetails){
        return new ResponseEntity<UserDetails>(uDetailsService.updateUserDetails(uDetails, UserId),HttpStatus.OK);
                                                    }

    @DeleteMapping("{id}")
    public void deleteUDetails(@PathVariable("id") String id){
        uDetailsService.deleteUser(id);
    }
    
}
