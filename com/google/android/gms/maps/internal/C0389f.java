package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0418d;
import com.google.android.gms.maps.model.internal.C0418d.C0885a;

public interface C0389f extends IInterface {

    public static abstract class C0848a extends Binder implements C0389f {

        private static class C0847a implements C0389f {
            private IBinder kq;

            C0847a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo2100a(C0418d c0418d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(c0418d != null ? c0418d.asBinder() : null);
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void onIndoorBuildingFocused() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0848a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static C0389f aE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0389f)) ? new C0847a(iBinder) : (C0389f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    mo2100a(C0885a.ba(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2100a(C0418d c0418d) throws RemoteException;

    void onIndoorBuildingFocused() throws RemoteException;
}
