package uz.pdp.app6task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NoRepositoryBean // bean qilmaydi
public interface MyRepository<T, ID> extends JpaRepository<T, ID> {

    Optional<T> findById(ID id);

}
