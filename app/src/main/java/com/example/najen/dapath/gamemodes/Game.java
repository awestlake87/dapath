package com.example.najen.dapath.gamemodes;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.example.najen.dapath.Main;
import com.example.najen.dapath.pathgen.Line;
import com.example.najen.dapath.pathgen.PathGenerator;
//import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    float APProgress;
    public int BombsDetonated;
    LinkedList<Collider> Colliders;
    boolean Collisions;
    float DeltaXPos;
    float DeltaYPos;
    boolean Fail;
    public int Fattenings;
    public int Flips;
    public String GameModeName;
    boolean Generate;
    LinkedList<Generator> Generators;
    public int HighestMult;
    float IconX;
    float IconY;
    LinkedList<Icon> Icons = new LinkedList();
    boolean InContact;
    ModeProfile InitialProfile;
    boolean IsColliding;
    float MBProgress;
    Handler MainHandler;
    public int MathsCollected;
    int Multiplier;
    boolean Pause;
    boolean PauseBarTouched;
    Rect PauseRect;
    LinkedList<PowerUp> PowerUps = new LinkedList();
    public int PowerUpsCollected;
    boolean PrevContact;
    float PrevTouchX;
    float PrevTouchY;
    ModeProfile Profile;
    LinkedList<Renderer> Renderers;
    boolean Reset;
    double Score;
    float ScoreMult;
    LinkedList<Updater> ScoreUpdaters;
    boolean Scoring;
    LinkedList<Line> Segments;
    public int SupaSlows;
    double Time;
    float TimeMult;
    float TouchX;
    float TouchY;
    LinkedList<Updater> Updaters;
    Random random;

    interface Collider {
        void detectCollisions(double d);
    }

    interface Generator {
        void generate();

        void start();
    }

    interface Icon {
        void activate();

        boolean contains(float f, float f2);

        float getR();

        float getX();

        float getY();

        void render(Canvas canvas);

        void testCollisions(double d);

        void update(double d);
    }

    interface PowerUp {
        void activate();

        void deactivate();

        void generateIcon();

        int getId();

        boolean isActivated();

        boolean isGenerated();

        void update(double d);
    }

    interface Renderer {
        void render(Canvas canvas);
    }

    interface Updater {
        void update(double d);
    }

    public class ApplierUpdater implements Updater {
        public ApplierUpdater() {
            Message msg = new Message();
            msg.arg1 = 5;
            msg.arg2 = (int) Game.this.APProgress;
            Game.this.MainHandler.sendMessage(msg);
        }

        public void update(double t) {
            Message msg = new Message();
            Game game = Game.this;
            game.APProgress = (float) (((double) game.APProgress) + (((double) Game.this.Profile.AppGrowthRate) * t));
            if (Game.this.APProgress > Game.this.Profile.AppBarMax) {
                msg.arg1 = 7;
                msg.arg2 = (int) (((float) Game.this.Profile.scorebarFlashDur) / Game.this.TimeMult);
                Game.this.MainHandler.sendMessage(msg);
                game = Game.this;
                game.APProgress -= Game.this.Profile.AppBarMax;
                game = Game.this;
                game.Score *= ((double) Game.this.Multiplier) / 5.0d;
            }
            msg = new Message();
            msg.arg1 = 5;
            msg.arg2 = (int) Game.this.APProgress;
            Game.this.MainHandler.sendMessage(msg);
        }
    }

    public class DaBomb implements PowerUp {
        boolean activated;
        boolean generated;
        Icon icon;
        double time;

        public void generateIcon() {
            if (Game.this.random.nextFloat() < Game.this.Profile.DaBombChance) {
                this.generated = true;
                this.icon = new DaBombIcon(this);
                Game.this.Icons.add(this.icon);
            }
        }

        public void activate() {
            this.activated = true;
            Game game = Game.this;
            game.Score *= (double) Game.this.Profile.DaBombMult;
            game = Game.this;
            game.BombsDetonated++;
            game = Game.this;
            game.PowerUpsCollected++;
        }

        public void update(double t) {
        }

        public boolean isGenerated() {
            return this.generated;
        }

        public void deactivate() {
            Game.this.Icons.remove(this.icon);
            this.generated = false;
            this.activated = false;
        }

        public boolean isActivated() {
            return this.activated;
        }

        public int getId() {
            return 0;
        }
    }

    public class DaBombIcon implements Icon {
        LinkedList<Line> Fuse = new LinkedList();
        public Rect clipRect;
        public Rect defaultRect;
        float ealpha;
        public boolean exploding;
        public float explosionRadius;
        public boolean fusetouch;
        public boolean justCreated;
        public PowerUp powerup;
        public float f54r;
        float salpha;
        public float shockwaveRadius;
        public float time;
        public boolean visible;
        public float f55x;
        public float f56y;

        public DaBombIcon(PowerUp powerup) {
            Line line = (Line) Game.this.Segments.getLast();
            this.Fuse.add(new Line(line));
            this.justCreated = true;
            for (int i = 0; i < Game.this.Profile.DaBombPathGens; i++) {
                Game.this.generate();
            }
            Iterator<Line> iterator = Game.this.Segments.iterator();
            boolean addfuse = false;
            while (!addfuse && iterator.hasNext()) {
                if (((Line) iterator.next()).equals(line)) {
                    addfuse = true;
                }
            }
            while (iterator.hasNext()) {
                this.Fuse.add(new Line((Line) iterator.next()));
            }
            this.f55x = (float) ((Line) this.Fuse.getLast()).bx;
            this.f56y = (float) ((Line) this.Fuse.getLast()).by;
            this.f54r = Main.iconRadius;
            this.explosionRadius = this.f54r;
            this.shockwaveRadius = this.f54r;
            this.ealpha = 0.0f;
            this.salpha = 0.0f;
            this.powerup = powerup;
            this.visible = true;
            this.defaultRect = new Rect(0, 0, (int) Game.this.Profile.Width, (int) Game.this.Profile.Height);
            this.clipRect = new Rect(this.defaultRect);
        }

        public void update(double t) {
            if (this.justCreated) {
                this.justCreated = false;
                return;
            }
            this.time = (float) (((double) this.time) + t);
            this.f55x += Game.this.DeltaXPos;
            this.f56y += Game.this.DeltaYPos;
            if (this.fusetouch) {
                this.clipRect = new Rect(0, 0, (int) Game.this.Profile.Width, (int) (Game.this.TouchY * Game.this.Profile.Width));
            } else if (this.exploding) {
                this.clipRect = new Rect(0, 0, 0, 0);
            } else if (this.clipRect.bottom < this.defaultRect.bottom) {
                Rect rect = this.clipRect;
                rect.bottom = (int) (((float) rect.bottom) + (Game.this.DeltaYPos * Game.this.Profile.Width));
            } else {
                this.clipRect = new Rect(this.defaultRect);
            }
            Iterator<Line> iterator = this.Fuse.iterator();
            while (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                segment.ax += (double) Game.this.DeltaXPos;
                segment.ay += (double) Game.this.DeltaYPos;
                segment.bx += (double) Game.this.DeltaXPos;
                segment.by += (double) Game.this.DeltaYPos;
            }
            if (this.exploding) {
                this.explosionRadius = this.f54r + (((float) Math.sqrt((double) (this.time * 0.5f))) * 2.0f);
                this.shockwaveRadius = this.f54r + (this.time * 4.0f);
                this.salpha = this.time / (Game.this.Profile.DaBombSlowTime + Game.this.Profile.DaBombTransTime);
                if (this.time < Game.this.Profile.DaBombSlowTime) {
                    Game.this.TimeMult = Game.this.Profile.DaBombTimeMult;
                } else if (this.time < Game.this.Profile.DaBombSlowTime + Game.this.Profile.DaBombTransTime) {
                    this.ealpha = (this.time - Game.this.Profile.DaBombSlowTime) / Game.this.Profile.DaBombTransTime;
                    Game.this.TimeMult = Game.this.Profile.DaBombTimeMult + ((Game.this.Profile.InitTimeMult - Game.this.Profile.DaBombTimeMult) * this.ealpha);
                } else {
                    Game.this.TimeMult = Game.this.Profile.InitTimeMult;
                    this.ealpha = /*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0f;
                    this.salpha = /*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0f;
                    this.powerup.deactivate();
                }
            }
            if (this.f56y > Game.this.Profile.RelHeight + this.f54r && !this.exploding) {
                this.powerup.deactivate();
            }
        }

        public void render(Canvas canvas) {
            Iterator<Line> iterator = this.Fuse.iterator();
            canvas.clipRect(this.clipRect, Op.REPLACE);
            while (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                canvas.drawLine((float) (segment.ax * ((double) Game.this.Profile.Width)), (float) (segment.ay * ((double) Game.this.Profile.Width)), (float) (segment.bx * ((double) Game.this.Profile.Width)), (float) (segment.by * ((double) Game.this.Profile.Width)), Game.this.Profile.FusePaint);
            }
            canvas.clipRect(this.defaultRect, Op.REPLACE);
            if (this.visible) {
                Game.this.Profile.IconFillPaint.setColor(Game.this.Profile.BackColor);
                canvas.drawCircle(this.f55x * Game.this.Profile.Width, this.f56y * Game.this.Profile.Width, this.f54r * Game.this.Profile.Width, Game.this.Profile.IconFillPaint);
                canvas.drawBitmap(Main.bmpDaBomb, new Rect(0, 0, Main.bmpDaBomb.getWidth(), Main.bmpDaBomb.getHeight()), new Rect((int) ((this.f55x - this.f54r) * Game.this.Profile.Width), (int) ((this.f56y - this.f54r) * Game.this.Profile.Width), (int) ((this.f55x + this.f54r) * Game.this.Profile.Width), (int) ((this.f56y + this.f54r) * Game.this.Profile.Width)), null);
            }
            if (this.exploding) {
                Game.this.Profile.ExplosionPaint.setShader(new RadialGradient(this.f55x * Game.this.Profile.Width, this.f56y * Game.this.Profile.Width, this.explosionRadius * Game.this.Profile.Width, 0, Main.foreground - (((int) (255.0f * this.ealpha)) << 24), TileMode.CLAMP));
                canvas.drawCircle(this.f55x * Game.this.Profile.Width, this.f56y * Game.this.Profile.Width, this.explosionRadius * Game.this.Profile.Width, Game.this.Profile.ExplosionPaint);
                Game.this.Profile.ShockwavePaint.setAlpha(255 - ((int) (255.0f * this.salpha)));
                canvas.drawCircle(this.f55x * Game.this.Profile.Width, this.f56y * Game.this.Profile.Width, this.shockwaveRadius * Game.this.Profile.Width, Game.this.Profile.ShockwavePaint);
            }
            if (this.fusetouch) {
                canvas.drawBitmap(Main.bmpLensFlare, new Rect(0, 0, Main.bmpLensFlare.getWidth(), Main.bmpLensFlare.getHeight()), new Rect((int) ((Game.this.TouchX - 0.6f) * Game.this.Profile.Width), (int) ((Game.this.TouchY - 0.6f) * Game.this.Profile.Width), (int) ((Game.this.TouchX + 0.6f) * Game.this.Profile.Width), (int) ((Game.this.TouchY + 0.6f) * Game.this.Profile.Width)), null);
            }
        }

        public boolean contains(float x, float y) {
            float dx = this.f55x - x;
            float dy = this.f56y - y;
            if ((dx * dx) + (dy * dy) < this.f54r * this.f54r) {
                return true;
            }
            return false;
        }

        public float getX() {
            return this.f55x;
        }

        public float getY() {
            return this.f56y;
        }

        public float getR() {
            return this.f54r;
        }

        public void activate() {
            if (this.fusetouch && !this.powerup.isActivated()) {
                this.powerup.activate();
                this.visible = false;
                this.exploding = true;
                this.time = 0.0f;
                this.fusetouch = false;
            }
        }

        public void testCollisions(double t) {
            if (Game.this.InContact && ((double) Game.this.TouchY) < ((Line) this.Fuse.getFirst()).ay && ((double) Game.this.PrevTouchY) > ((Line) this.Fuse.getFirst()).ay) {
                this.fusetouch = true;
            }
            if (this.fusetouch && !Game.this.InContact) {
                this.fusetouch = false;
            }
        }
    }

    public class DaFattening implements PowerUp {
        boolean activated;
        float deltar;
        boolean generated;
        Icon icon;
        double time;

        public void generateIcon() {
            if (Game.this.random.nextFloat() < Game.this.Profile.DaFatteningChance) {
                this.generated = true;
                this.icon = new DaFatteningIcon((float) ((Line) Game.this.Segments.getLast()).bx, (float) ((Line) Game.this.Segments.getLast()).by, Main.iconRadius, this);
                Game.this.Icons.add(this.icon);
            }
        }

        public void activate() {
            this.time = 0.0d;
            this.activated = true;
            this.deltar = (Game.this.InitialProfile.PathRadius * Game.this.Profile.DaFatteningMult) - Game.this.InitialProfile.PathRadius;
        }

        public void update(double t) {
            if (this.activated) {
                this.time += t;
                float a;
                if (this.time < ((double) Game.this.Profile.DaFatteningTransTime)) {
                    a = (float) (this.time / ((double) Game.this.Profile.DaFatteningTransTime));
                    Game.this.Profile.PathRadius = Game.this.InitialProfile.PathRadius + (this.deltar * a);
                    Game.this.Profile.EpsilonRadius = Game.this.Profile.PathRadius + Game.this.Profile.TouchRadius;
                    Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
                    Game.this.Profile.PathPaint.setStrokeWidth((Game.this.Profile.PathRadius * 2.0f) * Game.this.Profile.Width);
                } else if (this.time < ((double) (Game.this.Profile.DaFatteningDuration + Game.this.Profile.DaFatteningTransTime))) {
                    Game.this.Profile.PathRadius = Game.this.InitialProfile.PathRadius * Game.this.Profile.DaFatteningMult;
                    Game.this.Profile.EpsilonRadius = Game.this.Profile.PathRadius + Game.this.Profile.TouchRadius;
                    Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
                    Game.this.Profile.PathPaint.setStrokeWidth((Game.this.Profile.PathRadius * 2.0f) * Game.this.Profile.Width);
                } else if (this.time < ((double) (Game.this.Profile.DaFatteningDuration + (Game.this.Profile.DaFatteningTransTime * 2.0f)))) {
                    a = (float) (((this.time - ((double) Game.this.Profile.DaFatteningDuration)) - ((double) Game.this.Profile.DaFatteningTransTime)) / ((double) Game.this.Profile.DaFatteningTransTime));
                    Game.this.Profile.PathRadius = Game.this.InitialProfile.PathRadius + (this.deltar * (/*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0f - a));
                    Game.this.Profile.EpsilonRadius = Game.this.Profile.PathRadius + Game.this.Profile.TouchRadius;
                    Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
                    Game.this.Profile.PathPaint.setStrokeWidth((Game.this.Profile.PathRadius * 2.0f) * Game.this.Profile.Width);
                } else {
                    this.activated = false;
                    Game.this.Profile.PathRadius = Game.this.InitialProfile.PathRadius;
                    Game.this.Profile.EpsilonRadius = Game.this.Profile.PathRadius + Game.this.Profile.TouchRadius;
                    Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
                    Game.this.Profile.PathPaint.setStrokeWidth((Game.this.Profile.PathRadius * 2.0f) * Game.this.Profile.Width);
                }
            }
        }

        public boolean isGenerated() {
            return this.generated;
        }

        public void deactivate() {
            this.generated = false;
            Game.this.Icons.remove(this.icon);
        }

        public boolean isActivated() {
            return this.activated;
        }

        public int getId() {
            return 2;
        }
    }

    public class DaFatteningIcon implements Icon {
        public PowerUp powerup;
        public float f57r;
        public boolean visible = true;
        public float f58x;
        public float f59y;

        public DaFatteningIcon(float x, float y, float r, PowerUp powerup) {
            this.f58x = x;
            this.f59y = y;
            this.f57r = r;
            this.powerup = powerup;
        }

        public void update(double t) {
            this.f58x += Game.this.DeltaXPos;
            this.f59y += Game.this.DeltaYPos;
            if (this.f59y > Game.this.Profile.RelHeight + this.f57r) {
                this.powerup.deactivate();
            }
        }

        public void render(Canvas canvas) {
            if (this.visible) {
                Game.this.Profile.IconFillPaint.setColor(Game.this.Profile.BackColor);
                canvas.drawCircle(Game.this.Profile.xPos + (this.f58x * Game.this.Profile.Width), Game.this.Profile.yPos + (this.f59y * Game.this.Profile.Width), this.f57r * Game.this.Profile.Width, Game.this.Profile.IconFillPaint);
                canvas.drawBitmap(Main.bmpDaFattening, new Rect(0, 0, Main.bmpDaFattening.getWidth(), Main.bmpDaFattening.getHeight()), new Rect((int) ((this.f58x - this.f57r) * Game.this.Profile.Width), (int) ((this.f59y - this.f57r) * Game.this.Profile.Width), (int) ((this.f58x + this.f57r) * Game.this.Profile.Width), (int) ((this.f59y + this.f57r) * Game.this.Profile.Width)), null);
            }
        }

        public boolean contains(float x, float y) {
            float dx = this.f58x - x;
            float dy = this.f59y - y;
            if ((dx * dx) + (dy * dy) < this.f57r * this.f57r) {
                return true;
            }
            return false;
        }

        public float getX() {
            return this.f58x;
        }

        public float getY() {
            return this.f59y;
        }

        public float getR() {
            return this.f57r;
        }

        public void activate() {
            if (!this.powerup.isActivated()) {
                this.powerup.activate();
                this.visible = false;
                Game game = Game.this;
                game.Fattenings++;
                game = Game.this;
                game.PowerUpsCollected++;
            }
        }

        public void testCollisions(double t) {
        }
    }

    public class DaFlip implements PowerUp {
        boolean activated;
        int bb;
        int bg;
        int br;
        int db;
        int dg;
        int dr;
        int fb;
        int fg;
        int fr;
        boolean generated;
        int ibb;
        int ibg;
        int ibr;
        Icon icon;
        int ifb;
        int ifg;
        int ifr;
        double time;

        public void generateIcon() {
            if (Game.this.random.nextFloat() < Game.this.Profile.DaFlipChance) {
                this.generated = true;
                this.icon = new DaFlipIcon((float) ((Line) Game.this.Segments.getLast()).bx, (float) ((Line) Game.this.Segments.getLast()).by, Main.iconRadius, this);
                Game.this.Icons.add(this.icon);
            }
        }

        public void activate() {
            this.time = 0.0d;
            this.activated = true;
            Game.this.Scoring = false;
            Game.this.Collisions = false;
            Game.this.Profile.EpsilonRadius = Game.this.Profile.PathRadius - Game.this.Profile.TouchRadius;
            Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
            Game.this.ScoreMult = Game.this.Profile.DaFlipMult;
            this.ifr = ((Main.foreground << 8) >> 24) & MotionEventCompat.ACTION_MASK;
            this.ifg = ((Main.foreground << 16) >> 24) & MotionEventCompat.ACTION_MASK;
            this.ifb = ((Main.foreground << 24) >> 24) & MotionEventCompat.ACTION_MASK;
            this.ibr = ((Main.background << 8) >> 24) & MotionEventCompat.ACTION_MASK;
            this.ibg = ((Main.background << 16) >> 24) & MotionEventCompat.ACTION_MASK;
            this.ibb = ((Main.background << 24) >> 24) & MotionEventCompat.ACTION_MASK;
            this.dr = this.ifr - this.ibr;
            this.dg = this.ifg - this.ibg;
            this.db = this.ifb - this.ibb;
            Log.d("color", this.ifr + "," + this.ifg + "," + this.ifb);
            Log.d("color", this.dr + "," + this.dg + "," + this.db);
        }

        public void update(double t) {
            if (this.activated) {
                this.time += t;
                float a;
                if (this.time < ((double) Game.this.Profile.DaFlipTransTime)) {
                    a = (float) (this.time / ((double) Game.this.Profile.DaFlipTransTime));
                    this.br = (int) (((float) this.ibr) + (((float) this.dr) * a));
                    this.bg = (int) (((float) this.ibg) + (((float) this.dg) * a));
                    this.bb = (int) (((float) this.ibb) + (((float) this.db) * a));
                    Game.this.Profile.BackColor = (((this.br << 16) + ViewCompat.MEASURED_STATE_MASK) + (this.bg << 8)) + this.bb;
                } else if (this.time < ((double) (Game.this.Profile.DaFlipTransTime * 2.0f))) {
                    a = (float) ((this.time - ((double) Game.this.Profile.DaFlipTransTime)) / ((double) Game.this.Profile.DaFlipTransTime));
                    this.fr = (int) (((float) this.ifr) - (((float) this.dr) * a));
                    this.fg = (int) (((float) this.ifg) - (((float) this.dg) * a));
                    this.fb = (int) (((float) this.ifb) - (((float) this.db) * a));
                    Game.this.Profile.PathColor = (((this.fr << 16) + ViewCompat.MEASURED_STATE_MASK) + (this.fg << 8)) + this.fb;
                } else if (this.time < ((double) (Game.this.Profile.DaFlipDuration + (Game.this.Profile.DaFlipTransTime * 2.0f)))) {
                    Game.this.Scoring = true;
                    Iterator<Line> iterator = Game.this.Segments.iterator();
                    Game.this.IsColliding = true;
                    while (iterator.hasNext()) {
                        Line segment = (Line) iterator.next();
                        if (segment.ay > ((double) (-Game.this.Profile.EpsilonRadius)) && Game.this.InContact && segment.getDist((double) Game.this.TouchX, (double) Game.this.TouchY) < ((double) Game.this.Profile.SqEpsilonRadius)) {
                            Game.this.IsColliding = false;
                        }
                    }
                    if (Game.this.InContact && Game.this.PrevContact) {
                        if (!Game.this.IsColliding) {
                            Game.this.Fail = true;
                        }
                    } else if (!Game.this.InContact) {
                        Game.this.PrevContact = false;
                    } else if (Game.this.IsColliding) {
                        Game.this.PrevContact = true;
                    } else {
                        Game.this.Fail = true;
                    }
                } else if (this.time < ((double) (Game.this.Profile.DaFlipDuration + (Game.this.Profile.DaFlipTransTime * 3.0f)))) {
                    Game.this.Scoring = false;
                    a = /*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0f - ((float) (((this.time - ((double) Game.this.Profile.DaFlipDuration)) - ((double) (Game.this.Profile.DaFlipTransTime * 2.0f))) / ((double) Game.this.Profile.DaFlipTransTime)));
                    this.br = (int) (((float) this.ibr) + (((float) this.dr) * a));
                    this.bg = (int) (((float) this.ibg) + (((float) this.dg) * a));
                    this.bb = (int) (((float) this.ibb) + (((float) this.db) * a));
                    Game.this.Profile.BackColor = (((this.br << 16) + ViewCompat.MEASURED_STATE_MASK) + (this.bg << 8)) + this.bb;
                } else if (this.time < ((double) (Game.this.Profile.DaFlipDuration + (Game.this.Profile.DaFlipTransTime * 4.0f)))) {
                    a = /*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0f - ((float) (((this.time - ((double) Game.this.Profile.DaFlipDuration)) - ((double) (Game.this.Profile.DaFlipTransTime * 3.0f))) / ((double) Game.this.Profile.DaFlipTransTime)));
                    this.fr = (int) (((float) this.ifr) - (((float) this.dr) * a));
                    this.fg = (int) (((float) this.ifg) - (((float) this.dg) * a));
                    this.fb = (int) (((float) this.ifb) - (((float) this.db) * a));
                    Game.this.Profile.PathColor = (((this.fr << 16) + ViewCompat.MEASURED_STATE_MASK) + (this.fg << 8)) + this.fb;
                } else {
                    this.activated = false;
                    Game.this.Profile.BackColor = Game.this.InitialProfile.BackColor;
                    Game.this.Profile.PathColor = Game.this.InitialProfile.PathColor;
                    Game.this.Scoring = true;
                    Game.this.ScoreMult = Game.this.Profile.InitScoreMult;
                    Game.this.Collisions = true;
                    Game.this.Profile.EpsilonRadius = Game.this.InitialProfile.EpsilonRadius;
                    Game.this.Profile.SqEpsilonRadius = Game.this.Profile.EpsilonRadius * Game.this.Profile.EpsilonRadius;
                }
            }
        }

        public boolean isGenerated() {
            return this.generated;
        }

        public void deactivate() {
            this.generated = false;
            Game.this.Icons.remove(this.icon);
        }

        public boolean isActivated() {
            return this.activated;
        }

        public int getId() {
            return 3;
        }
    }

    public class DaFlipIcon implements Icon {
        public PowerUp powerup;
        public float f60r;
        public boolean visible = true;
        public float f61x;
        public float f62y;

        public DaFlipIcon(float x, float y, float r, PowerUp powerup) {
            this.f61x = x;
            this.f62y = y;
            this.f60r = r;
            this.powerup = powerup;
        }

        public void update(double t) {
            this.f61x += Game.this.DeltaXPos;
            this.f62y += Game.this.DeltaYPos;
            if (this.f62y > Game.this.Profile.RelHeight + this.f60r) {
                this.powerup.deactivate();
            }
        }

        public void render(Canvas canvas) {
            if (this.visible) {
                Game.this.Profile.IconFillPaint.setColor(Game.this.Profile.BackColor);
                canvas.drawCircle(Game.this.Profile.xPos + (this.f61x * Game.this.Profile.Width), Game.this.Profile.yPos + (this.f62y * Game.this.Profile.Width), this.f60r * Game.this.Profile.Width, Game.this.Profile.IconFillPaint);
                canvas.drawBitmap(Main.bmpDaFlip, new Rect(0, 0, Main.bmpDaFlip.getWidth(), Main.bmpDaFlip.getHeight()), new Rect((int) ((this.f61x - this.f60r) * Game.this.Profile.Width), (int) ((this.f62y - this.f60r) * Game.this.Profile.Width), (int) ((this.f61x + this.f60r) * Game.this.Profile.Width), (int) ((this.f62y + this.f60r) * Game.this.Profile.Width)), null);
            }
        }

        public boolean contains(float x, float y) {
            float dx = this.f61x - x;
            float dy = this.f62y - y;
            if ((dx * dx) + (dy * dy) < this.f60r * this.f60r) {
                return true;
            }
            return false;
        }

        public float getX() {
            return this.f61x;
        }

        public float getY() {
            return this.f62y;
        }

        public float getR() {
            return this.f60r;
        }

        public void activate() {
            if (!this.powerup.isActivated()) {
                this.powerup.activate();
                this.visible = false;
                Game game = Game.this;
                game.Flips++;
                game = Game.this;
                game.PowerUpsCollected++;
            }
        }

        public void testCollisions(double t) {
        }
    }

    public class DaMaths implements PowerUp {
        boolean activated;
        boolean generated;
        Icon icon;
        double time;

        public void generateIcon() {
            if (Game.this.random.nextFloat() < Game.this.Profile.DaMathsChance) {
                this.generated = true;
                this.icon = new DaMathsIcon((float) ((Line) Game.this.Segments.getLast()).bx, (float) ((Line) Game.this.Segments.getLast()).by, Main.iconRadius, this);
                Game.this.Icons.add(this.icon);
            }
        }

        public void activate() {
            this.time = 0.0d;
            this.activated = true;
            Game game = Game.this;
            game.MBProgress += Game.this.Profile.DaMathsMultBar;
            game = Game.this;
            game.Multiplier = (int) (((float) game.Multiplier) + Game.this.Profile.DaMathsMultiplier);
            Message msg = new Message();
            msg.arg1 = 6;
            msg.arg2 = Game.this.Multiplier;
            Game.this.MainHandler.sendMessage(msg);
        }

        public void update(double t) {
            this.time += t;
            if (this.time > ((double) Game.this.Profile.DaMathsDuration)) {
                this.activated = false;
            }
        }

        public boolean isGenerated() {
            return this.generated;
        }

        public void deactivate() {
            this.generated = false;
            Game.this.Icons.remove(this.icon);
        }

        public boolean isActivated() {
            return this.activated;
        }

        public int getId() {
            return 4;
        }
    }

    public class DaMathsIcon implements Icon {
        public PowerUp powerup;
        public float f63r;
        public boolean visible = true;
        public float f64x;
        public float f65y;

        public DaMathsIcon(float x, float y, float r, PowerUp powerup) {
            this.f64x = x;
            this.f65y = y;
            this.f63r = r;
            this.powerup = powerup;
        }

        public void update(double t) {
            this.f64x += Game.this.DeltaXPos;
            this.f65y += Game.this.DeltaYPos;
            if (this.f65y > Game.this.Profile.RelHeight + this.f63r) {
                this.powerup.deactivate();
            }
        }

        public void render(Canvas canvas) {
            if (this.visible) {
                Game.this.Profile.IconFillPaint.setColor(Game.this.Profile.BackColor);
                canvas.drawCircle(Game.this.Profile.xPos + (this.f64x * Game.this.Profile.Width), Game.this.Profile.yPos + (this.f65y * Game.this.Profile.Width), this.f63r * Game.this.Profile.Width, Game.this.Profile.IconFillPaint);
                canvas.drawBitmap(Main.bmpDaMaths, new Rect(0, 0, Main.bmpDaMaths.getWidth(), Main.bmpDaMaths.getHeight()), new Rect((int) ((this.f64x - this.f63r) * Game.this.Profile.Width), (int) ((this.f65y - this.f63r) * Game.this.Profile.Width), (int) ((this.f64x + this.f63r) * Game.this.Profile.Width), (int) ((this.f65y + this.f63r) * Game.this.Profile.Width)), null);
            }
        }

        public boolean contains(float x, float y) {
            float dx = this.f64x - x;
            float dy = this.f65y - y;
            if ((dx * dx) + (dy * dy) < this.f63r * this.f63r) {
                return true;
            }
            return false;
        }

        public float getX() {
            return this.f64x;
        }

        public float getY() {
            return this.f65y;
        }

        public float getR() {
            return this.f63r;
        }

        public void activate() {
            if (!this.powerup.isActivated()) {
                this.powerup.activate();
                this.visible = false;
                Game game = Game.this;
                game.MathsCollected++;
                game = Game.this;
                game.PowerUpsCollected++;
            }
        }

        public void testCollisions(double t) {
        }
    }

    public class DaSupaSlow implements PowerUp {
        boolean activated;
        float deltat;
        boolean generated;
        Icon icon;
        double time;

        public void generateIcon() {
            if (Game.this.random.nextFloat() < Game.this.Profile.DaSupaSlowChance) {
                this.generated = true;
                this.icon = new DaSupaSlowIcon((float) ((Line) Game.this.Segments.getLast()).bx, (float) ((Line) Game.this.Segments.getLast()).by, Main.iconRadius, this);
                Game.this.Icons.add(this.icon);
            }
        }

        public void activate() {
            this.activated = true;
            this.time = 0.0d;
            Game.this.TimeMult = Game.this.Profile.DaSupaSlowTimeMult;
            this.deltat = Game.this.Profile.InitTimeMult - Game.this.Profile.DaSupaSlowTimeMult;
        }

        public void update(double t) {
            if (this.activated) {
                this.time += t;
                if (this.time < ((double) Game.this.Profile.DaSupaSlowDuration)) {
                    return;
                }
                if (this.time < ((double) (Game.this.Profile.DaSupaSlowDuration + Game.this.Profile.DaSupaSlowTransTime))) {
                    float a = (float) ((this.time - ((double) Game.this.Profile.DaSupaSlowDuration)) / ((double) Game.this.Profile.DaSupaSlowTransTime));
                    Game.this.TimeMult = Game.this.Profile.DaSupaSlowTimeMult + (this.deltat * a);
                    return;
                }
                Game.this.TimeMult = Game.this.Profile.InitTimeMult;
                this.activated = false;
            }
        }

        public boolean isGenerated() {
            return this.generated;
        }

        public void deactivate() {
            this.generated = false;
            Game.this.Icons.remove(this.icon);
        }

        public boolean isActivated() {
            return this.activated;
        }

        public int getId() {
            return 1;
        }
    }

    public class DaSupaSlowIcon implements Icon {
        public PowerUp powerup;
        public float f66r;
        public boolean visible = true;
        public float f67x;
        public float f68y;

        public DaSupaSlowIcon(float x, float y, float r, PowerUp powerup) {
            this.f67x = x;
            this.f68y = y;
            this.f66r = r;
            this.powerup = powerup;
        }

        public void update(double t) {
            this.f67x += Game.this.DeltaXPos;
            this.f68y += Game.this.DeltaYPos;
            if (this.f68y > Game.this.Profile.RelHeight + this.f66r) {
                this.powerup.deactivate();
            }
        }

        public void render(Canvas canvas) {
            if (this.visible) {
                Game.this.Profile.IconFillPaint.setColor(Game.this.Profile.BackColor);
                canvas.drawCircle(Game.this.Profile.xPos + (this.f67x * Game.this.Profile.Width), Game.this.Profile.yPos + (this.f68y * Game.this.Profile.Width), this.f66r * Game.this.Profile.Width, Game.this.Profile.IconFillPaint);
                canvas.drawBitmap(Main.bmpDaSupaSlow, new Rect(0, 0, Main.bmpDaSupaSlow.getWidth(), Main.bmpDaSupaSlow.getHeight()), new Rect((int) ((this.f67x - this.f66r) * Game.this.Profile.Width), (int) ((this.f68y - this.f66r) * Game.this.Profile.Width), (int) ((this.f67x + this.f66r) * Game.this.Profile.Width), (int) ((this.f68y + this.f66r) * Game.this.Profile.Width)), null);
            }
        }

        public boolean contains(float x, float y) {
            float dx = this.f67x - x;
            float dy = this.f68y - y;
            if ((dx * dx) + (dy * dy) < this.f66r * this.f66r) {
                return true;
            }
            return false;
        }

        public float getX() {
            return this.f67x;
        }

        public float getY() {
            return this.f68y;
        }

        public float getR() {
            return this.f66r;
        }

        public void activate() {
            if (!this.powerup.isActivated()) {
                this.powerup.activate();
                this.visible = false;
                Game game = Game.this;
                game.SupaSlows++;
                game = Game.this;
                game.PowerUpsCollected++;
            }
        }

        public void testCollisions(double t) {
        }
    }

    public class HCurveGen implements Generator {
        public void start() {
            Game.this.Segments = new LinkedList();
            Game.this.Segments.addAll(Arrays.asList(PathGenerator.genHorizontalCurveSeg(0.0d, (double) (0.5f * Game.this.Profile.RelHeight), (double) Game.this.Profile.RelHeight)));
            Game.this.Segments.addAll(Arrays.asList(PathGenerator.genHorizontalCurveSeg(((Line) Game.this.Segments.getLast()).bx, ((Line) Game.this.Segments.getLast()).by, (double) Game.this.Profile.RelHeight)));
        }

        public void generate() {
            Game.this.Segments.addAll(Arrays.asList(PathGenerator.genHorizontalCurveSeg(((Line) Game.this.Segments.getLast()).bx, ((Line) Game.this.Segments.getLast()).by, (double) Game.this.Profile.RelHeight)));
        }
    }

    public class HPathUpdater implements Updater {
        public void update(double t) {
            Iterator<Line> iterator = Game.this.Segments.iterator();
            while (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                segment.ax -= (double) Game.this.DeltaXPos;
                segment.bx -= (double) Game.this.DeltaXPos;
            }
            iterator = Game.this.Segments.iterator();
            if (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                while (segment.bx > 0.0d) {
                    iterator.remove();
                    if (!iterator.hasNext()) {
                        break;
                    }
                    segment = (Line) iterator.next();
                }
                while (segment.ax < ((double) (/*TextTrackStyle.DEFAULT_FONT_SCALE*/ 1.0 + Game.this.Profile.PathRadius))) {
                    if (iterator.hasNext()) {
                        segment = (Line) iterator.next();
                    } else {
                        Game.this.generate();
                        return;
                    }
                }
            }
        }
    }

    public class MultBarUpdater implements Updater {
        public MultBarUpdater() {
            Message msg = new Message();
            msg.arg1 = 4;
            msg.arg2 = (int) Game.this.MBProgress;
            Game.this.MainHandler.sendMessage(msg);
            msg = new Message();
            msg.arg1 = 6;
            msg.arg2 = Game.this.Multiplier;
            Game.this.MainHandler.sendMessage(msg);
        }

        public void update(double t) {
            Message msg;
            Game game;
            if (Game.this.InContact && Game.this.PrevContact) {
                if (Game.this.IsColliding) {
                    game = Game.this;
                    game.MBProgress = (float) (((double) game.MBProgress) + ((((double) (Game.this.Profile.MultGrowthRate / (((float) (Game.this.Multiplier + 1)) / 5.0f))) * t) * ((double) Game.this.ScoreMult)));
                    if (Game.this.MBProgress > Game.this.Profile.MultBarMax) {
                        if (Game.this.Multiplier < Game.this.Profile.MultiplierMax) {
                            game = Game.this;
                            game.Multiplier++;
                            msg = new Message();
                            msg.arg1 = 6;
                            msg.arg2 = Game.this.Multiplier;
                            Game.this.MainHandler.sendMessage(msg);
                            msg = new Message();
                            msg.arg1 = 8;
                            msg.arg2 = (int) (((float) Game.this.Profile.applierFlashDur) / Game.this.TimeMult);
                            Game.this.MainHandler.sendMessage(msg);
                        }
                        game = Game.this;
                        game.MBProgress -= Game.this.Profile.MultBarMax;
                    }
                }
            } else if (!Game.this.InContact) {
                game = Game.this;
                game.MBProgress = (float) (((double) game.MBProgress) - (((double) (Game.this.Profile.MultDecayRate * (((float) (Game.this.Multiplier + 1)) / 5.0f))) * t));
                if (Game.this.MBProgress < 0.0f) {
                    if (Game.this.Multiplier > 0) {
                        game = Game.this;
                        game.Multiplier--;
                        msg = new Message();
                        msg.arg1 = 6;
                        msg.arg2 = Game.this.Multiplier;
                        Game.this.MainHandler.sendMessage(msg);
                        msg = new Message();
                        msg.arg1 = 8;
                        msg.arg2 = (int) (((float) Game.this.Profile.applierFlashDur) / Game.this.TimeMult);
                        Game.this.MainHandler.sendMessage(msg);
                        game = Game.this;
                        game.MBProgress += Game.this.Profile.MultBarMax;
                    } else {
                        Game.this.MBProgress = 0.0f;
                    }
                }
            }
            if (Game.this.Multiplier > Game.this.HighestMult) {
                Game.this.HighestMult = Game.this.Multiplier;
            }
            msg = new Message();
            msg.arg1 = 4;
            msg.arg2 = (int) Game.this.MBProgress;
            Game.this.MainHandler.sendMessage(msg);
        }
    }

    public class PathCollider implements Collider {
        public void detectCollisions(double t) {
            Iterator<Line> iterator = Game.this.Segments.iterator();
            while (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                if (segment.ay > ((double) (-Game.this.Profile.EpsilonRadius)) && Game.this.InContact && segment.getDist((double) Game.this.TouchX, (double) Game.this.TouchY) < ((double) Game.this.Profile.SqEpsilonRadius)) {
                    Game.this.IsColliding = true;
                }
            }
            if (Game.this.InContact && Game.this.PrevContact) {
                if (!Game.this.IsColliding) {
                    Game.this.Fail = true;
                }
            } else if (Game.this.InContact) {
                if (Game.this.IsColliding) {
                    Game.this.PrevContact = true;
                } else {
                    Game.this.Fail = true;
                }
            } else if (Game.this.PrevContact && Game.this.Profile.LiftFail) {
                Game.this.Fail = true;
            } else {
                Game.this.PrevContact = false;
            }
        }
    }

    public class PathRenderer implements Renderer {
        public void render(Canvas canvas) {
            canvas.drawColor(Game.this.Profile.BackColor);
            Iterator<Line> iterator = Game.this.Segments.iterator();
            Game.this.Profile.PathPaint.setColor(Game.this.Profile.PathColor);
            while (iterator.hasNext()) {
                Line line = (Line) iterator.next();
                canvas.drawLine((float) (((double) Game.this.Profile.xPos) + (line.ax * ((double) Game.this.Profile.Width))), (float) (((double) Game.this.Profile.yPos) + (line.ay * ((double) Game.this.Profile.Width))), (float) (((double) Game.this.Profile.xPos) + (line.bx * ((double) Game.this.Profile.Width))), (float) (((double) Game.this.Profile.yPos) + (line.by * ((double) Game.this.Profile.Width))), Game.this.Profile.PathPaint);
            }
            iterator = Game.this.Segments.iterator();
        }
    }

    public class PowerUpGen implements Generator {
        int activePowerUp;
        PowerUp[] powerups;

        public void start() {
            int index = 0;
            this.powerups = new PowerUp[Game.this.PowerUps.size()];
            Iterator<PowerUp> iterator = Game.this.PowerUps.iterator();
            while (iterator.hasNext()) {
                this.powerups[index] = (PowerUp) iterator.next();
                index++;
            }
        }

        public void generate() {
            boolean generate = true;
            int p = 0;
            while (p < this.powerups.length) {
                if (this.powerups[p].isGenerated() || this.powerups[p].isActivated()) {
                    generate = false;
                }
                p++;
            }
            if (generate) {
                int chosen = Game.this.random.nextInt(this.powerups.length);
                switch (this.powerups[chosen].getId()) {
                    case 0:
                        if (Game.this.Profile.DaBombUnlocked) {
                            this.powerups[chosen].generateIcon();
                            return;
                        }
                        return;
                    case 1:
                        if (Game.this.Profile.DaSupaSlowUnlocked) {
                            this.powerups[chosen].generateIcon();
                            return;
                        }
                        return;
                    case 2:
                        if (Game.this.Profile.DaFatteningUnlocked) {
                            this.powerups[chosen].generateIcon();
                            return;
                        }
                        return;
                    case 3:
                        if (Game.this.Profile.DaFlipUnlocked) {
                            this.powerups[chosen].generateIcon();
                            return;
                        }
                        return;
                    case 4:
                        if (Game.this.Profile.DaMathsUnlocked) {
                            this.powerups[chosen].generateIcon();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public class ScoreUpdater implements Updater {
        public ScoreUpdater() {
            Message msg = new Message();
            Bundle data = new Bundle();
            msg.arg1 = 1;
            data.putLong("SCORE", (long) Game.this.Score);
            msg.setData(data);
            Game.this.MainHandler.sendMessage(msg);
        }

        public void update(double t) {
            Bundle data = new Bundle();
            Message msg = new Message();
            if (Game.this.InContact && Game.this.PrevContact) {
                float ax = Game.this.TouchX - Game.this.PrevTouchX;
                float ay = Game.this.TouchY - Game.this.PrevTouchY;
                if (Game.this.IsColliding && ay < 0.0f) {
                    Game game = Game.this;
                    game.Score += (100.0d * Math.sqrt((double) ((ax * ax) + (ay * ay)))) * ((double) Game.this.ScoreMult);
                }
            }
            msg.arg1 = 1;
            data.putLong("SCORE", (long) Game.this.Score);
            msg.setData(data);
            Game.this.MainHandler.sendMessage(msg);
        }
    }

    public class VCurveGen implements Generator {
        public void start() {
            Game.this.Segments = new LinkedList();
            Game.this.Segments.add(PathGenerator.genStartSeg(0.5d, (double) Game.this.Profile.RelHeight, (double) Game.this.Profile.RelHeight));
            Game.this.Segments.addAll(Arrays.asList(PathGenerator.genCurveSeg(((Line) Game.this.Segments.getLast()).bx, ((Line) Game.this.Segments.getLast()).by, (double) Game.this.Profile.RelHeight, (double) Game.this.Profile.PathRadius)));
        }

        public void generate() {
            Game.this.Segments.addAll(Arrays.asList(PathGenerator.genCurveSeg(((Line) Game.this.Segments.getLast()).bx, ((Line) Game.this.Segments.getLast()).by, (double) Game.this.Profile.RelHeight, (double) Game.this.Profile.PathRadius)));
        }
    }

    public class VPathUpdater implements Updater {
        public void update(double t) {
            Game game = Game.this;
            game.PrevTouchY += Game.this.DeltaYPos;
            Iterator<Line> iterator = Game.this.Segments.iterator();
            while (iterator.hasNext()) {
                Line segment = (Line) iterator.next();
                segment.ay += (double) Game.this.DeltaYPos;
                segment.by += (double) Game.this.DeltaYPos;
            }
            iterator = Game.this.Segments.iterator();
            if (iterator.hasNext()) {
                for (Line segment = (Line) iterator.next(); segment.by > ((double) Game.this.Profile.RelHeight); segment = (Line) iterator.next()) {
                    iterator.remove();
                    if (!iterator.hasNext()) {
                        break;
                    }
                }
            }
            while (iterator.hasNext()) {
                if (((Line) iterator.next()).by > ((double) (-Game.this.Profile.EpsilonRadius)) && !iterator.hasNext()) {
                    Game.this.generate();
                    return;
                }
            }
        }
    }

    public Game(String GameModeName, ModeProfile profile, Handler handler) {
        this.GameModeName = GameModeName;
        this.Profile = profile;
        this.InitialProfile = new ModeProfile(profile);
        this.MainHandler = handler;
        this.random = new Random();
        this.InContact = false;
        this.PrevContact = false;
        this.Score = 0.0d;
        this.TouchX = 0.0f;
        this.TouchY = 0.0f;
        this.Pause = this.Profile.PauseOnStart;
        this.MBProgress = this.Profile.MultBarMax / 2.0f;
        this.APProgress = 0.0f;
        this.Multiplier = this.Profile.InitMultiplier;
        this.PowerUpsCollected = 0;
        this.BombsDetonated = 0;
        this.Flips = 0;
        this.Fattenings = 0;
        this.SupaSlows = 0;
        this.MathsCollected = 0;
        this.HighestMult = 0;
        this.Time = 0.0d;
        this.Fail = false;
        this.Generate = false;
        this.TimeMult = this.Profile.InitTimeMult;
        this.ScoreMult = this.Profile.InitScoreMult;
        this.Collisions = true;
        this.Scoring = true;
        if (this.Profile.DaFattening) {
            this.PowerUps.add(new DaFattening());
        }
        if (this.Profile.DaMaths) {
            this.PowerUps.add(new DaMaths());
        }
        if (this.Profile.DaSupaSlow) {
            this.PowerUps.add(new DaSupaSlow());
        }
        if (this.Profile.DaBomb) {
            this.PowerUps.add(new DaBomb());
        }
        if (this.Profile.DaFlip) {
            this.PowerUps.add(new DaFlip());
        }
        setupGenerators();
        setupUpdaters();
        setupRenderers();
        setupColliders();
    }

    public void setupColliders() {
        this.Colliders = new LinkedList();
        if (this.Profile.Collideable) {
            this.Colliders.add(new PathCollider());
        }
    }

    public void setupRenderers() {
        this.Renderers = new LinkedList();
        this.Renderers.add(new PathRenderer());
    }

    public void setupUpdaters() {
        this.Updaters = new LinkedList();
        this.ScoreUpdaters = new LinkedList();
        switch (this.Profile.BasePathType) {
            case 0:
                this.Updaters.add(new VPathUpdater());
                break;
            case 1:
                this.Updaters.add(new HPathUpdater());
                break;
        }
        if (this.Profile.ScoreBar) {
            this.ScoreUpdaters.add(new ScoreUpdater());
        }
        if (this.Profile.ApplierBar) {
            this.ScoreUpdaters.add(new ApplierUpdater());
        }
        if (this.Profile.MultBar) {
            this.ScoreUpdaters.add(new MultBarUpdater());
        }
    }

    public void setupGenerators() {
        this.Generators = new LinkedList();
        switch (this.Profile.BasePathType) {
            case 0:
                this.Generators.add(new VCurveGen());
                break;
            case 1:
                this.Generators.add(new HCurveGen());
                break;
        }
        if (this.Profile.PowerUps) {
            this.Generators.add(new PowerUpGen());
        }
        Iterator<Generator> iterator = this.Generators.iterator();
        while (iterator.hasNext()) {
            ((Generator) iterator.next()).start();
        }
    }

    public void update(long eNano) {
        Message msg;
        if (this.Profile.PauseBar && !this.Fail) {
            if (this.Pause) {
                if (this.PauseRect != null && this.PrevContact && this.PauseRect.contains((int) (this.PrevTouchX * this.Profile.Width), (int) (this.PrevTouchY * this.Profile.Width)) && !this.PauseRect.contains((int) (this.TouchX * this.Profile.Width), (int) (this.TouchY * this.Profile.Width))) {
                    this.Pause = false;
                    msg = new Message();
                    msg.arg1 = 9;
                    msg.arg2 = 0;
                    this.MainHandler.sendMessage(msg);
                }
            } else if (!(this.PauseRect == null || !this.PauseRect.contains((int) (this.TouchX * this.Profile.Width), (int) (this.TouchY * this.Profile.Width)) || this.InContact)) {
                msg = new Message();
                msg.arg1 = 9;
                msg.arg2 = 1;
                this.MainHandler.sendMessage(msg);
                this.Pause = true;
            }
        }
        if (!this.Pause && !this.Reset) {
            double t = (((double) eNano) / 1.0E9d) * ((double) this.TimeMult);
            ModeProfile modeProfile = this.Profile;
            modeProfile.VelocityX = (float) (((double) modeProfile.VelocityX) + (((double) this.Profile.AccelerationX) * t));
            modeProfile = this.Profile;
            modeProfile.VelocityY = (float) (((double) modeProfile.VelocityY) + (((double) this.Profile.AccelerationY) * t));
            this.DeltaXPos = (float) (((double) this.Profile.VelocityX) * t);
            this.DeltaYPos = (float) (((double) this.Profile.VelocityY) * t);
            this.IsColliding = false;
            this.Time += t;
            Iterator<Updater> updateIterator = this.Updaters.iterator();
            while (updateIterator.hasNext()) {
                ((Updater) updateIterator.next()).update(t);
            }
            Iterator<Icon> iconIterator = this.Icons.iterator();
            while (iconIterator.hasNext()) {
                Icon icon = (Icon) iconIterator.next();
                icon.update(t);
                icon.testCollisions(t);
                if (this.InContact && icon.contains(this.TouchX, this.TouchY)) {
                    icon.activate();
                }
            }
            Iterator<PowerUp> PUPIterator = this.PowerUps.iterator();
            while (PUPIterator.hasNext()) {
                ((PowerUp) PUPIterator.next()).update(t);
            }
            if (this.Collisions) {
                Iterator<Collider> collideIterator = this.Colliders.iterator();
                while (collideIterator.hasNext()) {
                    ((Collider) collideIterator.next()).detectCollisions(t);
                }
            }
            if (this.Scoring) {
                updateIterator = this.ScoreUpdaters.iterator();
                while (updateIterator.hasNext()) {
                    ((Updater) updateIterator.next()).update(t);
                }
            }
            if (this.Fail) {
                fail();
            }
        } else if (this.Reset) {
            reset();
            this.Reset = false;
        } else if (this.Profile.PauseOnStart && !this.Reset && this.InContact && !this.Profile.Started) {
            this.Pause = false;
            msg = new Message();
            msg.arg1 = 9;
            msg.arg2 = 0;
            this.MainHandler.sendMessage(msg);
            this.Profile.Started = true;
        }
        this.PrevContact = this.InContact;
        this.PrevTouchX = this.TouchX;
        this.PrevTouchY = this.TouchY;
    }

    public void render(Canvas canvas) {
        Iterator<Renderer> iterator = this.Renderers.iterator();
        Iterator<Icon> iconIterator = this.Icons.iterator();
        while (iterator.hasNext()) {
            ((Renderer) iterator.next()).render(canvas);
        }
        while (iconIterator.hasNext()) {
            ((Icon) iconIterator.next()).render(canvas);
        }
    }

    public void generate() {
        Iterator<Generator> iterator = this.Generators.iterator();
        while (iterator.hasNext()) {
            ((Generator) iterator.next()).generate();
        }
    }

    public void fail() {
        this.Pause = true;
        Bundle data = new Bundle();
        Message msg = new Message();
        msg.arg1 = 2;
        data.putString("NAME", this.GameModeName);
        data.putLong("SCORE", (long) this.Score);
        data.putInt("FAILS", 1);
        data.putInt("PUC", this.PowerUpsCollected);
        data.putInt("BD", this.BombsDetonated);
        data.putInt("FLIPS", this.Flips);
        data.putInt("FATS", this.Fattenings);
        data.putInt("SS", this.SupaSlows);
        data.putInt("MATHS", this.MathsCollected);
        data.putInt("HM", this.HighestMult);
        msg.setData(data);
        this.MainHandler.sendMessage(msg);
    }

    public void pause() {
        this.Pause = true;
    }

    public void resume() {
        this.Pause = false;
    }

    public void finishAndReset() {
        this.Pause = false;
        this.Reset = true;
    }

    public void reset() {
        this.Profile = new ModeProfile(this.InitialProfile);
        this.Profile.PathPaint.setStrokeWidth((this.Profile.PathRadius * 2.0f) * this.Profile.Width);
        this.PowerUps = new LinkedList();
        this.Icons = new LinkedList();
        if (!this.Pause) {
            this.Pause = this.Profile.PauseOnStart;
        }
        if (this.Profile.PauseBar) {
            Message msg = new Message();
            msg.arg1 = 9;
            msg.arg2 = 2;
            this.MainHandler.sendMessage(msg);
        }
        this.InContact = false;
        this.PrevContact = false;
        this.Score = 0.0d;
        this.TouchX = 0.0f;
        this.TouchY = 0.0f;
        this.MBProgress = this.Profile.MultBarMax / 2.0f;
        this.APProgress = 0.0f;
        this.Multiplier = this.Profile.InitMultiplier;
        this.PowerUpsCollected = 0;
        this.BombsDetonated = 0;
        this.Flips = 0;
        this.Fattenings = 0;
        this.SupaSlows = 0;
        this.MathsCollected = 0;
        this.HighestMult = 0;
        this.Fail = false;
        this.Generate = false;
        this.Collisions = true;
        this.Scoring = true;
        this.TimeMult = this.Profile.InitTimeMult;
        this.ScoreMult = this.Profile.InitScoreMult;
        if (this.Profile.DaFattening) {
            this.PowerUps.add(new DaFattening());
        }
        if (this.Profile.DaMaths) {
            this.PowerUps.add(new DaMaths());
        }
        if (this.Profile.DaSupaSlow) {
            this.PowerUps.add(new DaSupaSlow());
        }
        if (this.Profile.DaBomb) {
            this.PowerUps.add(new DaBomb());
        }
        if (this.Profile.DaFlip) {
            this.PowerUps.add(new DaFlip());
        }
        setupGenerators();
        setupUpdaters();
        setupRenderers();
        setupColliders();
    }

    public void setPauseRect(Rect r) {
        this.PauseRect = r;
    }

    public void setContact(boolean contact) {
        this.InContact = contact;
    }

    public void setTouch(float x, float y) {
        this.TouchX = x / this.Profile.Width;
        this.TouchY = y / this.Profile.Width;
    }
}
