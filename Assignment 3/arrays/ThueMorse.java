public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ///String[][] a = new String[n][n];
        int[] a = new int[n];
        int i = 0;
        while (i < Math.log(n)) {
            for (int j = 0; j < (Math.pow(2, i)); j++) {
                a[(int) (Math.pow(2, i)) + j] = (~a[j] & 1);
            }
            i = i + 1;
        }
        ///System.out.println();
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
