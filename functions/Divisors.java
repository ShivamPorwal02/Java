/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a > b) {
            while (b > 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        else if (a < b) {
            while (a > 0) {
                int temp = a;
                a = b % a;
                b = temp;
            }
            return b;
        }
        else {
            return a;
        }
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        else {
            return ((Math.abs(a) / gcd(a, b)) * Math.abs(b));
        }
    }

    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int totient(int n) {
        int cnt = 0;
        if (n <= 0) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) {
                cnt = cnt + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int l = gcd(n, m);
        int k = lcm(n, m);
        boolean a = areRelativelyPrime(n, m);
        int t1 = totient(n);
        int t2 = totient(m);
        System.out.println("gcd(" + args[0] + ", " + args[1] + ") = " + l);
        System.out.println("lcm(" + args[0] + ", " + args[1] + ") = " + k);
        System.out.println("areRelativelyPrime(" + args[0] + ", " + args[1] + ") = " + a);
        System.out.println("totient(" + args[0] + ") = " + t1);
        System.out.println("totient(" + args[1] + ") = " + t2);

    }

}
