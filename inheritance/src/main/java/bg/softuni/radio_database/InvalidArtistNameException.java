package bg.softuni.radio_database;

public class InvalidArtistNameException extends InvalidSongException {

    private static final long serialVersionUID = 1L;

    public InvalidArtistNameException(String mesage) {
        super(mesage);
    }
}
