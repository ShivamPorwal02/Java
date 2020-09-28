public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double[] a = new double[args.length - 1];
        double[] b = new double[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            a[i] = Double.parseDouble(args[i + 1]);

        }
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += a[i];
            b[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            int num = (int) (b[b.length - 1] * Math.random());
            for (int j = 0; j < a.length; j++) {
                if (num < b[j]) {
                    System.out.print((j + 1) + " ");

                    break;
                }
            }

        }
    }
}



