package com.ncuindia.peermentoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncuindia.peermentoring.model.Mentee;
import com.ncuindia.peermentoring.service.MenteeService;

@RestController
@RequestMapping("/api/mentees")
public class MenteeController {

	@Autowired
    private MenteeService menteeService;


    public MenteeController(MenteeService menteeService) {
        super();
        this.menteeService = menteeService;
    }
    
    @PostMapping("{classid}")
	public ResponseEntity<Mentee> saveEmployee(@PathVariable("classid") int id,  @RequestBody Mentee mentee){
		System.out.print("@@@@@"+mentee);
		return new ResponseEntity<Mentee>(menteeService.saveMentee(mentee ,id), HttpStatus.CREATED);
	}
  

    @GetMapping()
	public List<Mentee> getAllEmployees(){
		return menteeService.getAllMentees();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
		
		// delete employee from DB
		menteeService.deleteMentee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
    
}
