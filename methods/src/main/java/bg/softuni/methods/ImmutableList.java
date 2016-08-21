package bg.softuni.methods;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ImmutableList {

    private List<Integer> ints;

    public ImmutableList() {
        ints = new ArrayList<>();
    }

    public ImmutableList(List<Integer> ints) {
        this();
        ints.addAll(ints);

    }

    public ImmutableList getArray() {
        return new ImmutableList(ints);
    }

    public static void main(String[] args) {

        Class<ImmutableList> listClass = ImmutableList.class;
        Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatError();
        }

        Method method = listClass.getDeclaredMethods()[0];
        System.out.println(method.getReturnType().getSimpleName());
    }
}
