package com.ncuindia.peermentoring.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncuindia.peermentoring.model.ClassSchedule;
import com.ncuindia.peermentoring.service.ClassScheduleService;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ClassSchedule")
public class ClassScheduleController {
    private ClassScheduleService classScheduleService;

    public ClassScheduleController(ClassScheduleService classScheduleService) {
        this.classScheduleService = classScheduleService;
    }
    @PostMapping("/save")
    public ResponseEntity<ClassSchedule> saveClassSchedule(@RequestBody ClassSchedule classSchedule){
        System.out.println("Class is SBK"+classSchedule);
        return new ResponseEntity<ClassSchedule>(classScheduleService.save(classSchedule), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ClassSchedule>> get(){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.get(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable("id") Integer id){
        return new ResponseEntity<ClassSchedule>(classScheduleService.getClassScheduleById(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Integer id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(classScheduleService.deleteClassScheduleById(id), HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<ClassSchedule> updateExpenseById(@PathVariable("id") Integer id, @RequestBody ClassSchedule classSchedule){
        return new ResponseEntity<ClassSchedule>(classScheduleService.updateClassScheduleById(id, classSchedule), HttpStatus.OK);
    }

    @GetMapping("/getAllClassScheduleByDateTime/{min}/{max}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleByDateTime(@PathVariable("min") Date min, @PathVariable("max") Date max){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleByDataTime(min, max), HttpStatus.OK);
    }

    @GetMapping("/getAllClassScheduleByDuration/{min}/{max}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleByPrice(@PathVariable("min") Integer min, @PathVariable("max") Integer max){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleByDuration(min, max), HttpStatus.OK);
    }

    @GetMapping("/getAllClassScheduleByPeerTutor/{peerTutor}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleByPeerTutor(@PathVariable("peerTutor") String peerTutor){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleByPeerTutor(peerTutor), HttpStatus.OK);
    }
    
    @GetMapping("/getAllClassScheduleBySchoolName/{schoolName}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleBySchoolName(@PathVariable("schoolName") String schoolName){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleBySchoolName(schoolName), HttpStatus.OK);
    }


    @GetMapping("/getAllClassScheduleByTopicContext/{topicContext}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleByTopicContext(@PathVariable("topicContext") String topicContext){
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleByTopicContext(topicContext), HttpStatus.OK);
    }

    @GetMapping("/getAllClassScheduleByTopicName/{topicName}")
    public ResponseEntity<List<ClassSchedule>> getAllClassScheduleByTopicName(@PathVariable("topicName") String topicName){
        System.out.println("PRinting"+topicName);
        return new ResponseEntity<List<ClassSchedule>>(classScheduleService.getAllClassScheduleByTopicName(topicName), HttpStatus.OK);
    }
}
