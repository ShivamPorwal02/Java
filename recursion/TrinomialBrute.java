/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialBrute {
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }
        else if (n < -k || k > n) {
            return 0;
        }
        else {
            return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long a = trinomial(n, k);
        System.out.println(a);
    }
}
