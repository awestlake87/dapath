package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public interface C0240j extends IInterface {

    public static abstract class C0641a extends Binder implements C0240j {

        private static class C0640a implements C0240j {
            private IBinder kq;

            C0640a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1024a(ParcelableEventList parcelableEventList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (parcelableEventList != null) {
                        obtain.writeInt(1);
                        parcelableEventList.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo1025o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IEventCallback");
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
        }

        public static C0240j m2108Z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0240j)) ? new C0640a(iBinder) : (C0240j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case 1:
                    ParcelableEventList parcelableEventList;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (data.readInt() != 0) {
                        parcelableEventList = (ParcelableEventList) ParcelableEventList.CREATOR.createFromParcel(data);
                    }
                    mo1024a(parcelableEventList);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    mo1025o(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1024a(ParcelableEventList parcelableEventList) throws RemoteException;

    void mo1025o(Status status) throws RemoteException;
}
