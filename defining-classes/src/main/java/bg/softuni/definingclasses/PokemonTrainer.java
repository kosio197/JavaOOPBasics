package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PokemonTrainer {

    static class Pokemon {
        String name;
        String element;
        int healt;

        public Pokemon(String name, String element, int healt) {
            this.name = name;
            this.element = element;
            this.healt = healt;
        }
    }

    static class Trainer implements Comparable<Trainer> {
        String name;
        int bages;
        Map<String, List<Pokemon>> pokemons;

        public Trainer(String trainerName, String pokemonName, String pokemonElement, int pokemonHealt) {

            this.name = trainerName;
            List<Pokemon> pokList = new ArrayList<>();
            pokList.add(new Pokemon(pokemonName, pokemonElement, pokemonHealt));
            Map<String, List<Pokemon>> pokMap = new HashMap<>();
            pokMap.put(pokemonElement, pokList);
            this.pokemons = pokMap;
            trainers.put(trainerName, this);

        }

        @Override
        public int compareTo(Trainer t) {
            if (this.bages > t.bages) {
                return -1;
            } else if (this.bages < t.bages) {
                return 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            Trainer t = (Trainer) o;
            return this.name.equals(t.name);
        }
    }

    private static Map<String, Trainer> trainers = new TreeMap<>();
    private static List<Trainer> tList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputTrainer = br.readLine();
        while (!inputTrainer.equals("Tournament")) {
            String s[] = inputTrainer.split("\\s");
            Trainer trainer = trainers.get(s[0]);
            if (trainer == null) {
                trainer = new Trainer(s[0], s[1], s[2], Integer.valueOf(s[3]));
            } else {
                List<Pokemon> pl = trainer.pokemons.get(s[2]);
                if (pl == null) {
                    pl = new ArrayList<>();
                    trainer.pokemons.put(s[2], pl);
                }
                pl.add(new Pokemon(s[1], s[2], Integer.valueOf(s[3])));
            }

            if (!tList.contains(trainer)) {
                tList.add(trainer);
            }

            inputTrainer = br.readLine();
        }
        String command = br.readLine();
        while (!command.equals("End")) {
            processCommand(command);
            command = br.readLine();
        }
        printresult();
    }

    private static void printresult() {

        Collections.sort(tList);
        for (Trainer trainer : tList) {
            System.out.printf("%s %d %d\n", trainer.name, trainer.bages, trainer.pokemons.size());
        }
    }

    private static void processCommand(String command) {

        for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
            if (trainer.getValue().pokemons.containsKey(command)) {
                trainer.getValue().bages++;
            } else {
                for (Map.Entry<String, List<Pokemon>> pMap : trainer.getValue().pokemons.entrySet()) {
                    int size = pMap.getValue().size();
                    for (int i = 0; i < size; i++) {
                        Pokemon p = pMap.getValue().get(i);
                        p.healt -= 10;
                        if (p.healt <= 0) {
                            pMap.getValue().remove(p);
                        }
                    }
                }
            }
        }
    }
}
