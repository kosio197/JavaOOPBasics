package bg.softuni.exam.kermen.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bg.softuni.exam.kermen.model.AloneOld;
import bg.softuni.exam.kermen.model.AloneYoung;
import bg.softuni.exam.kermen.model.Child;
import bg.softuni.exam.kermen.model.Home;
import bg.softuni.exam.kermen.model.OldCouple;
import bg.softuni.exam.kermen.model.YoungCouple;
import bg.softuni.exam.kermen.model.YoungCoupleWithChildren;
import bg.softuni.exam.kermen.model.item.ElConsumer;

public class FactoryHome {

    public static Home createNewHome(String homeInfo) {

        double salary1;
        double salary2;
        double pension1;
        double pension2;
        List<ElConsumer> consumer = new ArrayList<>();

        Pattern p = Pattern.compile("\\(([0-9.,\\s]+)\\)");
        Matcher m = p.matcher(homeInfo);

        List<String> homeData = new ArrayList<>();
        while (m.find()) {
            homeData.add(m.group(0));
        }

        Home home;
        if (homeInfo.startsWith("YoungCoupleWithChildren")) {

            String str = homeData.get(0).substring(1, homeData.get(0).length() - 1);
            salary1 = Double.valueOf(str.split(",")[0].trim());
            salary2 = Double.valueOf(str.split(",")[1].trim());

            consumer.add(
                    new ElConsumer("tv", Double.valueOf(homeData.get(1).substring(1, homeData.get(1).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(2).substring(1, homeData.get(2).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(3).substring(1, homeData.get(3).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(3).substring(1, homeData.get(3).length() - 1))));

            List<Child> children = new ArrayList<>();
            for (int i = 4; i < homeData.size(); i++) {

                Child child = new Child(0);
                String childCost[] = homeData.get(i).substring(1, homeData.get(i).length() - 1).split(",");
                for (String cost : childCost) {
                    child.setChildCost(child.getChildCost() + Double.valueOf(cost.trim()));
                }
                children.add(child);
            }

            home = new YoungCoupleWithChildren(salary1, salary2, consumer, children);

        } else if (homeInfo.startsWith("YoungCouple")) {

            String str = homeData.get(0).substring(1, homeData.get(0).length() - 1);
            salary1 = Double.valueOf(str.split(",")[0].trim());
            salary2 = Double.valueOf(str.split(",")[1].trim());

            consumer.add(
                    new ElConsumer("tv", Double.valueOf(homeData.get(1).substring(1, homeData.get(1).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(2).substring(1, homeData.get(2).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(3).substring(1, homeData.get(3).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(3).substring(1, homeData.get(3).length() - 1))));

            home = new YoungCouple(salary1, salary2, consumer);

        } else if (homeInfo.startsWith("AloneYoung")) {

            salary1 = Double.valueOf(homeData.get(0).substring(1, homeData.get(0).length() - 1));
            consumer.add(new ElConsumer("laptop",
                    Double.valueOf(homeData.get(1).substring(1, homeData.get(1).length() - 1))));

            home = new AloneYoung(salary1, consumer);

        } else if (homeInfo.startsWith("OldCouple")) {

            String str = homeData.get(0).substring(1, homeData.get(0).length() - 1);
            pension1 = Double.valueOf(str.split(",")[0].trim());
            pension2 = Double.valueOf(str.split(",")[1].trim());

            consumer.add(
                    new ElConsumer("tv", Double.valueOf(homeData.get(1).substring(1, homeData.get(1).length() - 1))));
            consumer.add(new ElConsumer("friger",
                    Double.valueOf(homeData.get(2).substring(1, homeData.get(2).length() - 1))));
            consumer.add(
                    new ElConsumer("stov", Double.valueOf(homeData.get(3).substring(1, homeData.get(3).length() - 1))));

            home = new OldCouple(pension1, pension2, consumer);

        } else if (homeInfo.startsWith("AloneOld")) {

            pension1 = Double.valueOf(homeData.get(0).substring(1, homeData.get(0).length() - 1));

            home = new AloneOld(pension1);
        } else {
            home = null;
        }
        return home;
    }
}
