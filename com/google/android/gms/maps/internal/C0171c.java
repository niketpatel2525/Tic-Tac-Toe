package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0481a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0487a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0489a;
import com.google.android.gms.maps.model.internal.C0196a;
import com.google.android.gms.maps.model.internal.C0196a.C0526a;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0171c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C0497a extends Binder implements C0171c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C0496a implements C0171c {
            private IBinder dG;

            C0496a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IMapViewDelegate m1547a(C0071b c0071b, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate O = C0489a.m1544O(obtain2.readStrongBinder());
                    return O;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1548a(C0071b c0071b, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    obtain.writeInt(i);
                    this.dG.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public ICameraUpdateFactoryDelegate cG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate H = C0481a.m1540H(obtain2.readStrongBinder());
                    return H;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0196a cH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0196a ac = C0526a.ac(obtain2.readStrongBinder());
                    return ac;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1549e(C0071b c0071b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m1550f(C0071b c0071b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate N = C0487a.m1543N(obtain2.readStrongBinder());
                    return N;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0171c m1551J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0171c)) ? new C0496a(iBinder) : (C0171c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m714e(C0354a.m1114z(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate f = m715f(C0354a.m1114z(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m712a(C0354a.m1114z(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate cG = cG();
                    reply.writeNoException();
                    if (cG != null) {
                        iBinder = cG.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0196a cH = cH();
                    reply.writeNoException();
                    if (cH != null) {
                        iBinder = cH.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m713a(C0354a.m1114z(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate m712a(C0071b c0071b, GoogleMapOptions googleMapOptions) throws RemoteException;

    void m713a(C0071b c0071b, int i) throws RemoteException;

    ICameraUpdateFactoryDelegate cG() throws RemoteException;

    C0196a cH() throws RemoteException;

    void m714e(C0071b c0071b) throws RemoteException;

    IMapFragmentDelegate m715f(C0071b c0071b) throws RemoteException;
}
