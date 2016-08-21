package bg.softuni.classbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        Class<Box> boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields).stream().filter(f -> Modifier.isPrivate(f.getModifiers())).count());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(br.readLine());
        double width = Double.valueOf(br.readLine());
        double height = Double.valueOf(br.readLine());

        br.close();
        try {

            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f\n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f\n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f\n", box.getVolume());

        } catch (Exception e) {
            System.out.printf("%s cannot be zero or negative.", e.getMessage());
        }

    }
}
