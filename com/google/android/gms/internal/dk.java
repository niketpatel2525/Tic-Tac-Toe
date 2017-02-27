package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.location.DetectedActivity;

public interface dk extends IInterface {

    /* renamed from: com.google.android.gms.internal.dk.a */
    public static abstract class C0419a extends Binder implements dk {

        /* renamed from: com.google.android.gms.internal.dk.a.a */
        private static class C0418a implements dk {
            private IBinder dG;

            C0418a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public C0071b m1266a(C0071b c0071b, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.dG.transact(1, obtain, obtain2, 0);
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

        public static dk m1267x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dk)) ? new C0418a(iBinder) : (dk) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0071b a = m385a(C0354a.m1114z(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0071b m385a(C0071b c0071b, int i, int i2) throws RemoteException;
}
