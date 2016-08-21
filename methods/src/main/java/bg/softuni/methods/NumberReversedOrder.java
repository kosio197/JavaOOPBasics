package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberReversedOrder {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        double num = Double.valueOf(str);
        br.close();
        DecimalNumber number = new DecimalNumber(num);
        // System.out.println(number.getNumberRevarsed());
        //////////////////////////////////////////////////////////////////////////////
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
        //////////////////////////////////////////////////////////////////////////////
    }

    static class DecimalNumber {
        double num;

        public DecimalNumber(double num) {
            this.num = num;
        }

        public double getNumberRevarsed() {

            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return Double.valueOf(sb.toString());
        }
    }
}
