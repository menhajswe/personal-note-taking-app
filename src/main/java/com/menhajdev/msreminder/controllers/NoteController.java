package com.menhajdev.msreminder.controllers;

import com.menhajdev.msreminder.models.Note;
import com.menhajdev.msreminder.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Note> createNote(
            @PathVariable Long userId,
            @RequestBody Note note) {

        Note saved = noteService.saveNote(note, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
