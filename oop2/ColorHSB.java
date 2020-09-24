/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {
    private final int hue;
    private final int sat;
    private final int bright;

    public ColorHSB(int h, int s, int b) {
        if (h >= 0 && h <= 359) {
            hue = h;
        }
        else {
            throw new IllegalArgumentException("Value not in big range");
        }
        if (s >= 0 && s <= 100) {
            sat = s;
        }
        else {
            throw new IllegalArgumentException("Value not in big range");
        }
        if (b >= 0 && b <= 100) {
            bright = b;
        }
        else {
            throw new IllegalArgumentException("Value not in big range");
        }
    }

    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    public boolean isGrayscale() {
        if (bright == 0 || sat == 0) {
            return true;
        }
        return false;
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("argument is null");
        }
        else {
            int num =
                    (int) (Math.min(Math.pow((hue - that.hue), 2),
                                    Math.pow((360 - Math.abs(hue - that.hue)), 2)))
                            + ((sat - that.sat) * (sat - that.sat)) + ((bright - that.bright) * (
                            bright - that.bright));
            return num;
        }
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB a = new ColorHSB(h, s, b);
        int min = (int) Double.POSITIVE_INFINITY;
        String name = "";
        String o = "";
        while (!StdIn.isEmpty()) {
            String S = StdIn.readString();
            int hu = StdIn.readInt();
            int sa = StdIn.readInt();
            int br = StdIn.readInt();
            ColorHSB that = new ColorHSB(hu, sa, br);
            if (that.distanceSquaredTo(a) < min) {
                min = that.distanceSquaredTo(a);
                name = S;
                o = that.toString();
            }
        }
        System.out.println(name + " " + o);
    }
}
