package bg.softuni.radio_database;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    private static final long serialVersionUID = 1L;

    public InvalidSongMinutesException(String mesage) {
        super(mesage);
    }
}
