package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ab implements ad {
    private final Object ls = new Object();
    private WeakHashMap<ef, ac> lt = new WeakHashMap();
    private ArrayList<ac> lu = new ArrayList();

    public ac m2437a(al alVar, ef efVar) {
        ac acVar;
        synchronized (this.ls) {
            if (m2439c(efVar)) {
                acVar = (ac) this.lt.get(efVar);
            } else {
                acVar = new ac(alVar, efVar);
                acVar.m763a((ad) this);
                this.lt.put(efVar, acVar);
                this.lu.add(acVar);
            }
        }
        return acVar;
    }

    public void mo1574a(ac acVar) {
        synchronized (this.ls) {
            if (!acVar.az()) {
                this.lu.remove(acVar);
            }
        }
    }

    public boolean m2439c(ef efVar) {
        boolean z;
        synchronized (this.ls) {
            ac acVar = (ac) this.lt.get(efVar);
            z = acVar != null && acVar.az();
        }
        return z;
    }

    public void m2440d(ef efVar) {
        synchronized (this.ls) {
            ac acVar = (ac) this.lt.get(efVar);
            if (acVar != null) {
                acVar.ax();
            }
        }
    }

    public void pause() {
        synchronized (this.ls) {
            Iterator it = this.lu.iterator();
            while (it.hasNext()) {
                ((ac) it.next()).pause();
            }
        }
    }

    public void resume() {
        synchronized (this.ls) {
            Iterator it = this.lu.iterator();
            while (it.hasNext()) {
                ((ac) it.next()).resume();
            }
        }
    }

    public void stop() {
        synchronized (this.ls) {
            Iterator it = this.lu.iterator();
            while (it.hasNext()) {
                ((ac) it.next()).stop();
            }
        }
    }
}
