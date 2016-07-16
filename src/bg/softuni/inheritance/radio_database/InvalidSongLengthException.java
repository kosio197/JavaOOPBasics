package bg.softuni.inheritance.radio_database;

public class InvalidSongLengthException extends InvalidSongException {

    private static final long serialVersionUID = 1L;

    public InvalidSongLengthException(String mesage) {
        super(mesage);
    }
}
