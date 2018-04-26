package com.example.najen.dapath;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.example.najen.dapath.gamemodes.Game;
import com.example.najen.dapath.gamemodes.ModeProfile;

public class GameSurface extends SurfaceView implements Callback {
    Context context;
    Game game;
    Handler handler;
    public int height;
    SurfaceHolder holder = getHolder();
    int mode;
    ModeProfile profile;
    boolean released;
    public int width;

    public GameSurface(Context context, Handler handler) {
        super(context);
        this.context = context;
        this.handler = handler;
        this.holder.addCallback(this);
        setFocusable(true);
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.holder;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Canvas c = holder.lockCanvas();
        c.drawColor(ViewCompat.MEASURED_STATE_MASK);
        holder.unlockCanvasAndPost(c);
        this.width = getWidth();
        this.height = getHeight();
        if (this.game == null) {
            Message msg = new Message();
            msg.arg1 = 3;
            this.handler.sendMessage(msg);
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.released = false;
        if (event.getAction() == 1) {
            if (this.game != null) {
                this.game.setContact(false);
                this.released = true;
            }
        } else if (event.getAction() == 0 && this.game != null) {
            this.game.setContact(true);
        }
        if (this.game != null) {
            this.game.setTouch(event.getX(), event.getY());
        }
        return true;
    }

    public void update(long eNano) {
        if (this.game != null) {
            this.game.update(eNano);
        }
    }

    public void render(Canvas canvas) {
        if (canvas != null && this.game != null) {
            this.game.render(canvas);
        }
    }
}
