/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    public static double[] reverse(double[] a) {
        double[] c = new double[a.length];

        for (int i = a.length - 1, j = 0;
             i >= 0;
             i--, j++) {
            c[j] = a[i];
        }
        return c;
    }

    public static double[] merge(double[] a, double[] b) {

        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];

        }
        for (int i = 0, j = a.length;
             i < b.length;
             i++, j++) {
            c[j] = b[i];
        }
        return c;

    }

    public static double[] mix(double[] a, double[] b) {
        if (a.length > b.length) {
            double[] c = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = b.length; i < a.length; i++) {
                c[i] = a[i];
            }
            return c;
        }
        else {
            double[] c = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = a.length; i < b.length; i++) {
                c[i] = b[i];
            }
            return c;
        }

    }

    public static double[] changeSpeed(double[] a, double alpha) {
        double div = a.length / alpha;
        double[] c = new double[(int) Math.floor(div)];
        for (int i = 0; i < c.length; i++) {
            double d = Math.floor((double) (i) * alpha);
            c[i] = a[(int) (d)];
        }
        return c;

    }

    public static void main(String[] args) {
        double[] samples = StdAudio.read("cow.wav");
        double[] sample = StdAudio.read("beatbox.wav");
        double[] a = changeSpeed(sample, 2);
        int N = (int) (44100 * 11.0);
        double[] b = new double[N + 1];
        int j = 0;
        for (int i = 1; i <= N; i++) {
            if (j >= a.length) {
                j = 0;
            }
            b[i] = a[j];
            j = j + 1;
        }
        StdAudio.play(b);
    }
}
