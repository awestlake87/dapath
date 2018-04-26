package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface C0224d extends IInterface {

    public static abstract class C0629a extends Binder implements C0224d {

        private static class C0628a implements C0224d {
            private IBinder kq;

            C0628a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1014a(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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

            public void mo1015b(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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

        public static C0224d m2092T(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0224d)) ? new C0628a(iBinder) : (C0224d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableCollaborator parcelableCollaborator = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    mo1014a(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    mo1015b(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1014a(ParcelableCollaborator parcelableCollaborator) throws RemoteException;

    void mo1015b(ParcelableCollaborator parcelableCollaborator) throws RemoteException;
}
