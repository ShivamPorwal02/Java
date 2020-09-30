public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] a = new int[n + 2];
        for (int i = 0; i < trials; i++) {
            boolean[] b = new boolean[n];
            int ct = 0;
            while (true) {
                int no = (int) (Math.random() * n);
                if (b[no]) {
                    ct++;
                    break;
                }
                b[no] = true;
                ct++;
            }
            a[ct] += 1;
        }

        for (int i = 1; i < a.length; i++) {
            double sum = 0;
            for (int j = i; j >= 1; j--) {
                sum += a[j];
            }
            double fraction = sum / trials;
            System.out.println(i + " " + a[i] + " " + fraction);
            if (fraction >= 0.5) break;
        }
    }
}
