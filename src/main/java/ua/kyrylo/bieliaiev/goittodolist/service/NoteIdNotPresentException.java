package ua.kyrylo.bieliaiev.goittodolist.service;

public class NoteIdNotPresentException extends TodoListNoteException {
    public NoteIdNotPresentException() {
    }

    public NoteIdNotPresentException(String message) {
        super(message);
    }

    public NoteIdNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteIdNotPresentException(Throwable cause) {
        super(cause);
    }
}
