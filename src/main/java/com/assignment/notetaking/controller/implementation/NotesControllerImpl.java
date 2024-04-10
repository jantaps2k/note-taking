package com.assignment.notetaking.controller.implementation;

import com.assignment.notetaking.controller.NotesController;
import com.assignment.notetaking.dto.request.NoteDTORequest;

import com.assignment.notetaking.service.NotesService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NotesControllerImpl implements NotesController {
    private final NotesService notesService;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNotes(@PageableDefault(value = 5, page = 0) Pageable pageable) {
        return notesService.getNotes(pageable);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNote(@RequestBody NoteDTORequest noteDTORequest) throws Exception {
        notesService.addNote(noteDTORequest);
    }

    @Override
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNote(@PathVariable("id") Long id) throws Exception {
        return notesService.getNote(id);
    }

    @Override
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateNote(
            @PathVariable("id") Long id,
            @RequestBody NoteDTORequest noteDTORequest) throws Exception {
        notesService.updateNote(id, noteDTORequest);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteNote(@PathVariable("id") Long id) throws Exception {
        notesService.deleteNote(id);
    }
}
