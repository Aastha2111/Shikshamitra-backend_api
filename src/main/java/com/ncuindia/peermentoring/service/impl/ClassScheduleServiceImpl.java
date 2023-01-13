package com.ncuindia.peermentoring.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.exception.ResourceNotFoundException;
import com.ncuindia.peermentoring.model.ClassSchedule;
import com.ncuindia.peermentoring.repository.ClassScheduleRepository;
import com.ncuindia.peermentoring.service.ClassScheduleService;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService{
    private ClassScheduleRepository classScheduleRepository;
    public ClassScheduleServiceImpl(ClassScheduleRepository classScheduleRepository) {
        this.classScheduleRepository = classScheduleRepository;
    }
    

    @Override
    public ClassSchedule save(ClassSchedule classSchedule) {
        // TODO Auto-generated method stub
        return classScheduleRepository.save(classSchedule);
    }

    @Override
    public List<ClassSchedule> get() {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAll();
    }

    @Override
    public ClassSchedule getClassScheduleById(Integer id) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Class Schedule", "Id", classScheduleRepository));
    }

    @Override
    public ClassSchedule updateClassScheduleById(Integer id, ClassSchedule classSchedule) {
        // TODO Auto-generated method stub
        classSchedule.setClassId(id);
        return classScheduleRepository.save(classSchedule);
    }

    @Override
    public boolean deleteClassScheduleById(Integer id) {
        // TODO Auto-generated method stub
        ClassSchedule classSchedule = getClassScheduleById(id);
        classScheduleRepository.delete(classSchedule);
        if(classScheduleRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleByDataTime(Date min, Date max) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleByDataTime(min, max);
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleByDuration(Integer min, Integer max) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleByDuration(min, max);
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleByPeerTutor(String peerTutor) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleByPeerTutor(peerTutor);
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleBySchoolName(String schoolName) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleBySchoolName(schoolName);
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleByTopicName(String topicName) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleByTopicName(topicName);
    }

    @Override
    public List<ClassSchedule> getAllClassScheduleByTopicContext(String topicContext) {
        // TODO Auto-generated method stub
        return classScheduleRepository.findAllClassScheduleByTopicContext(topicContext);
    }
    
}
