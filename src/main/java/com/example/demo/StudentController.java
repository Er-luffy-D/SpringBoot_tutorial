// package com.example.demo;
// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// // @RestController
// public class StudentController {
//     private StudentService service;

//     public StudentController(StudentService service) {
//         super();
//         this.service = service;
//     }

//     @RequestMapping("/students")
//     public List<Student> getAllStudents() {
//         return service.getAllStudents();
//     }

//     @RequestMapping("/student/{id}")
//     public Student getStudentById(@PathVariable int id) {
//         return service.getStudentById(id);
//     }

//     @PostMapping(path={"/students"})
//     public Student addStudent(@RequestBody Student student) {
//         return service.saveStudent(student);
//     }
    
//     @DeleteMapping(path={"/students/{id}"})
//     public String deleteStudent(@PathVariable int id) {
//         service.delete(id);
//         return "Student with id " + id + " deleted successfully.";
//     }
    

// }
