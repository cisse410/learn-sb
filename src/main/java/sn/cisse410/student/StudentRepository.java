package sn.cisse410.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    Student findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
    List<Student> findByDomain(@Param("domain") String domain);
}
