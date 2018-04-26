package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface C0245o extends IInterface {

    public static abstract class C0651a extends Binder implements C0245o {

        private static class C0650a implements C0245o {
            private IBinder kq;

            C0650a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo1071o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kq.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    this.kq.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0245o ae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0245o)) ? new C0650a(iBinder) : (C0245o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    onSuccess();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    mo1071o(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1071o(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;
}
