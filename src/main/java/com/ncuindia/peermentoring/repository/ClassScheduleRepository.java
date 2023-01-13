package com.ncuindia.peermentoring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ncuindia.peermentoring.model.ClassSchedule;


public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Integer> {
    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE (cs.dateTime >= :min AND cs.dateTime <= :max)")
    public List<ClassSchedule> findAllClassScheduleByDataTime(@Param("min") Date min, @Param("max") Date max);

    
    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE (cs.duration >= :min AND cs.duration <= :max)")
    public List<ClassSchedule> findAllClassScheduleByDuration(@Param("min") Integer min, @Param("max") Integer max);
    
    
    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE cs.peerTutor = :peerTutor")
    public List<ClassSchedule> findAllClassScheduleByPeerTutor(@Param("peerTutor") String peerTutor);


    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE cs.schoolName = :schoolName")
    public List<ClassSchedule> findAllClassScheduleBySchoolName(@Param("schoolName") String schoolName);


    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE cs.topicName = :topicName")
    public List<ClassSchedule> findAllClassScheduleByTopicName(@Param("topicName") String topicName);


    @Query(value = "SELECT cs FROM ClassSchedule cs WHERE cs.topicContext = :topicContext")
    public List<ClassSchedule> findAllClassScheduleByTopicContext(@Param("topicContext") String topicContext);
}
