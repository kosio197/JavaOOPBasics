package bg.softuni.inheritance.radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());

        List<Song> songs = new ArrayList<>();
        int allMin = 0;
        int allSec = 0;

        for (int i = 0; i < count; i++) {
            try {
                String input = br.readLine();
                if (input == null || input.indexOf(':') < 0 || input.indexOf(';') < 0)
                    continue;
                int m = 0;
                int s = 0;

                String[] inp = input.split(";");
                try {
                    m = Integer.valueOf(inp[2].split(":")[0].trim());
                    s = Integer.valueOf(inp[2].split(":")[1].trim());
                } catch (Exception e) {
                    System.out.println("Invalid song length.");
                    continue;
                }

                Song song = new Song(inp[0], inp[1], m, s);
                songs.add(song);
                allMin += song.getMin();
                allSec += song.getSec();
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMesage());
            }
        }

        int temp = allSec == 0 ? 0 : allSec / 60;
        allMin += temp;
        allSec = allSec % 60;
        temp = allMin == 0 ? 0 : allMin / 60;
        allMin = allMin % 60;

        System.out.printf("Songs added: %d\nPlaylist length: %dh %dm %ds", songs.size(), temp, allMin, allSec);
    }
}
