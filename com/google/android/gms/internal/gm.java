package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface gm extends IInterface {

    public static abstract class C0743a extends Binder implements gm {
        public C0743a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            gj gjVar = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2838T(data.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data);
                    }
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo2842a(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2839U(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo2843a(readString3, readDouble, z);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2849g(data.readString(), data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2848b(data.readString(), data.createByteArray());
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2841W(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2840V(data.readInt());
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2845a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2844a(data.readString(), data.readLong());
                    return true;
                case 12:
                    ge geVar;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        geVar = (ge) ge.CREATOR.createFromParcel(data);
                    }
                    mo2846b(geVar);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        gjVar = (gj) gj.CREATOR.createFromParcel(data);
                    }
                    mo2847b(gjVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void mo2838T(int i) throws RemoteException;

    void mo2839U(int i) throws RemoteException;

    void mo2840V(int i) throws RemoteException;

    void mo2841W(int i) throws RemoteException;

    void mo2842a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void mo2843a(String str, double d, boolean z) throws RemoteException;

    void mo2844a(String str, long j) throws RemoteException;

    void mo2845a(String str, long j, int i) throws RemoteException;

    void mo2846b(ge geVar) throws RemoteException;

    void mo2847b(gj gjVar) throws RemoteException;

    void mo2848b(String str, byte[] bArr) throws RemoteException;

    void mo2849g(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
