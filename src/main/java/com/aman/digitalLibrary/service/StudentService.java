package com.aman.digitalLibrary.service;

import com.aman.digitalLibrary.modal.Student;
import com.aman.digitalLibrary.modal.StudentType;
import com.aman.digitalLibrary.repository.StudentDao;
import com.aman.digitalLibrary.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public Student createStudent(CreateStudentRequest request){
        String id=request.getStudentId();
        String type=request.getStudentType().toString();
        String name=request.getName();
        String email=request.getEmail();
        String phone=request.getPhoneNO();
        Student student=Student.builder().studentId(Integer.parseInt(id)).studentType(StudentType.valueOf(type))
                .email(email).name(name).phoneNo(phone).build();

        int result = studentDao.createStudentIndatabase(student);
        if(result>0){
            System.out.println("Data has been inserted successfully");
            return student;
        }
        return null;




    }

}
