package bg.softuni.radio_database;

public class InvalidSongNameException extends InvalidSongException {

    private static final long serialVersionUID = 1L;

    public InvalidSongNameException(String mesage) {
        super(mesage);
    }

}
