package ua.kyrylo.bieliaiev.goittodolist.service;

public class TodoListNoteException extends RuntimeException {
    public TodoListNoteException() {
    }

    public TodoListNoteException(String message) {
        super(message);
    }

    public TodoListNoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoListNoteException(Throwable cause) {
        super(cause);
    }
}
