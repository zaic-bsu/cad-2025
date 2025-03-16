package ru.bsuedu.cad.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.bsuedu.cad.demo.entity.Group;

@Repository
public interface GroupRepository  extends CrudRepository<Group, Long> {
    Group save(Group student);
    Optional<Group> findById(Long id);
    void update(Group group);
    void delete(Group group);
    List<Group> findByNumber(int number);
}
