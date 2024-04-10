package com.assignment.notetaking.controller;

import com.assignment.notetaking.dto.request.NoteDTORequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

/**
 * @author jantaps2k
 */
@Tag(name = "Notes", description = "Notes API")
public interface NotesController {
    @Operation(summary = "Retrieve all notes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    ResponseEntity<?> getNotes(@PageableDefault(value = 5, page = 0) Pageable pageable);

    @Operation(summary = "Create Note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Both Title and Body cannot be empty", content = @Content)
    })
    void addNote(@Parameter(description = "Note to Create") NoteDTORequest noteDTORequest) throws Exception;

    @Operation(summary = "Retrieve Specific Note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Note Not Found", content = @Content)
    })
    ResponseEntity<?> getNote(@Parameter(description = "Note Id") Long id) throws Exception;

    @Operation(summary = "Update Note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Note Not Found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Both Title and Body cannot be empty", content = @Content)
    })
    void updateNote(
            @Parameter(description = "Note Id") Long id,
            @Parameter(description = "Note details") NoteDTORequest noteDTORequest) throws Exception;

    @Operation(summary = "Delete Note")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Note Not Found", content = @Content)
    })
    void deleteNote(@Parameter(description = "Note Id") Long id) throws Exception;
}
