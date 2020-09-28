public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ///String[][] a = new String[n][n];
        int[] a = new int[n];
        int i = 0;
        // System.out.println((int) (Math.log(8) / Math.log(2)));
        while (i < (int) (Math.log(n) / Math.log(2))) {
            for (int j = 0; j < (int) (Math.pow(2, i)); j++) {
                a[(int) (Math.pow(2, i)) + j] = (~a[j] & 1);
                System.out.println(a[i] + " " + (int) (Math.pow(2, i)) + j);
            }
            i = i + 1;
        }
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.print("+" + "  ");

                } else {
                    System.out.print("-" + "  ");
                }
            }
            System.out.println();
        }
    }
}
