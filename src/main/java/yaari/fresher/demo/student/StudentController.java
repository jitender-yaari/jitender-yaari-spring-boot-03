package yaari.fresher.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentServicervice) {
        this.studentService = studentServicervice;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }


    @GetMapping(path=("{studentId}"))
    @Cacheable(value = "s", key = "#studentId")
    public Student getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){

        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    @CacheEvict(value = "s", allEntries = true)
    public void deleteStudent(@PathVariable("studentId") Long studentId){

        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    @CachePut(value = "s", key = "#studentId")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }
}
