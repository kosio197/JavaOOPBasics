package bg.softuni.classbox;

public class Box {

    private static double lengthBox;
    private static double widthBox;
    private static double heightBox;

    public Box(double length, double width, double height) {
        setLengthBox(length);
        setWidthBox(width);
        setHeightBox(height);
    }


    private static void setLengthBox(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length");
        }
        Box.lengthBox = length;
    }

    private static void setWidthBox(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width");
        }
        Box.widthBox = width;
    }

    private static void setHeightBox(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height");
        }
        Box.heightBox = height;
    }


    public double getSurfaceArea() {
        return (2 * lengthBox * widthBox) + (2 * lengthBox * heightBox) + (2 * widthBox * heightBox);
    }

    public double getLateralSurfaceArea() {
        return (2 * lengthBox * heightBox) + (2 * widthBox * heightBox);
    }

    public double getVolume() {
        return lengthBox * widthBox * heightBox;
    }

}
