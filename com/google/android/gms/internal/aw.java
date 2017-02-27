package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ax.C0382a;
import com.google.android.gms.location.DetectedActivity;

public interface aw extends IInterface {

    /* renamed from: com.google.android.gms.internal.aw.a */
    public static abstract class C0380a extends Binder implements aw {

        /* renamed from: com.google.android.gms.internal.aw.a.a */
        private static class C0379a implements aw {
            private IBinder dG;

            C0379a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public ax m1158g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ax j = C0382a.m1162j(obtain2.readStrongBinder());
                    return j;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0380a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static aw m1159i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aw)) ? new C0379a(iBinder) : (aw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    ax g = m187g(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(g != null ? g.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    ax m187g(String str) throws RemoteException;
}
