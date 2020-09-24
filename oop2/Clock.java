/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private String hour;
    private String min;

    public Clock(int h, int m) {
        if (h >= 0 && h < 24) {
            hour = Integer.toString(h);
        }
        else {
            throw new IllegalArgumentException("Not in range");
        }
        if (m >= 0 && m <= 59) {
            min = Integer.toString(m);
        }
        else {
            throw new IllegalArgumentException("Not in range");
        }
    }

    public Clock(String s) {
        if (s.length() > 4) {
            throw new IllegalArgumentException("not in length");
        }
        if (s.indexOf(":") != 2) {
            throw new IllegalArgumentException("Not in the format");
        }
        if (Integer.parseInt(s.substring(0, 2)) < 0
                || Integer.parseInt(s.substring(0, 2)) >= 24) {
            throw new IllegalArgumentException("Wrong format");
        }
        if (Integer.parseInt(s.substring(3, 5)) < 0 || Integer.parseInt(s.substring(3, 5)) > 59) {
            throw new IllegalArgumentException("Wrong Format");
        }
    }

    public String toString() {
        return hour + ":" + min;
    }

    public boolean isEarlierThan(Clock that) {
        if (Integer.parseInt(that.hour) > Integer.parseInt(hour)) {
            return true;
        }
        else if (Integer.parseInt(that.hour) == Integer.parseInt(hour)) {
            if (Integer.parseInt(that.min) > Integer.parseInt(min)) {
                return true;
            }
        }
        return false;
    }

    public void tic() {
        if (Integer.parseInt(min) < 59) {
            int x = Integer.parseInt(min);
            x += 1;
            min = Integer.toString(x);
        }
        else if (Integer.parseInt(min) == 59) {
            String s = String.format("%02d", 0);
            min = s;
            if (Integer.parseInt(hour) < 23) {
                int y = Integer.parseInt(hour);
                y += 1;
                hour = String.format("%02d", y);

            }
            else {
                hour = String.format("%02d", 0);
            }
        }
    }

    public void toc(int delta) {
        int rem = delta % 60;
        int nhrs = (Math.floorDiv(delta, 60)) % 24;
        int r = Integer.parseInt(hour) + nhrs;
        for (int i = 0; i < r; i++) {
            tic();
        }
        int s = Integer.parseInt(min) + rem;
        //min = tic(s);
    }

    public static void main(String[] args) {
        Clock c = new Clock(3, 59);
        System.out.println(c);
        //c.toc(30);
        c.tic();
        System.out.println(c);
        Clock cl = new Clock(9, 45);
        System.out.println(cl.isEarlierThan(c));


    }
}
