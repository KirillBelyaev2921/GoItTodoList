package ua.kyrylo.bieliaiev.goittodolist.exceptions;

public class NoteIdPresentException extends TodoListNoteException {
    public NoteIdPresentException() {
    }

    public NoteIdPresentException(String message) {
        super(message);
    }

    public NoteIdPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteIdPresentException(Throwable cause) {
        super(cause);
    }
}
