/* ***************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 ************************** */

import java.awt.Color;

public class KernelFilter {

    public static Picture identity(Picture picture) {
        double[][] w = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        picture = kernel(picture, w);
        return picture;
    }

    public static Picture gaussian(Picture picture) {
        double[][] w = {
                { 1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0 }, { 1.0 / 8.0, 1.0 / 4.0, 1.0 / 8.0 },
                { 1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0 }
        };
        picture = kernel(picture, w);
        return picture;
    }

    public static Picture sharpen(Picture picture) {
        double[][] w = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        picture = kernel(picture, w);
        return picture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] w = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        picture = kernel(picture, w);
        return picture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] w = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        picture = kernel(picture, w);
        return picture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] w = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    w[i][j] = 1.0 / 9.0;
                }
                else {
                    w[i][j] = 0;
                }
            }
        }
        picture = kernel(picture, w);
        return picture;
    }

    private static Picture kernel(Picture picture, double[][] weights) {
        int h = picture.height();
        int w = picture.width();
        Picture p = new Picture(w, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                double filterRed = 0;
                double filterGreen = 0;
                double filterBlue = 0;
                for (int k = 0, s = i - (weights.length / 2); k < weights.length; k++, s++) {
                    for (int l = 0, e = j - (weights[0].length / 2); l < weights[0].length;
                         l++, e++) {
                        if (s < 0) {
                            s = Math.max(h - Math.abs(s), 0);
                        }
                        if (s >= h) {
                            s = Math.abs(s - h);
                        }
                        if (e < 0) {
                            e = Math.max(w - Math.abs(e), 0);
                        }
                        if (e >= w) {
                            e = Math.abs(e - w);
                        }
                        Color c = picture.get(e, s);
                        filterBlue += (c.getBlue() * (weights[k][l]));
                        filterGreen += (c.getGreen() * (weights[k][l]));
                        filterRed += (c.getRed() * (weights[k][l]));
                    }
                }
                if (filterRed > 255) filterRed = 255;
                else if (filterRed < 0) filterRed = 0;
                if (filterGreen > 255) filterGreen = 255;
                else if (filterGreen < 0) filterGreen = 0;
                if (filterBlue > 255) filterBlue = 255;
                else if (filterBlue < 0) filterBlue = 0;
                Color filterColor = new Color((int) (Math.round(filterRed)),
                                              (int) (Math.round(filterGreen)),
                                              (int) (Math.round(filterBlue)));
                p.set(j, i, filterColor);
            }

        }
        return p;

    }

    public static void main(String[] args) {
        String filename = args[0];
        Picture p = new Picture(filename);
        p.show();
        System.out.println(p.width());
        System.out.println(p.height());
        Picture c = sharpen(p);
        c.show();
        Picture d = identity(p);
        d.show();
        Picture e = gaussian(p);
        e.show();
        Picture f = laplacian(p);
        f.show();
        Picture g = emboss(p);
        g.show();
        Picture h = motionBlur(p);
        h.show();


    }
}
