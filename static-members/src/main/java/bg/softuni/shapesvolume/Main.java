package bg.softuni.shapesvolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            double volume = 0;

            switch (command) {
                case "Cube":
                    double sideLength = Double.valueOf(input.split(" ")[1]);
                    Cube cube = new Cube(sideLength);
                    volume = VolumeCalculator.getCubeVolume(cube);
                    break;

                case "Cylinder":
                    double radius = Double.valueOf(input.split(" ")[1]);
                    double height = Double.valueOf(input.split(" ")[2]);
                    Cylinder cilinder = new Cylinder(radius, height);
                    volume = VolumeCalculator.getCylinderVolume(cilinder);
                    break;

                case "TrianglePrism":
                    double baseSide = Double.valueOf(input.split(" ")[1]);
                    double heightf = Double.valueOf(input.split(" ")[2]);
                    double length = Double.valueOf(input.split(" ")[3]);
                    TriangularPrism tr = new TriangularPrism(baseSide, heightf, length);
                    volume = VolumeCalculator.getTriangularPrismVolume(tr);
                    break;
                default:
                    break;
            }
            VolumeCalculator.printVolume(volume);
            input = br.readLine();
        }
    }
}
