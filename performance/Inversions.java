/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    public static long count(int[] a) {
        int[] temp = new int[a.length];
        return _mergesort(a, temp, 0, a.length - 1);
    }

    public static int merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        int inver = 0;
        while ((i <= mid - 1) && (j <= right)) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = a[j++];
                inver = inver + (mid - i);
            }
        }
        while (i <= mid - 1) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        return cnt;
    }

    public static int _mergesort(int[] a, int[] temp, int left, int right) {
        int inver = 0;
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            inver += _mergesort(a, temp, left, mid);
            inver += _mergesort(a, temp, mid + 1, right);
            inver += merge(a, temp, left, mid + 1, right);
        }
        return inver;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int cnt = 0;
        int temp = 0;
        int x = 0;
        int i = a.length - 1;
        int j = a.length - 2;
        while (cnt != k) {
            if (j == x - 1) {
                i = a.length - 1;
                j = a.length - 2;
                x = x + 1;
            }
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i = i - 1;
            j = j - 1;
            cnt += 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Integer.parseInt(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(count(a));
    }

}
