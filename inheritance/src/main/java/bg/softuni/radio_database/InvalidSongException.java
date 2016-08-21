package bg.softuni.radio_database;

public class InvalidSongException extends Exception {
    private static final long serialVersionUID = 1L;

    private String mesage;

    public InvalidSongException(String mesage) {
        this.mesage = mesage;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

}
