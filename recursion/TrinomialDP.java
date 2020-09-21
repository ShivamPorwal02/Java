/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (n < -k || k > n) return 0;
        long[][] a = new long[n + 1][2 * n + 2];
        a[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (2 * i + 1); j++) {
                int k1 = j;
                while (k1 >= 0 && j - k1 < 3) {
                    a[i][j] += a[i - 1][k1];
                    k1 = k1 - 1;
                }
            }
        }
        return a[n][n + k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long a = trinomial(n, k);
        System.out.println(a);

    }
}
