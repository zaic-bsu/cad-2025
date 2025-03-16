package ru.bsuedu.cad.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.bsuedu.cad.demo.entity.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{
    Student save(Student student);
    Optional<Student> findById(Long id);
    void update(Student student);
    void delete(Student student);
    List<Student> findByName(String name);
}
