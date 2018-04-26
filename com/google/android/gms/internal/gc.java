package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gb.C0738a;

public interface gc extends IInterface {

    public static abstract class C0740a extends Binder implements gc {

        private static class C0739a implements gc {
            private IBinder kq;

            C0739a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public void mo1715a(gb gbVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    this.kq.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1716a(gb gbVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.kq.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1717a(gb gbVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.kq.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1718a(gb gbVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.kq.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kq;
            }

            public void mo1719b(gb gbVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    this.kq.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1720b(gb gbVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.kq.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1721c(gb gbVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(gbVar != null ? gbVar.asBinder() : null);
                    this.kq.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int dU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.kq.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int dV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.kq.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static gc m2609F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof gc)) ? new C0739a(iBinder) : (gc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int dU;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    dU = dU();
                    reply.writeNoException();
                    reply.writeInt(dU);
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    dU = dV();
                    reply.writeNoException();
                    reply.writeInt(dU);
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1718a(C0738a.m2601E(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1716a(C0738a.m2601E(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1715a(C0738a.m2601E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1717a(C0738a.m2601E(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1720b(C0738a.m2601E(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1719b(C0738a.m2601E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo1721c(C0738a.m2601E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo1715a(gb gbVar) throws RemoteException;

    void mo1716a(gb gbVar, int i) throws RemoteException;

    void mo1717a(gb gbVar, int i, String str, byte[] bArr) throws RemoteException;

    void mo1718a(gb gbVar, int i, byte[] bArr) throws RemoteException;

    void mo1719b(gb gbVar) throws RemoteException;

    void mo1720b(gb gbVar, int i) throws RemoteException;

    void mo1721c(gb gbVar) throws RemoteException;

    int dU() throws RemoteException;

    int dV() throws RemoteException;
}
