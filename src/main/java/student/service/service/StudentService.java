package student.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import student.service.VO.Khoa;
import student.service.VO.ResponseTemplateVO;
import student.service.entity.Student;
import student.service.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public void deleteStudent(Long id){
         studentRepository.deleteById(id);
    }
    public Student updateStudent(Long studentId, Student student) {
        Student studentFromDB = studentRepository.findById(studentId).get();
        studentFromDB.setName(student.getName());
        studentFromDB.setEmail(student.getEmail());
        studentFromDB.setKhoaId(student.getKhoaId());
        studentRepository.save(studentFromDB);
        return studentFromDB;
    }
    public ResponseTemplateVO getStudentWithKhoa(Long studentId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findById(studentId).get();
        vo.setStudent(student);
        Khoa khoa = restTemplate.getForObject("http://localhost:9002/khoa/"
                        + student.getKhoaId(), Khoa.class);
        vo.setKhoa(khoa);
        return vo;
    }

}

