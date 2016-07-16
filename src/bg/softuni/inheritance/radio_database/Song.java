package bg.softuni.inheritance.radio_database;

public class Song {

    private String artistName;
    private String songName;
    private int min;
    private int sec;

    public Song(String artistName, String songName, int min, int sec) throws InvalidSongException {
        setArtistName(artistName);
        setSongName(songName);
        setMin(min);
        setSec(sec);
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setArtistName(String artistName) throws InvalidSongException {
        try {
            if (artistName.length() < 3 || artistName.length() > 20) {
                throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
            }
        } catch (InvalidArtistNameException e) {
            throw new InvalidSongException(e.getMesage());
        }

        this.artistName = artistName;
    }


    public void setSongName(String songName) throws InvalidSongException {
        try {
            if (songName.length() < 3 || songName.length() > 30) {
                throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
            }
        } catch (InvalidSongNameException e) {
            throw new InvalidSongException(e.getMesage());
        }

        this.songName = songName;
    }


    public void setMin(int min) throws InvalidSongException {
        try {
            try {
                if (min < 0 || min > 14) {
                    throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
                }
            } catch (InvalidSongMinutesException e) {
                throw new InvalidSongLengthException(e.getMesage());
            }
        } catch (InvalidSongLengthException e) {
            throw new InvalidSongException(e.getMesage());
        }

        this.min = min;
    }

    public void setSec(int sec) throws InvalidSongException {
        try {
            try {
                if (sec < 0 || sec > 59) {
                    throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
                }
            } catch (InvalidSongSecondsException e) {
                throw new InvalidSongLengthException(e.getMesage());
            }
        } catch (InvalidSongLengthException e) {
            throw new InvalidSongException(e.getMesage());
        }

        this.sec = sec;
    }

}
