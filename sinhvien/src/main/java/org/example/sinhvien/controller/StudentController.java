package org.example.sinhvien.controller;

import org.example.sinhvien.dto.StudentCreateDTO;
import org.example.sinhvien.dto.StudentEditDTO;
import org.example.sinhvien.model.Student;
import org.example.sinhvien.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("studentService") // Chọn triển khai theo tên bean
    private IStudentService studentService;
    @GetMapping("")
    private String showList (Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "student/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("studentCreateDTO", new StudentCreateDTO());
        return "student/create";
    }
    @GetMapping("/edit")
    public String showEdit(Model model, Integer id) {
        Student student = studentService.findById(id);
        model.addAttribute("studentEditDTO", new StudentEditDTO());
        return "student/edit";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("studentCreateDTO") StudentCreateDTO studentCreateDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        Student student = new Student();
        student.setId(studentCreateDTO.getId());
        student.setBatch(studentCreateDTO.getBatch());
        student.setName(studentCreateDTO.getName());
        student.setGender(studentCreateDTO.getGender());
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("studentEditDTO") StudentEditDTO studentEditDTO, RedirectAttributes redirectAttributes) {
        Student student = new Student();
        student.setBatch(studentEditDTO.getBatch());
        student.setName(studentEditDTO.getName());
        student.setGender(studentEditDTO.getGender());
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "chỉnh sửa thành công");
        return "redirect:/student";
    }
}
