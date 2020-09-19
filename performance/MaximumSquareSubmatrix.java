/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int[][] b = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == 0 || j == 0) {
                    b[i][j] = a[i][j];
                }
                else if (a[i][j] == 1) {
                    b[i][j] = Math.min(b[i - 1][j], Math.min(b[i - 1][j - 1], b[i][j - 1])) + 1;
                }
                else {
                    b[i][j] = 0;
                }
            }
        }
        int max = b[0][0];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] > max) {
                    max = b[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        int num = size(a);
        System.out.println(num);
    }
}
