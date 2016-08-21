package bg.softuni.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateModifier {

    private String firstDate;
    private String secDate;

    public DateModifier(String first, String sec) {
        this.firstDate = first;
        this.secDate = sec;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public String getSecDate() {
        return secDate;
    }

    public long getDayBetweenDate() throws ParseException {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");

        Date date = sdf.parse(firstDate);
        cal1.setTime(date);
        Date date1 = sdf.parse(secDate);
        cal2.setTime(date1);

        Date startDate = cal1.getTime();
        Date endDate = cal2.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);

        cal1.add(Calendar.DAY_OF_MONTH, (int) diffDays);
        while (cal1.before(cal2)) {
            cal1.add(Calendar.DAY_OF_MONTH, 1);
            diffDays++;
        }
        while (cal1.after(cal2)) {
            cal1.add(Calendar.DAY_OF_MONTH, -1);
            diffDays--;
        }

        return diffDays;
        // return daysBetween(cal1.getTime(), cal2.getTime());
    }

    public long daysBetween(Date d1, Date d2) {
        return ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String sec = br.readLine();
        br.close();

        DateModifier dateMod = new DateModifier(first, sec);

        long result = Math.abs(dateMod.getDayBetweenDate());

        System.out.println(result);

    }
}
