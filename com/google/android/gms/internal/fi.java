package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.location.DetectedActivity;

public interface fi extends IInterface {

    /* renamed from: com.google.android.gms.internal.fi.a */
    public static abstract class C0453a extends Binder implements fi {

        /* renamed from: com.google.android.gms.internal.fi.a.a */
        private static class C0452a implements fi {
            private IBinder dG;

            C0452a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public C0071b m1489a(C0071b c0071b, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b m1490a(C0071b c0071b, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }
        }

        public static fi ao(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fi)) ? new C0452a(iBinder) : (fi) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0071b a;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m595a(C0354a.m1114z(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m596a(C0354a.m1114z(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0071b m595a(C0071b c0071b, int i, int i2, String str, int i3) throws RemoteException;

    C0071b m596a(C0071b c0071b, int i, int i2, String str, String str2) throws RemoteException;
}
