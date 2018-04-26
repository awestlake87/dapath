package com.dapath.particles;

public class Fireworks {
    float maxAge;
    float maxvx;
    float maxvy;
    float minAge;
    float minvx;
    float minvy;
    int payloadCount;
    int type;

    class Payload {
        int count;
        int type;

        Payload() {
        }
    }
}
