package com.example.najen.dapath.pathgen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public interface PathSegment {
    void draw(Canvas canvas, Paint paint, int i);

    Line[] generate();

    float getDist(Point point);

    int getLastX();

    int getLength();
}
