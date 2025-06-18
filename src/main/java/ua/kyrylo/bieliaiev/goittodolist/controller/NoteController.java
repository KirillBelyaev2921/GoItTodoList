package ua.kyrylo.bieliaiev.goittodolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;
import ua.kyrylo.bieliaiev.goittodolist.service.NoteService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public List<Note> findAll() {
        return noteService.listAll();
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @PostMapping
    public Note add(@RequestBody Note note) {
        return noteService.add(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Note edit(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        noteService.update(note);
        return findById(id);
    }
}
