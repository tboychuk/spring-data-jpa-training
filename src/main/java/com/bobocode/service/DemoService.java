package com.bobocode.service;

import com.bobocode.domain.Person;
import com.bobocode.repo.NoteRepository;
import com.bobocode.repo.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DemoService {
    private final EntityManager entityManager;
    private final PersonRepository personRepository;
    private final NoteRepository noteRepository;

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public void demo() {
//        var person = entityManager.find(Person.class, 230123, LockModeType.PESSIMISTIC_WRITE);
//        var person = personRepository.findById(230123).orElseThrow();
        var person = personRepository.findByLastName("Navozenko");
        System.out.println(person.getFirstName() + " "+ person.getLastName());
        System.out.println(person.getNotes().size());
    }
}
