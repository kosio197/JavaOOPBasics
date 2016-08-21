package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {
    static abstract class Figure {

        String name;

        public Figure(String name) {
            this.name = name;
        }
    }

    static class Square extends Figure {

        private int size;

        public Square(String name, int a) {
            super(name);
            this.size = a;
        }

        public int getSize() {
            return size;
        }

    }

    static  class Rectangle extends Figure {

        private int width;
        private int length;

        public Rectangle(String name, int width, int length) {
            super(name);
            this.width = width;
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public int getLength() {
            return length;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String figure = br.readLine();
        switch (figure) {
        case "Square":
            int a = Integer.valueOf(br.readLine());
            Square scuare = new Square(figure, a);
            printScuare(scuare);
            break;

        case "Rectangle":
            int width = Integer.valueOf(br.readLine());
            int length = Integer.valueOf(br.readLine());
            Rectangle rectangle = new Rectangle(figure, width, length);
            printRectangle(rectangle);
            break;
        default:
            break;
        }
        br.close();

    }

    private static void printRectangle(Rectangle rectangle) {

        System.out.println("|" + new String(new char[rectangle.getWidth()]).replace('\0', '-') + "|");
        for (int i = 0; i < rectangle.getLength() - 2; i++) {
            System.out.println("|" + new String(new char[rectangle.getWidth()]).replace('\0', ' ') + "|");
        }
        System.out.println("|" + new String(new char[rectangle.getWidth()]).replace('\0', '-') + "|");
    }

    private static void printScuare(Square scuare) {
        int size = scuare.getSize();
        System.out.println("|" + new String(new char[scuare.getSize()]).replace('\0', '-') + "|");
        for (int i = 0; i < size - 2; i++) {
            System.out.println("|" + new String(new char[scuare.getSize()]).replace('\0', ' ') + "|");
        }
        System.out.println("|" + new String(new char[scuare.getSize()]).replace('\0', '-') + "|");
    }
}
