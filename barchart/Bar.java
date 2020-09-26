/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value is negative");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category is null");
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Argument is null");
        }
        if (value - that.value < 0) {
            return -1;
        }
        else if (value - that.value == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        /* for (int i = 0; i < bars.length; i++) {
            System.out.print(bars[i].getValue() + " ");
        } */
    }
}
