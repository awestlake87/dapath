package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.ac.C0620a;
import com.google.android.gms.internal.hm;

public class C1021x<C extends DriveEvent> extends C0620a {
    private final int Iq;
    private final Listener<C> Jn;
    private final C0197a<C> Jo;

    private static class C0197a<E extends DriveEvent> extends Handler {
        private C0197a(Looper looper) {
            super(looper);
        }

        public void m359a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                    return;
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public C1021x(Looper looper, int i, Listener<C> listener) {
        this.Iq = i;
        this.Jn = listener;
        this.Jo = new C0197a(looper);
    }

    public void mo988a(OnEventResponse onEventResponse) throws RemoteException {
        hm.m1224A(this.Iq == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case 1:
                this.Jo.m359a(this.Jn, onEventResponse.gw());
                return;
            case 2:
                this.Jo.m359a(this.Jn, onEventResponse.gx());
                return;
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
                return;
        }
    }
}
