package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.internal.aw.C0380a;
import com.google.android.gms.location.DetectedActivity;

public interface ad extends IInterface {

    /* renamed from: com.google.android.gms.internal.ad.a */
    public static abstract class C0369a extends Binder implements ad {

        /* renamed from: com.google.android.gms.internal.ad.a.a */
        private static class C0368a implements ad {
            private IBinder dG;

            C0368a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder m1128a(C0071b c0071b, C0470x c0470x, String str, aw awVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    if (c0470x != null) {
                        obtain.writeInt(1);
                        c0470x.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (awVar != null) {
                        iBinder = awVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }
        }

        public static ad m1129g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new C0368a(iBinder) : (ad) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = m173a(C0354a.m1114z(data.readStrongBinder()), data.readInt() != 0 ? C0470x.CREATOR.m701b(data) : null, data.readString(), C0380a.m1159i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder m173a(C0071b c0071b, C0470x c0470x, String str, aw awVar, int i) throws RemoteException;
}
