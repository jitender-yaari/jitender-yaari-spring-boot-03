package yaari.fresher.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.email=?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("select s from Student s where s.id=?1")
    Student findStudentById(Long studentId);
}
