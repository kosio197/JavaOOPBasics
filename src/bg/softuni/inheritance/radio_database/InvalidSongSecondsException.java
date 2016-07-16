package bg.softuni.inheritance.radio_database;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    private static final long serialVersionUID = 1L;

    public InvalidSongSecondsException(String mesage) {
        super(mesage);
    }
}
