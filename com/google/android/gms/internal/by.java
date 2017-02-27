package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;

public interface by extends IInterface {

    /* renamed from: com.google.android.gms.internal.by.a */
    public static abstract class C0403a extends Binder implements by {

        /* renamed from: com.google.android.gms.internal.by.a.a */
        private static class C0402a implements by {
            private IBinder dG;

            C0402a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public bw m1206a(bu buVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (buVar != null) {
                        obtain.writeInt(1);
                        buVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    bw f = obtain2.readInt() != 0 ? bw.CREATOR.m230f(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return f;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }
        }

        public C0403a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static by m1207q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof by)) ? new C0402a(iBinder) : (by) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    bw a = m232a(data.readInt() != 0 ? bu.CREATOR.m227e(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    bw m232a(bu buVar) throws RemoteException;
}
