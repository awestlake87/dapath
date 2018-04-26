package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface C0252d extends IInterface {

    public static abstract class C0661a extends Binder implements C0252d {

        private static class C0660a implements C0252d {
            private IBinder kq;

            C0660a(IBinder iBinder) {
                this.kq = iBinder;
            }

            public IBinder asBinder() {
                return this.kq;
            }
        }

        public C0661a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C0252d ag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0252d)) ? new C0660a(iBinder) : (C0252d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
