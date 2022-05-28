package uz.pdp.app6task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App6Task3Application {

    public static void main(String[] args) {
        SpringApplication.run(App6Task3Application.class, args);
    }

    /**
     * __Link: https://www.baeldung.com/spring-data-annotations
     *
     * |-> @Transactional
     *
     * |-> @NoRepositoryBean
     *
     * |-> @Param
     *
     * |-> @Id
     *
     * |-> @Transient
     *
     * |-> @CreatedBy,
     *
     * |-> @LastModifiedBy,
     *
     * |-> @CreatedDate,
     *
     * |-> @LastModifiedDate
     *
     * |-> @Query
     *
     * @Procedure <-|
     *
     * @Lock <-|
     *
     * |-> @Modifying
     *
     * @EnableJpaRepositories <-|
     *
     * @Document <-| @Entity ning ekvivalenti
     *
     * |-> @Field maydonning database dagi nomini berish @Column ning ekvivalenti
     *
     * --> @Query
     *
     * @EnableMongoRepositories <-|
     *
     * */

}
