/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {
    public static int maxRepeats(String dna) {
        int j = 0;
        int i = 0;
        int[] a = new int[(dna.length() / 2)];
        int k = (dna.indexOf("CAG"));
        int index = k;
        a[0] = dna.indexOf("CAG");
        while (j < dna.length() && dna.indexOf("CAG", k + 1) != -1) {
            i = i + 1;
            k = dna.indexOf("CAG", k + 1);
            a[i] = k;
            j = j + 1;
        }
        int x = 0;
        int flag = 1;
        int max = 0;
        while (x < a.length) {
            while (a[x + 1] == a[x] + 3) {
                flag += 1;
                x = x + 1;
            }
            if (flag >= max) {
                max = flag;
            }
            if (a[x + 1] == a[x]) {
                break;
            }
            flag = 1;
            x = x + 1;
        }
        if (index == -1) {
            return 0;
        }
        return max;
    }

    public static String removeWhitespace(String s) {
        String a = s.replace(" ", "");
        a = a.replace("\n", "");
        a = a.replace("\t", "");
        return a;

    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) {
            return "not human";
        }
        else if (maxRepeats >= 10 && maxRepeats <= 35) {
            return "normal";
        }
        else if (maxRepeats >= 36 && maxRepeats <= 39) {
            return "high risk";
        }
        else if (maxRepeats >= 40 && maxRepeats <= 180) {
            return "Huntington's";
        }
        else {
            return "not human";
        }

    }

    public static void main(String[] args) {
        String name = args[0];
        String d = "";
        //System.out.println("shivam");
        In in = new In(name);
        while (!in.isEmpty()) {
            d = in.readAll();
        }
        String a = removeWhitespace(d);
        System.out.println("max repeats = " + maxRepeats(a));
        System.out.println(diagnose(maxRepeats(a)));

    }
}
