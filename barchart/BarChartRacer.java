/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        
        String name = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(name);
        String title = in.readLine();
        String xaxis = in.readLine();
        String source = in.readLine();
        BarChart chart = new BarChart(title, xaxis, source);
        String caption = "";
        while (!in.isEmpty()) {
            String space = in.readLine();
            int n = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String y = in.readLine();
                String[] str = y.split(",");
                bars[i] = new Bar(str[1], Integer.parseInt(str[3]), str[4]);
                caption = str[0];
            }
            Arrays.sort(bars);
            chart.setCaption(caption);
            for (int i = 0, j = bars.length - 1; i < k; i++, j--) {
                chart.add(bars[j].getName(), bars[j].getValue(), bars[j].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1);
            chart.reset();
            // StdDraw.show();

        }
    }
}
