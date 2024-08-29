package sn.cisse410.student;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/findByEmail")
    public Student findStudentByEmail(@RequestParam String email) {
        return studentRepository.findByEmail(email);
    }

    @GetMapping("/student/findByEmailDomain")
    public List<Student> findStudentByEmailDomain(@RequestParam String domain) {
        return studentRepository.findByDomain(domain);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> stdt = studentRepository.findById(id);
        if (stdt.isPresent()) {
            Student studentUpdated = stdt.get();
            studentUpdated.setName(student.getName());
            studentUpdated.setEmail(student.getEmail());
            return studentRepository.save(studentUpdated);
        }
        return null;
    }
}
