package bg.softuni.definingclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CatLady {

    static class Cat {

        String name;
        String breed;

        public Cat(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    static class Siamese extends Cat {

        int earSize;

        public Siamese(String name, String breed, int earSize) {
            super(name, breed);
            this.earSize = earSize;
        }

        public int getEarSize() {
            return earSize;
        }

        public void setEarSize(int earSize) {
            this.earSize = earSize;
        }

        @Override
        public String toString() {
            return super.breed + " " + super.name + " " + earSize;
        }
    }

    static class Cymric extends Cat {

        double furLength;

        public Cymric(String name, String breed, double furLength) {
            super(name, breed);
            this.furLength = furLength;
        }

        public double getFurLength() {
            return furLength;
        }

        public void setFurLength(double furLength) {
            this.furLength = furLength;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", super.breed, super.name, furLength);
        }

    }

    static class StreetExtraordinaire extends Cat {

        int decibelsOfMeows;

        public StreetExtraordinaire(String name, String breed, int decibelsOfMeows) {
            super(name, breed);
            this.decibelsOfMeows = decibelsOfMeows;
        }

        public int getDecibelsOfMeows() {
            return decibelsOfMeows;
        }

        public void setDecibelsOfMeows(int decibelsOfMeows) {
            this.decibelsOfMeows = decibelsOfMeows;
        }

        @Override
        public String toString() {
            return super.breed + " " + super.name + " " + decibelsOfMeows;
        }
    }

    private static List<Cat> cats = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        while (!data.equals("End")) {
            addCat(data);
            data = br.readLine();
        }

        printCats(br.readLine());
    }

    private static void printCats(String name) {
        for (Cat cat : cats) {
            if (cat.name.equals(name)) {
                System.out.println(cat);
            }
        }

    }

    private static void addCat(String data) {

        String inp[] = data.split("\\s+");
        Cat cat = null;
        switch (inp[0]) {

            case "Siamese":
                cat = new Siamese(inp[1], inp[0], Integer.valueOf(inp[2]));
                break;
            case "Cymric":
                cat = new Cymric(inp[1], inp[0], Double.valueOf(inp[2]));
                break;
            case "StreetExtraordinaire":
                cat =  new StreetExtraordinaire(inp[1], inp[0], Integer.valueOf(inp[2]));
                break;

            default:
                break;
        }
        cats.add(cat);
    }
}
