public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] a = new String[m][n];
        boolean[][] b = new boolean[m + 2][n + 2];
        int i = 0;
        while (i < k) {
            int mi = (int) (m * Math.random());
            int mj = (int) (n * Math.random());
            if (b[mi + 1][mj + 1] == false) {
                a[mi][mj] = "*";
                b[mi + 1][mj + 1] = true;
                i = i + 1;
            }
        }
        int cnt = 0;
        for (i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] != "*") {
                    cnt = 0;
                    for (int k1 = i - 1; k1 <= i + 1; k1++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (b[k1][l] == true) {
                                cnt += 1;
                            }
                        }
                    }
                    a[i - 1][j - 1] = Integer.toString(cnt);
                } else {
                    a[i - 1][j - 1] = "*";
                }
            }
        }


        for (i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

