package com.assignment.notetaking.repository;

import com.assignment.notetaking.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
