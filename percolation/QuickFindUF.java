/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class QuickFindUF {
    // Eager Approach

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    public void union(int a, int b) {
        int aid = id[a];
        int bid = id[b];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == aid) {
                id[i] = bid;
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt()
        QuickFindUF w = new QuickFindUF(n);

    }
}
