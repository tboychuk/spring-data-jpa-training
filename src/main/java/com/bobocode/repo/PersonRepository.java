package com.bobocode.repo;

import com.bobocode.domain.Person;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Person findByLastName(String lastName);
}
