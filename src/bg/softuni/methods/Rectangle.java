package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Rectangle {
    private String id;
    private double width;
    private double height;
    private double xTopLeft;
    private double yTopLeft;

    public Rectangle(String id, double width, double height, double xTopLeft, double yTopLeft) {
        super();
        this.id = id;
        this.width = width;
        this.height = height;
        this.xTopLeft = xTopLeft;
        this.yTopLeft = yTopLeft;
    }

    public String getId() {
        return id;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getxTopLeft() {
        return xTopLeft;
    }

    public double getyTopLeft() {
        return yTopLeft;
    }

    private static Map<String, Rectangle> rectangles = new HashMap<String, Rectangle>();

    private static boolean intersect(Rectangle r1, Rectangle r2) {
        boolean xLine = false;
        boolean yLine = false;

        if ((r2.getxTopLeft() >= r1.getxTopLeft() && r2.xTopLeft <= r1.getxTopLeft() + r1.width)
                || (r2.getxTopLeft() + r2.width >= r1.xTopLeft
                && r2.getxTopLeft() + r2.width <= r1.xTopLeft + r1.width)) {
            xLine = true;
        }

        if ((r2.yTopLeft >= r1.yTopLeft - r1.height && r2.yTopLeft <= r1.yTopLeft)
                || (r2.yTopLeft - r2.height <= r1.yTopLeft && r2.yTopLeft - r2.height >= r1.yTopLeft - r1.height)) {
            yLine = true;

        }

        return xLine && yLine;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] data = line.split("\\s+");

        int rects = Integer.valueOf(data[0]);
        int checks = Integer.valueOf(data[1]);

        line = br.readLine();
        for (int i = 0; i < rects; i++) {
            data = line.split("\\s+");
            rectangles.put(data[0], new Rectangle(data[0], Double.valueOf(data[1]), Double.valueOf(data[2]),
                    Double.valueOf(data[3]), Double.valueOf(data[4])));
            line = br.readLine();
        }

        for (int i = 0; i < checks; i++) {
            data = line.split("\\s+");

            boolean test1 = intersect(rectangles.get(data[0]), rectangles.get(data[1]));
            boolean test2 = intersect(rectangles.get(data[1]), rectangles.get(data[0]));

            System.out.println(test1 || test2);
            line = br.readLine();
        }
    }
}
