package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.maps.internal.o */
public interface C0183o extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.o.a */
    public static abstract class C0521a extends Binder implements C0183o {

        /* renamed from: com.google.android.gms.maps.internal.o.a.a */
        private static class C0520a implements C0183o {
            private IBinder dG;

            C0520a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1572c(C0071b c0071b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    if (snapshot != null) {
                        obtain.writeInt(1);
                        snapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0521a() {
            attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
        }

        public static C0183o aa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0183o)) ? new C0520a(iBinder) : (C0183o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    onSnapshotReady(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    m725c(C0354a.m1114z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m725c(C0071b c0071b) throws RemoteException;

    void onSnapshotReady(Bitmap bitmap) throws RemoteException;
}
