package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FibonacciNumbers {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startIndex = Integer.valueOf(br.readLine());
        int endIndex = Integer.valueOf(br.readLine());

        Fibonacci fib = new Fibonacci();
        ArrayList<Long> result = fib.getNumbersInRange(startIndex, endIndex);
        if (result.size() > 0) {
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.print(result.get(i) + ", ");
            }
            System.out.println(result.get(result.size() - 1));
        }
    }

    static class Fibonacci {

        private ArrayList<Long> fibonaciList;

        public Fibonacci() {
            this.setFibonaciList(new ArrayList<>());
        }

        public ArrayList<Long> getFibonaciList() {
            return fibonaciList;
        }

        public void setFibonaciList(ArrayList<Long> fibonaciList) {
            this.fibonaciList = fibonaciList;
        }

        public ArrayList<Long> getNumbersInRange(int startPosition, int endPosition) {

            long a = 0;
            long b = 1;
            long temp = 1;

            for (int i = 0; i < endPosition; i++) {
                if (i >= startPosition) {
                    fibonaciList.add(a);
                }
                temp = a + b;
                a = b;
                b = temp;
            }

            return fibonaciList;
        }

    }
}
