package com.aman.digitalLibrary.controller;

import com.aman.digitalLibrary.modal.Student;
import com.aman.digitalLibrary.request.CreateStudentRequest;
import com.aman.digitalLibrary.response.StudentResponse;
import com.aman.digitalLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    StudentResponse studentResponse;

    @PostMapping(value = "/create/student",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody(required = true)CreateStudentRequest createStudentRequest){
        if(createStudentRequest==null){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setErrCode("Failed");
            studentResponse.setMessage("Request is empty");
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }
        Student student =studentService.createStudent(createStudentRequest);
        if(student==null){
            studentResponse.setErrCode("001");
            studentResponse.setMessage("Data Not Created");
            return new ResponseEntity<>(studentResponse,HttpStatus.BAD_GATEWAY);

        }
        studentResponse.setErrCode("00");
        studentResponse.setMessage("Data Has been created");
        studentResponse.setStudentId(Integer.toString(student.getStudentId()));
        studentResponse.setName(student.getName());
        return new ResponseEntity<>(studentResponse,HttpStatus.CREATED);
    }
}
