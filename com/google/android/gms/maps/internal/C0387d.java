package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.maps.model.internal.C0420f;
import com.google.android.gms.maps.model.internal.C0420f.C0889a;

public interface C0387d extends IInterface {

    public static abstract class C0844a extends Binder implements C0387d {

        private static class C0843a implements C0387d {
            private IBinder kq;

            C0843a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public C0252d mo2097f(C0420f c0420f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0420f != null ? c0420f.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0252d mo2098g(C0420f c0420f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0420f != null ? c0420f.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0252d ag = C0661a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0844a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static C0387d az(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0387d)) ? new C0843a(iBinder) : (C0387d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0252d f;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = mo2097f(C0889a.bc(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = mo2098g(C0889a.bc(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0252d mo2097f(C0420f c0420f) throws RemoteException;

    C0252d mo2098g(C0420f c0420f) throws RemoteException;
}
