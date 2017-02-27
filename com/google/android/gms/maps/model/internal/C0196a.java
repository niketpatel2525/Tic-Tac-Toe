package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public interface C0196a extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.a.a */
    public static abstract class C0526a extends Binder implements C0196a {

        /* renamed from: com.google.android.gms.maps.model.internal.a.a.a */
        private static class C0525a implements C0196a {
            private IBinder dG;

            C0525a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public C0071b m1583S(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b m1584T(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b m1585U(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.dG.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b m1586a(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b ad(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
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

            public C0071b m1587c(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b cQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0196a ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0196a)) ? new C0525a(iBinder) : (C0196a) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0071b ad;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = ad(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(ad != null ? ad.asBinder() : null);
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = m754S(data.readString());
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = m755T(data.readString());
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = cQ();
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = m758c(data.readFloat());
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = m757a(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    ad = m756U(data.readString());
                    reply.writeNoException();
                    if (ad != null) {
                        iBinder = ad.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0071b m754S(String str) throws RemoteException;

    C0071b m755T(String str) throws RemoteException;

    C0071b m756U(String str) throws RemoteException;

    C0071b m757a(Bitmap bitmap) throws RemoteException;

    C0071b ad(int i) throws RemoteException;

    C0071b m758c(float f) throws RemoteException;

    C0071b cQ() throws RemoteException;
}
