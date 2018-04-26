package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0420f;
import com.google.android.gms.maps.model.internal.C0420f.C0889a;

public interface C0390g extends IInterface {

    public static abstract class C0850a extends Binder implements C0390g {

        private static class C0849a implements C0390g {
            private IBinder kq;

            C0849a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo2102e(C0420f c0420f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    obtain.writeStrongBinder(c0420f != null ? c0420f.asBinder() : null);
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0850a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        public static C0390g aF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0390g)) ? new C0849a(iBinder) : (C0390g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    mo2102e(C0889a.bc(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2102e(C0420f c0420f) throws RemoteException;
}
