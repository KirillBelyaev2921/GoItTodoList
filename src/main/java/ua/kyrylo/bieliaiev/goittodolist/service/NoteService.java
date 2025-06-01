package ua.kyrylo.bieliaiev.goittodolist.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteIdNotPresentException;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteIdPresentException;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteNotFoundException;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;
import ua.kyrylo.bieliaiev.goittodolist.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public Note getById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " not found"));
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        if (note.getId() != null) {
            throw new NoteIdPresentException("Note with id cannot be added");
        }
        note = noteRepository.save(note);
        return note;
    }

    public void update(Note note) {
        if (note.getId() == null) {
            throw new NoteIdNotPresentException("Note without id cannot be updated");
        }
        Note oldNote = getById(note.getId());
        if (oldNote != null) {
            noteRepository.save(note);
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

}
