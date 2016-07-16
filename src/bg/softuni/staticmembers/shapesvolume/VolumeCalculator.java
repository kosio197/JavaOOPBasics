package bg.softuni.staticmembers.shapesvolume;

public class VolumeCalculator {

    public static double getCubeVolume(Cube cube) {
        return cube.getSideLength() * cube.getSideLength() * cube.getSideLength();
    }

    public static double getCylinderVolume(Cylinder cilinder) {
        return Math.PI * Math.pow(cilinder.getRadius(), 2) * cilinder.getHeight();
    }

    public static double getTriangularPrismVolume(TriangularPrism tr) {
        return (tr.getBaseSide() * tr.getHeight() / 2) * tr.getLength();
    }

    public static void printVolume(double volume) {
        System.out.printf("%.3f\n", volume);
    }
}
