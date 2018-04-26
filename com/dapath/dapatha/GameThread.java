package com.dapath.dapatha;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    private static final long FRAME_TIME = 20000000;
    private static final int MAX_FPS = 50;
    private static final int MAX_FRAME_SKIPS = 5;
    private Handler handler;
    private SurfaceHolder holder;
    private boolean running;
    private GameSurface surface;

    public GameThread(GameSurface gs, SurfaceHolder h, Handler handler) {
        this.surface = gs;
        this.holder = h;
        this.handler = handler;
    }

    public void setRunning(boolean r) {
        this.running = r;
    }

    public void run() {
        Canvas canvas = null;
        while (this.running) {
            try {
                canvas = this.holder.lockCanvas();
                synchronized (this.holder) {
                    long tStart = System.nanoTime();
                    int fSkipped = 0;
                    this.surface.update(FRAME_TIME);
                    if (canvas != null) {
                        this.surface.render(canvas);
                    }
                    int tSleep = (int) (FRAME_TIME - (System.nanoTime() - tStart));
                    if (tSleep > 0) {
                        try {
                            Thread.sleep((long) (tSleep / 1000000));
                        } catch (InterruptedException e) {
                        }
                    }
                    while (tSleep < 0 && fSkipped < 5) {
                        this.surface.update(FRAME_TIME);
                        tSleep = (int) (((long) tSleep) + FRAME_TIME);
                        fSkipped++;
                    }
                }
                if (canvas != null) {
                    this.holder.unlockCanvasAndPost(canvas);
                }
            } catch (Throwable th) {
                if (canvas != null) {
                    this.holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
