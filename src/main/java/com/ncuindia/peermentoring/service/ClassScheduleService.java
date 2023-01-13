package com.ncuindia.peermentoring.service;

import java.sql.Date;
import java.util.List;

import com.ncuindia.peermentoring.model.ClassSchedule;



public interface ClassScheduleService {
    public ClassSchedule save(ClassSchedule classSchedule);
    public List<ClassSchedule> get();
    public ClassSchedule getClassScheduleById(Integer id);
    public ClassSchedule updateClassScheduleById(Integer id, ClassSchedule classSchedule);
    public boolean deleteClassScheduleById(Integer id);


    public List<ClassSchedule> getAllClassScheduleByDataTime(Date min, Date max);
    public List<ClassSchedule> getAllClassScheduleByDuration(Integer min, Integer max);
    public List<ClassSchedule> getAllClassScheduleByPeerTutor(String peerTutor);
    public List<ClassSchedule> getAllClassScheduleBySchoolName(String schoolName);
    public List<ClassSchedule> getAllClassScheduleByTopicName(String topicName);
    public List<ClassSchedule> getAllClassScheduleByTopicContext(String topicContext);
    
}
