/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {
    private static void Tower(int n, int k, char e, char f, char g) {
        if (n == 0) return;
        Tower(n - 1, k, e, g, f);
        System.out.println("Move disc " + (n + k) + " from " + e + " to " + g);
        Tower(n - 1, k, f, e, g);
    }

    private static void Reves(int n, char a, char b, char c, char d) {
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + a + " to " + d);
            return;
        }
        int k = (int) (Math.round(n + 1.0 - Math.sqrt(2 * n + 1.0)));
        Reves(k, a, d, c, b);
        Tower(n - k, k, a, c, d);
        Reves(k, b, a, c, d);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Reves(n, 'A', 'B', 'C', 'D');

    }
}
