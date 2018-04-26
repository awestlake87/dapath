package com.google.android.gms.internal;

public abstract class em {
    private final Runnable lg = new C03091(this);
    private volatile Thread sf;

    class C03091 implements Runnable {
        final /* synthetic */ em sg;

        C03091(em emVar) {
            this.sg = emVar;
        }

        public final void run() {
            this.sg.sf = Thread.currentThread();
            this.sg.bh();
        }
    }

    public abstract void bh();

    public final void cancel() {
        onStop();
        if (this.sf != null) {
            this.sf.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        en.execute(this.lg);
    }
}
