package com.example.demo;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentCont {
    private final StudentService service;

    public StudentCont(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable int id) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "student-view";
    }

    @GetMapping("/")
    public String getAllStudents(Model model) {
        List<Student> s = service.getAllStudents();
        Collections.sort(s);
        model.addAttribute("students", s);
        model.addAttribute("student", new Student()); // to handle form
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "index";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student) {
        student.setId(id); // Ensure ID is set
        service.updateStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudentById(id);
        return "redirect:/";
    }
}