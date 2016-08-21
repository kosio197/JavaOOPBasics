package bg.softuni.mordor_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp[] = br.readLine().split("\\s+");
        br.close();

        List<FoodFactory> foods = new ArrayList<>();
        for (String str : inp) {
            switch (str.toLowerCase()) {
                case "cram":
                    foods.add(new Cram());
                    break;
                case "lembas":
                    foods.add(new Lembas());
                    break;
                case "apple":
                    foods.add(new Apple());
                    break;
                case "melon":
                    foods.add(new Melon());
                    break;
                case "honeycake":
                    foods.add(new HoneyCake());
                    break;
                case "mushrooms":
                    foods.add(new Mushrooms());
                    break;
                default:
                    foods.add(new EverythingElse());
                    break;
            }
        }

        int allPoints = 0;
        for (FoodFactory foodFactory : foods) {
            allPoints += foodFactory.getPoint();
        }

        MoodFactory mood = null;
        if (allPoints < -5) {
            mood = new Angry(allPoints);
        } else if (allPoints < 0) {
            mood = new Sad(allPoints);
        } else if (allPoints < 15) {
            mood = new Happy(allPoints);
        } else {
            mood = new JavaScript(allPoints);
        }

        System.out.println(mood.getPoint() + "\n" + mood.getName());
    }
}
