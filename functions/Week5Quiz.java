/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Week5Quiz {
    public static int Q5(int n) {
        int[] b = new int[n + 1];
        b[0] = 1;
        for (int i = 2; i <= n; i++) {
            b[i] = 0;
            for (int j = 0; j < i; j++)
                b[i] += b[j];
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        return b[n];
    }

    public static void main(String[] args) {
        int a = Q5(8);
        System.out.println(a);

    }
}
