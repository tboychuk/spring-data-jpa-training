package com.bobocode.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static java.time.LocalDateTime.now;

@Getter
@Setter
@ToString
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "notes_seq_generator")
    @SequenceGenerator(name = "notes_seq_generator", sequenceName = "notes_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    private String body;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;
        return id != null && id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
