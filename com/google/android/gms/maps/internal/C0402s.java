package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C0252d.C0661a;

public interface C0402s extends IInterface {

    public static abstract class C0874a extends Binder implements C0402s {

        private static class C0873a implements C0402s {
            private IBinder kq;

            C0873a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo2116g(C0252d c0252d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    obtain.writeStrongBinder(c0252d != null ? c0252d.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    if (snapshot != null) {
                        obtain.writeInt(1);
                        snapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0874a() {
            attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        }

        public static C0402s aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0402s)) ? new C0873a(iBinder) : (C0402s) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    onSnapshotReady(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    mo2116g(C0661a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2116g(C0252d c0252d) throws RemoteException;

    void onSnapshotReady(Bitmap bitmap) throws RemoteException;
}
