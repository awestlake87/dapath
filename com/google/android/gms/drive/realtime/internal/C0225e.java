package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface C0225e extends IInterface {

    public static abstract class C0631a extends Binder implements C0225e {

        private static class C0630a implements C0225e {
            private IBinder kq;

            C0630a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1016a(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    obtain.writeTypedArray(parcelableCollaboratorArr, 0);
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

            public void mo1017o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
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

        public static C0225e m2095U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0225e)) ? new C0630a(iBinder) : (C0225e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    mo1016a((ParcelableCollaborator[]) data.createTypedArray(ParcelableCollaborator.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    mo1017o(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1016a(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException;

    void mo1017o(Status status) throws RemoteException;
}
