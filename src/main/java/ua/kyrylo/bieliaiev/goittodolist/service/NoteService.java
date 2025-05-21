package ua.kyrylo.bieliaiev.goittodolist.service;

import org.springframework.stereotype.Service;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(1L);

    public Note getById(Long id) {
        if(!notes.containsKey(id)) {
            throw new NoteNotFoundException();
        }
        return notes.get(id);
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        if (note.getId() != null) {
            throw new NoteIdPresentException();
        }
        note.setId(idCounter.getAndIncrement());
        notes.put(note.getId(), note);
        return note;
    }

    public void update(Note note) {
        if (note.getId() == null) {
            throw new NoteIdNotPresentException();
        }
        if (!notes.containsKey(note.getId())) {
            throw new NoteNotFoundException();
        }
        notes.put(note.getId(), note);
    }

    public void deleteById(Long id) {
        if (!notes.containsKey(id)) {
            throw new NoteNotFoundException();
        }
        notes.remove(id);
    }

}
