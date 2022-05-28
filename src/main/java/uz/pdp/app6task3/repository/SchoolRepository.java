package uz.pdp.app6task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.app6task3.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
