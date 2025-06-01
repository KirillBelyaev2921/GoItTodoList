package ua.kyrylo.bieliaiev.goittodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
