/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.square(x, y, length / 2);
        //ye islia kia hai kyuki filled square half lenght leta hai....
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        draw(n - 1, x - length / 2, y + length / 2, length / 2);
        draw(n - 1, x + length / 2, y + length / 2, length / 2);
        drawSquare(x, y, length);
        draw(n - 1, x - length / 2, y - length / 2, length / 2);
        draw(n - 1, x + length / 2, y - length / 2, length / 2);
        //System.out.println(x + " " + y);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);


    }
}
