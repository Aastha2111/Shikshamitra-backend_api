package com.ncuindia.peermentoring.service;

import java.util.List;

import com.ncuindia.peermentoring.model.Mentee;

public interface MenteeService {
    // Mentee saveMentee(Mentee mentee,int id);
    Mentee saveMentee(Mentee mentee , int id);
	List<Mentee> getAllMentees();
	// Employee getEmployeeById(long id);
	// Mentee updateEmployee(Mentee employee, class id);
	void deleteMentee(int id);
}
