package com.assignment.notetaking.service;

import com.assignment.notetaking.dto.request.NoteDTORequest;
import com.assignment.notetaking.dto.response.NoteDTO;
import com.assignment.notetaking.dto.response.NotesListDTO;
import com.assignment.notetaking.model.Note;
import com.assignment.notetaking.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotesService {
    private final NoteRepository noteRepository;

    public ResponseEntity<?> getNotes(Pageable pageable) {
        log.info("Get all Notes");

        NotesListDTO response = new NotesListDTO();
        List<NoteDTO> notes = new ArrayList<>();

        Page<Note> notePage = noteRepository.findAll(pageable);
        List<Note> notesList = new ArrayList<>(notePage.getContent());

        for (Note note : notesList) {
            NoteDTO noteDTORequest = new NoteDTO();
            noteDTORequest.setId(String.valueOf(note.getId()));
            noteDTORequest.setTitle(note.getTitle());
            noteDTORequest.setBody(note.getBody());
            notes.add(noteDTORequest);
        }

        response.setNotes(notes);
        response.setTotal(notes.size());

        return new ResponseEntity<>(new PageImpl<>(notesList, pageable, notePage.getTotalElements()), HttpStatus.OK);
    }

    public void addNote(NoteDTORequest noteDTORequest) throws Exception {
        log.info("Add new Note");

        validateNonEmpty(noteDTORequest);
        Note note = new Note();
        note.setTitle(noteDTORequest.getTitle());
        note.setBody(noteDTORequest.getBody());

        noteRepository.save(note);
    }

    public ResponseEntity<?> getNote(Long id) throws Exception {
        log.info("Get Note Info");

        return new ResponseEntity<>(checkExistingId(id), HttpStatus.OK);
    }

    public void updateNote(Long id, NoteDTORequest noteDTORequest) throws Exception {
        log.info("Update Note");

        validateNonEmpty(noteDTORequest);
        Note note = checkExistingId(id);
        note.setTitle(noteDTORequest.getTitle());
        note.setBody(noteDTORequest.getBody());

        noteRepository.save(note);
    }

    public void deleteNote(Long id) throws Exception {
        log.info("Delete Vehicle");

        noteRepository.delete(checkExistingId(id));
    }

    private Note checkExistingId(Long id) throws Exception {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            throw new Exception("Note Not Found");
        }

        return optionalNote.get();
    }

    private void validateNonEmpty(NoteDTORequest noteDTORequest) throws Exception {
        if (noteDTORequest.getTitle().isEmpty() && noteDTORequest.getBody().isEmpty()) {
            throw new Exception("Both Title and Body cannot be empty");
        }
    }

}
