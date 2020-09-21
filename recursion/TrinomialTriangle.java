/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialTriangle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long[][] a = new long[n + 1][2 * n + 2];
        a[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (2 * i + 1); j++) {
                int k = j;
                while (k >= 0 && j - k < 3) {
                    a[i][j] += a[i - 1][k];
                    k = k - 1;
                }
            }
        }
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (2 * n + 1); j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


    }
}
