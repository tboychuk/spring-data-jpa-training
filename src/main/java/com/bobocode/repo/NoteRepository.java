package com.bobocode.repo;

import com.bobocode.domain.Note;
import com.bobocode.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
