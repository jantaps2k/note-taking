package com.assignment.notetaking.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(name = "NotesListDTO", description = "List of Notes Response")
@Data
public class NotesListDTO {
    @Schema(description = "List of Notes")
    List<NoteDTO> notes;

    @Schema(description = "Total Number of Records")
    private int total;
}
