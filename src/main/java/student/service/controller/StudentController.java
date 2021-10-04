package student.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.service.VO.ResponseTemplateVO;
import student.service.entity.Student;
import student.service.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/get")
    public List<Student> getAllStudent(){
        return studentService.getAll();
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "delete successfully";
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithKhoa(@PathVariable("id") Long studentId){
        return studentService.getStudentWithKhoa(studentId);
    }
}
