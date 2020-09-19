/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int cnt = 0;
        long i = 0;
        long j = Math.round(Math.cbrt(n));
        while (i < j) {
            long sum = (i * i * i) + (j * j * j);
            if (sum > n) {
                j = j - 1;
            }
            else if (sum < n) {
                i = i + 1;
            }
            else {
                cnt += 1;
                i = i + 1;
                j = j + 1;
            }

        }
        return (cnt >= 2);
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
