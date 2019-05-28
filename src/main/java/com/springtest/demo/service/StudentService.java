package com.springtest.demo.service;

import com.springtest.demo.dao.StudentDao;
import com.springtest.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentUid);
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getstudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

     public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
     }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }

}
