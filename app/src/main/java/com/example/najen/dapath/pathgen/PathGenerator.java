package com.example.najen.dapath.pathgen;

import java.util.Random;

public class PathGenerator {
    public static final double STEP = 0.05000000074505806d;
    public static final int SUBDIVISIONS = 20;
    public static Random random;

    public static void init() {
        random = new Random();
    }

    public static Line genStartSeg(double prevX, double prevY, double relHeight) {
        return new Line(prevX, prevY, prevX, prevY - relHeight);
    }

    public static Line[] genCurveSeg(double prevX, double prevY, double relHeight, double offset) {
        double length = (random.nextDouble() * relHeight) + (0.44999998807907104d * relHeight);
        double y0 = prevY;
        double y1 = prevY - (((random.nextDouble() * 0.30000001192092896d) + 0.30000001192092896d) * length);
        double y2 = prevY - (((random.nextDouble() * 0.30000001192092896d) + 0.5d) * length);
        double y3 = prevY - length;
        double x0 = prevX;
        double x1 = prevX;
        double x2 = offset + (random.nextDouble() * (1.0d - (2.0d * offset)));
        double x3 = x2;
        Line[] lines = new Line[21];
        lines[0] = new Line();
        lines[0].ax = x0;
        lines[0].ay = y0;
        for (int n = 0; n < 20; n++) {
            double t = STEP * ((double) n);
            double a = 1.0d - t;
            double b = a * a;
            double c = b * a;
            lines[n].bx = (((c * x0) + (((3.0d * b) * t) * x1)) + ((((3.0d * a) * t) * t) * x2)) + (((t * t) * t) * x3);
            lines[n].by = (((c * y0) + (((3.0d * b) * t) * y1)) + ((((3.0d * a) * t) * t) * y2)) + (((t * t) * t) * y3);
            lines[n + 1] = new Line();
            lines[n + 1].ax = lines[n].bx;
            lines[n + 1].ay = lines[n].by;
        }
        lines[20].bx = x3;
        lines[20].by = y3;
        return lines;
    }

    public static Line[] genHorizontalCurveSeg(double prevX, double prevY, double relHeight) {
        double length = random.nextDouble() + 1.0d;
        double x0 = prevX;
        double x1 = prevX + (((random.nextDouble() * 0.4000000059604645d) + 0.20000000298023224d) * length);
        double x2 = prevX + (((random.nextDouble() * 0.4000000059604645d) + 0.4000000059604645d) * length);
        double x3 = prevX + length;
        double y0 = prevY;
        double y1 = prevY;
        double y2 = random.nextDouble() * relHeight;
        double y3 = y2;
        Line[] lines = new Line[21];
        lines[0] = new Line();
        lines[0].ax = x0;
        lines[0].ay = y0;
        for (int n = 0; n < 20; n++) {
            double t = STEP * ((double) n);
            double a = 1.0d - t;
            double b = a * a;
            double c = b * a;
            lines[n].bx = (((c * x0) + (((3.0d * b) * t) * x1)) + ((((3.0d * a) * t) * t) * x2)) + (((t * t) * t) * x3);
            lines[n].by = (((c * y0) + (((3.0d * b) * t) * y1)) + ((((3.0d * a) * t) * t) * y2)) + (((t * t) * t) * y3);
            lines[n + 1] = new Line();
            lines[n + 1].ax = lines[n].bx;
            lines[n + 1].ay = lines[n].by;
        }
        lines[20].bx = x3;
        lines[20].by = y3;
        return lines;
    }

    public static Line[] genTransitionJoint(double sX, double sY, double eX, double eY, int sDir, int eDir) {
        double x0 = sX;
        double y0 = sY;
        double x3 = eX;
        double y3 = eY;
        double x1 = 0.0d;
        double y1 = 0.0d;
        switch (sDir) {
            case 0:
                x1 = sX + ((sX - eX) * 0.4000000059604645d);
                y1 = y0;
                break;
            case 1:
                x1 = x0;
                y1 = sY + ((sY - eY) * 0.4000000059604645d);
                break;
            case 2:
                x1 = sX + ((eX - sX) * 0.4000000059604645d);
                y1 = y0;
                break;
            case 3:
                x1 = x0;
                y1 = sY + ((eY - sY) * 0.4000000059604645d);
                break;
        }
        double x2 = 0.0d;
        double y2 = 0.0d;
        switch (eDir) {
            case 0:
                x2 = eX + ((eX - sX) * 0.4000000059604645d);
                y2 = y3;
                break;
            case 1:
                x2 = x3;
                y2 = eY + ((eY - sY) * 0.4000000059604645d);
                break;
            case 2:
                x2 = eX + ((sX - eX) * 0.4000000059604645d);
                y2 = y3;
                break;
            case 3:
                x2 = x3;
                y2 = eY + ((sY - eY) * 0.4000000059604645d);
                break;
        }
        Line[] lines = new Line[21];
        lines[0] = new Line();
        lines[0].ax = x0;
        lines[0].ay = y0;
        for (int n = 0; n < 20; n++) {
            double t = STEP * ((double) n);
            double a = 1.0d - t;
            double b = a * a;
            double c = b * a;
            lines[n].bx = (((c * x0) + (((3.0d * b) * t) * x1)) + ((((3.0d * a) * t) * t) * x2)) + (((t * t) * t) * x3);
            lines[n].by = (((c * y0) + (((3.0d * b) * t) * y1)) + ((((3.0d * a) * t) * t) * y2)) + (((t * t) * t) * y3);
            lines[n + 1] = new Line();
            lines[n + 1].ax = lines[n].bx;
            lines[n + 1].ay = lines[n].by;
        }
        lines[20].bx = x3;
        lines[20].by = y3;
        return lines;
    }
}
