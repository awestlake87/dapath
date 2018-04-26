package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as afI;
    private final LinkedBlockingQueue<Runnable> afH = new LinkedBlockingQueue();
    private volatile at afJ;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean uL = false;

    private as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as m2945P(Context context) {
        if (afI == null) {
            afI = new as(context);
        }
        return afI;
    }

    private String m2948a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void mo2296a(Runnable runnable) {
        this.afH.add(runnable);
    }

    void m2951b(String str, long j) {
        final as asVar = this;
        final long j2 = j;
        final String str2 = str;
        mo2296a(new Runnable(this) {
            final /* synthetic */ as afN;

            public void run() {
                if (this.afN.afJ == null) {
                    cx mQ = cx.mQ();
                    mQ.m3010a(this.afN.mContext, asVar);
                    this.afN.afJ = mQ.mR();
                }
                this.afN.afJ.mo2335f(j2, str2);
            }
        });
    }

    public void bU(String str) {
        m2951b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.afH.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m1643B(e.toString());
            } catch (Throwable th) {
                bh.m1642A("Error on GAThread: " + m2948a(th));
                bh.m1642A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
