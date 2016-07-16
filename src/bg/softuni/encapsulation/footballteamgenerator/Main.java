package bg.softuni.encapsulation.footballteamgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> map = new HashMap<>();

        String inp = br.readLine();
        while (!inp.equals("END")) {
            String data[] = inp.split(";");

            switch (data[0]) {
                case "Team":
                    try {
                        Team team = new Team(data[1]);
                        map.put(data[1], team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Add":
                    Team t = map.get(data[1]);
                    if (t == null) {
                        System.out.printf("Team %s does not exist.\n", data[1]);
                    } else {
                        try {
                            t.addPlayer(new Player(data[2], Double.valueOf(data[3]), Double.valueOf(data[4]),
                                    Double.valueOf(data[5]), Double.valueOf(data[6]), Double.valueOf(data[7])));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    break;

                case "Remove":
                    List<Player> list = map.get(data[1]).getPlayers();
                    boolean check = false;
                    Player pr = null;
                    for (Player p : list) {
                        if (p.getName().equals(data[2])) {
                            check = true;
                            pr = p;
                            break;
                        }
                    }
                    if (!check) {
                        System.out.printf("Player %s is not in %s team.\n", data[2], data[1]);
                    } else {
                        map.get(data[1]).removePlayer(pr);
                    }
                    break;

                case "Rating":
                    t = map.get(data[1]);
                    if (t == null) {
                        System.out.printf("Team %s does not exist.\n", data[1]);
                    } else {
                        System.out.printf("%s - %d\n", t.getName(), Math.round(t.getRating()));
                    }
                    break;

                default:
                    break;
            }

            inp = br.readLine();
        }
        br.close();

    }
}
