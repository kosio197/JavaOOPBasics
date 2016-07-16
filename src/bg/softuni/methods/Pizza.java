package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pizza{

    private int group;
    private String name;

    public Pizza(int group, String name) {
        this.group = group;
        this.name = name;
    }

    public Map<Integer, List<String>> getAllPizza() {
        return map;
    }

    private static Map<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine();

        String regex = "(-?[0-9]+)(\\w+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);

        while (m.find()) {

            int group = Integer.valueOf(m.group(1));
            String name = m.group(2);

            // Pizza next = new Pizza(group, name); /za hui ?????
            List<String> nextPizza = map.get(group);
            if (nextPizza == null) {
                nextPizza = new ArrayList<>();
                map.put(group, nextPizza);
            }
            nextPizza.add(name);
        }

        for (Map.Entry<Integer, List<String>> e : map.entrySet()) {
            System.out.print(e.getKey() + " - ");
            for (int i = 0; i < e.getValue().size() - 1; i++) {
                System.out.print(e.getValue().get(i) + ", ");
            }
            System.out.print(e.getValue().get(e.getValue().size() - 1) + "\n");
        }

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods).filter(r -> r.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatError();
        }
    }

}
