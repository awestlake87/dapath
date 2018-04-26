package com.example.najen.dapath.gamemodes;

import com.example.najen.dapath.pathgen.Line;
import java.util.LinkedList;

public class Transition {
    int endDir;
    float endFrameX;
    float endFrameY;
    float endPathX;
    float endPathY;
    float endVel;
    float height;
    LinkedList<Line> segments;
    int startDir;
    float startVel;
    float width;

    public Transition(float width, float height, float endFrameX, float endFrameY, float endPathX, float endPathY, float startVel, float endVel, int startDir, int endDir, LinkedList<Line> segments) {
        this.width = width;
        this.height = height;
        this.endFrameX = endFrameX;
        this.endFrameY = endFrameY;
        this.endPathX = endPathX;
        this.endPathY = endPathY;
        this.startVel = startVel;
        this.endVel = endVel;
        this.startDir = startDir;
        this.endDir = endDir;
        this.segments = segments;
    }
}
