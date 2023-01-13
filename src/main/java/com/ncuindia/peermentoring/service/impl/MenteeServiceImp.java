package com.ncuindia.peermentoring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.exception.ResourceNotFoundException;
import com.ncuindia.peermentoring.model.Mentee;
import com.ncuindia.peermentoring.repository.MenteeRepository;
import com.ncuindia.peermentoring.service.MenteeService;

@Service
public class MenteeServiceImp implements MenteeService {
    @Autowired
    private MenteeRepository menteeRepository;

    @Override
    public Mentee saveMentee(Mentee mentee, int id) {
    // public Mentee saveMentee(Mentee mentee) {
        // TODO Auto-generated method stub
        mentee.setClassId(id);
        return menteeRepository.save(mentee);
    }

    @Override
    public List<Mentee> getAllMentees() {
        // TODO Auto-generated method stub
        return menteeRepository.findAll();
    }

    @Override
    public void deleteMentee(int id) {
        // TODO Auto-generated method stub
        menteeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mentee", "Id", id));
        menteeRepository.deleteById(id);

    }

}
