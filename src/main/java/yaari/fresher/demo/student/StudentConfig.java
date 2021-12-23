package yaari.fresher.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            Student raj = new Student(
                    "Raj",
                    "raj@gamil.com",
                    LocalDate.of(2000, JANUARY,5)

            );

            Student rahul = new Student(
                    "Rahul",
                    "rahul@gamil.com",
                    LocalDate.of(2002, MARCH,10)
            );

            repository.saveAll(
                    List.of(raj,rahul)
            );
        };
    }
}
