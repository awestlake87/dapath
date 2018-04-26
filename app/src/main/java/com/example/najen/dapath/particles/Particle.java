package com.example.najen.dapath.particles;

public class Particle {
    public float ax;
    public float ay;
    public float fx;
    public float fy;
    public float invm;
    public float vx;
    public float vy;
    public float f1x;
    public float f2y;

    public void update(float t) {
        this.f1x += this.vx * t;
        this.f2y += this.vy * t;
        float ray = this.ay + (this.fy * this.invm);
        this.vx += (this.ax + (this.fx * this.invm)) * t;
        this.vy += ray * t;
    }

    public void addForce(float fx, float fy) {
        this.fx += fx;
        this.fy += fy;
    }
}
