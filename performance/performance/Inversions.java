/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    public static long count(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int cnt = 0;
        int temp = 0;
        int x = 0;
        int i = a.length - 1;
        int j = a.length - 2;
        while (cnt != k) {
            if (j == x - 1) {
                i = a.length - 1;
                j = a.length - 2;
                x = x + 1;
            }
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i = i - 1;
            j = j - 1;
            cnt += 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Integer.parseInt(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
