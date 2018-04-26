package com.dapath.pathgen;

public class Line {
    public double ax;
    public double ay;
    public double bx;
    public double by;

    public Line(Line line) {
        this.ax = line.ax;
        this.ay = line.ay;
        this.bx = line.bx;
        this.by = line.by;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.ax = x1;
        this.ay = y1;
        this.bx = x2;
        this.by = y2;
    }

    public double getDist(double px, double py) {
        double abx = this.bx - this.ax;
        double aby = this.by - this.ay;
        double apx = px - this.ax;
        double apy = py - this.ay;
        double bpx = px - this.bx;
        double bpy = py - this.by;
        double e = (apx * abx) + (apy * aby);
        if (e <= 0.0d) {
            return (apx * apx) + (apy * apy);
        }
        double f = (abx * abx) + (aby * aby);
        if (e >= f) {
            return (bpx * bpx) + (bpy * bpy);
        }
        return ((apx * apx) + (apy * apy)) - ((e * e) / f);
    }

    public Line getClosestLine(double px, double py) {
        double abx = this.bx - this.ax;
        double aby = this.by - this.ay;
        double t = ((px - this.ax) * abx) + ((py - this.ay) * aby);
        if (t <= 0.0d) {
            return new Line(px, py, this.ax, this.ay);
        }
        double denom = (abx * abx) + (aby * aby);
        if (t >= denom) {
            return new Line(px, py, this.bx, this.by);
        }
        t /= denom;
        return new Line(px, py, this.ax + (t * abx), this.ay + (t * aby));
    }
}
