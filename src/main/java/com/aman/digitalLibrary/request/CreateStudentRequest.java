package com.aman.digitalLibrary.request;

import com.aman.digitalLibrary.modal.StudentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentRequest {
    String studentId;
    String name;
    String email;
    String phoneNO;
    StudentType studentType;
}
