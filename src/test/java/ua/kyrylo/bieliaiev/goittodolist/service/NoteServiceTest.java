package ua.kyrylo.bieliaiev.goittodolist.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteIdNotPresentException;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteIdPresentException;
import ua.kyrylo.bieliaiev.goittodolist.exceptions.NoteNotFoundException;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;
import ua.kyrylo.bieliaiev.goittodolist.repository.NoteRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NoteServiceTest {
    private NoteService noteService;
    private static final String TITLE = "title";
    private static final String CONTENT = "content";
    private static final String NEW_CONTENT = "new content";

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        noteService = new NoteService(noteRepository);
    }

    @AfterEach
    void tearDown() {
        noteRepository.deleteAll();
    }

    @Test
    void getById() {
        Note savedNote = noteService.add(new Note(TITLE, CONTENT));

        Note byId = noteService.getById(savedNote.getId());

        assertNotNull(savedNote.getId());
        assertNotNull(byId);
    }

    @Test
    void getByIdNoteNotPresent() {
        assertThrows(NoteNotFoundException.class, () -> noteService.getById(0L));
    }

    @Test
    void addIdPresent() {
        Note note = new Note(TITLE, CONTENT);
        note.setId(1L);

        assertThrows(NoteIdPresentException.class, () -> noteService.add(note));
    }

    @Test
    void listAll() {
        noteService.add(new Note(TITLE, CONTENT));
        noteService.add(new Note(TITLE, CONTENT));
        noteService.add(new Note(TITLE, CONTENT));

        List<Note> notes = noteService.listAll();

        assertEquals(3, notes.size());
    }

    @Test
    void update() {
        Note savedNote = noteService.add(new Note(TITLE, CONTENT));
        savedNote.setContent(NEW_CONTENT);

        noteService.update(savedNote);
        Note updatedNote = noteService.getById(savedNote.getId());

        assertEquals(NEW_CONTENT, updatedNote.getContent());
    }

    @Test
    void updateNoteNotPresent() {
        Note note = new Note(TITLE, CONTENT);
        note.setId(1L);

        assertThrows(NoteNotFoundException.class, () -> noteService.update(note));
    }

    @Test
    void updateIdNotPresent() {
        Note note = new Note(TITLE, CONTENT);

        assertThrows(NoteIdNotPresentException.class, () -> noteService.update(note));
    }

    @Test
    void deleteById() {
        Note savedNote = noteService.add(new Note(TITLE, CONTENT));

        noteService.deleteById(savedNote.getId());

        assertThrows(NoteNotFoundException.class, () -> noteService.getById(savedNote.getId()));
    }
}