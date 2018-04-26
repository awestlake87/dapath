package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C0381a;
import com.google.android.gms.location.C0381a.C0804a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class jf {
    private final jj<je> VJ;
    private ContentProviderClient VK = null;
    private boolean VL = false;
    private HashMap<LocationListener, C1098b> VM = new HashMap();
    private final Context mContext;

    private static class C0357a extends Handler {
        private final LocationListener VN;

        public C0357a(LocationListener locationListener) {
            this.VN = locationListener;
        }

        public C0357a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.VN = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.VN.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class C1098b extends C0804a {
        private Handler VO;

        C1098b(LocationListener locationListener, Looper looper) {
            this.VO = looper == null ? new C0357a(locationListener) : new C0357a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.VO == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.VO.sendMessage(obtain);
        }

        public void release() {
            this.VO = null;
        }
    }

    public jf(Context context, jj<je> jjVar) {
        this.mContext = context;
        this.VJ = jjVar;
    }

    public Location getLastLocation() {
        this.VJ.cn();
        try {
            return ((je) this.VJ.ft()).bo(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void iY() {
        if (this.VL) {
            try {
                setMockMode(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.VM) {
                for (C0381a c0381a : this.VM.values()) {
                    if (c0381a != null) {
                        ((je) this.VJ.ft()).mo1832a(c0381a);
                    }
                }
                this.VM.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).mo1819a(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) throws RemoteException {
        this.VJ.cn();
        hm.m1228b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.VM) {
            C0381a c0381a = (C1098b) this.VM.remove(listener);
            if (this.VK != null && this.VM.isEmpty()) {
                this.VK.release();
                this.VK = null;
            }
            if (c0381a != null) {
                c0381a.release();
                ((je) this.VJ.ft()).mo1832a(c0381a);
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).mo1829a(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) throws RemoteException {
        this.VJ.cn();
        if (looper == null) {
            hm.m1228b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.VM) {
            C0381a c1098b;
            C1098b c1098b2 = (C1098b) this.VM.get(listener);
            if (c1098b2 == null) {
                c1098b = new C1098b(listener, looper);
            } else {
                Object obj = c1098b2;
            }
            this.VM.put(listener, c1098b);
            ((je) this.VJ.ft()).mo1831a(request, c1098b, this.mContext.getPackageName());
        }
    }

    public void setMockLocation(Location mockLocation) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) throws RemoteException {
        this.VJ.cn();
        ((je) this.VJ.ft()).setMockMode(isMockMode);
        this.VL = isMockMode;
    }
}
