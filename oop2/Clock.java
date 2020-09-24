/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private int hour;
    private int min;

    public Clock(int h, int m) {
        if (h >= 0 && h < 24) {
            hour = h;
        }
        else {
            throw new IllegalArgumentException("Not in range");
        }
        if (m >= 0 && m <= 59) {
            min = m;
        }
        else {
            throw new IllegalArgumentException("Not in range");
        }
    }

    public Clock(String s) {
        if (s.indexOf(":") != 2) {
            throw new IllegalArgumentException("Not in the format");
        }
        if (Integer.parseInt(s.substring(0, 2)) < 0
                || Integer.parseInt(s.substring(0, 2) >= 24) {
            throw new IllegalArgumentException("Wrong format");
        }
        if (Integer.parseInt(s.substring(3, 5)) < 0 || Integer.parseInt(s.substring(3, 5)) > 59) {
            throw new IllegalArgumentException("Wrong Format");
        }

    }

    public String toString() {

    }

    public boolean isEarlierThan(Clock that) {


    }

    public void tic() {
        if (min < 59) {
            min += 1;
        }
        else if (min == 59) {
            String s = String.format("%02d", 0);
            min = Integer.parseInt(s);
            if (hour < 23) {
                hour += 1
            }
        }
    }

    public void toc(int delta) {

    }

    public static void main(String[] args) {

    }
}
