package com.menhajdev.msreminder.services;

import com.menhajdev.msreminder.models.Note;
import com.menhajdev.msreminder.models.User;
import com.menhajdev.msreminder.repositories.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found"));
    }

    public Note saveNote(Note note, Long userId) {
        User user = userService.findUserbyId(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        note.setUser(user);
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new EntityNotFoundException("Note not found");
        }
        noteRepository.deleteById(id);
    }
}
