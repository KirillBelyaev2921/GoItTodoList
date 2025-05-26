package ua.kyrylo.bieliaiev.goittodolist.exceptions;

public class NoteNotFoundException extends TodoListNoteException {
    public NoteNotFoundException() {
    }

    public NoteNotFoundException(String message) {
        super(message);
    }

    public NoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteNotFoundException(Throwable cause) {
        super(cause);
    }
}
