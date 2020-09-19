/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        else if (x < 0.0) {
            return 0;
        }
        else if (x == 0.0) {
            return (double) 1 / 2;
        }
        else {
            return 1;
        }
    }

    public static double sigmoid(double x) {
        return (1 / (1 + Math.exp(-x)));
    }


    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        double a = ((Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)));
        if (Double.isNaN(a)) {
            if (x > 0) {
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            return a;
        }
    }

    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) {
            return 1;
        }
        else if (x == Double.NEGATIVE_INFINITY) {
            return -1;
        }
        else {
            return x / (1 + Math.abs(x));
        }
    }

    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        if (x <= -2) {
            return -1;
        }
        else if (x > -2 && x < 0) {
            return (x + (x * x) / 4);
        }
        else if (x >= 0 && x < 2) {
            return ((x - (x * x) / 4));
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double a = heaviside(x);
        double b = sigmoid(x);
        double c = tanh(x);
        double d = softsign(x);
        double e = sqnl(x);
        System.out.println("heaviside(" + args[0] + ") = " + a);
        System.out.println("sigmoid(" + args[0] + ") = " + b);
        System.out.println("tanh(" + args[0] + ") = " + c);
        System.out.println("softsign(" + args[0] + ") = " + d);
        System.out.println("sqnl(" + args[0] + ") = " + e);
    }
}
