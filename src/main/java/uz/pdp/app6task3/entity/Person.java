package uz.pdp.app6task3.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    private LocalDate birthDate;

    @CreatedBy //kim tomonidan yaratildi
    @ManyToOne
    private User createdBy;

    @LastModifiedBy //oxirgi marta kim taxrirladi
    @ManyToOne
    private User updatedBy;

    @CreatedDate //qachon yaratildi
    private Date createdDate;

    @LastModifiedDate //oxirgi marta qachon tahrirlandi
    private Date updatedDate;

    @Transient //ustun yaratilmaydi
    private Integer age;

    @Transient
    private Integer countLettersInUsername;

    public Integer getCountLettersInUsername() {
        countLettersInUsername = username.length();
        return countLettersInUsername;
    }

    public Integer getAge() {
        age = Period.between(LocalDate.now(), birthDate).getYears();
        return age;
    }
}
