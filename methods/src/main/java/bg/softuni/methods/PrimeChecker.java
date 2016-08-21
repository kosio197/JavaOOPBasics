package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeChecker {

    static class Number {

        private static int num;
        private static boolean prime;

        public Number(int num) {
            this.setNum(num);
            this.setPrime(true);
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            Number.num = num;
        }

        public boolean isPrime() {
            return prime;
        }

        public void setPrime(boolean prime) {
            Number.prime = prime;
        }

        public boolean getNextPrime() {

            int [] startPrime = {0, 1, 2, 3, 5 };
            for (int i = 0; i < startPrime.length-1; i++) {
                if(num == i){
                    num = startPrime[i+1];
                    return prime;
                }
            }

            int temp = num;
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    prime = false;
                }
            }

            while (temp < Integer.MAX_VALUE) {
                temp++;
                boolean checkTemp = true;
                for (int i = 2; i < temp; i++) {
                    if (temp % i == 0) {
                        checkTemp = false;
                    }
                }
                if (checkTemp) {
                    num = temp;
                    break;
                }
            }
            return prime;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inpNumber = Integer.valueOf(br.readLine());

        Number num = new Number(inpNumber);
        boolean prime = num.getNextPrime();

        System.out.println(num.getNum() + ", " + prime);

        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields)
                .filter(f -> f.getName().contains("prime") || f.getName().contains("num")).collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() >= 1).collect(Collectors.toList());

        if (filedsDeclared.size() <= 1 || constructors.size() < 1) {
            throw new ClassFormatError();
        }

    }
}
