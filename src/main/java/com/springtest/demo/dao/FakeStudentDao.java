package com.springtest.demo.dao;

import com.springtest.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDao implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDao() {
        database = new HashMap<>();
        UUID sID = UUID.randomUUID();
        database.put(sID, new Student(sID,25, "Alex", "Montana", "Computer Science"));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);

        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);

        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);

        return 1;
    }
}
