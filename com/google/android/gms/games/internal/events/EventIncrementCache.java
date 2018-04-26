package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object Rm = new Object();
    private Handler Rn;
    private boolean Ro;
    private HashMap<String, AtomicInteger> Rp;
    private int Rq;

    class C02571 implements Runnable {
        final /* synthetic */ EventIncrementCache Rr;

        C02571(EventIncrementCache eventIncrementCache) {
            this.Rr = eventIncrementCache;
        }

        public void run() {
            this.Rr.hP();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.Rn = new Handler(looper);
        this.Rp = new HashMap();
        this.Rq = flushIntervalMillis;
    }

    private void hP() {
        synchronized (this.Rm) {
            this.Ro = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.Rm) {
            for (Entry entry : this.Rp.entrySet()) {
                mo1127o((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.Rp.clear();
        }
    }

    protected abstract void mo1127o(String str, int i);

    public void m730u(String str, int i) {
        synchronized (this.Rm) {
            if (!this.Ro) {
                this.Ro = true;
                this.Rn.postDelayed(new C02571(this), (long) this.Rq);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.Rp.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.Rp.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
