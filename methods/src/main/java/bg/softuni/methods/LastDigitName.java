package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
        br.close();
        Number number = new Number(num);
        System.out.println(number.getLastDigitNeme());
    }

    static class Number {

        private int num;

        public Number(int num) {
            this.num = num;
        }

        public String getLastDigitNeme() {
            int digit = num % 10;
            digit = digit > 0 ? digit : digit * (-1);
            switch (digit) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            }
            return "";
        }
    }
}

