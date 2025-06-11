package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
        // Initialize with some sample data

        if (repository.count() == 0) {
            repository.save(new Student("John Doe", "Computer Science", "133214"));
            repository.save(new Student("Rahul Sharma", "Electrical Engineering", "2345678901"));
            repository.save(new Student("Hiroshi Tanaka", "Mechanical Engineering", "3456789012"));
        }

        // }
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Student student) {
        if (repository.existsById(student.getId())) {
            return repository.save(student);
        }
        return null;
    }

    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }
}