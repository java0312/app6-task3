package uz.pdp.app6task3.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.app6task3.entity.Person;

@Repository
public interface PersonRepository extends MyRepository<Person, Long> {

    boolean existsByUsername(String username);

    boolean existsByUsernameAndIdNot(String username, Long id);

    @Query("FROM Person p where p.username=:username")
    Person findByUsername(@Param("username") String username);


    @Modifying
    @Query("UPDATE Person p SET p.name=:name, p.username=:username WHERE p.id=:id")
    void changePerson(@Param("id") Long id, @Param("name") String name, @Param("username") String username);

}
