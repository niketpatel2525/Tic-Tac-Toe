package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.widget.ViewDragHelper;
import com.google.android.gms.C0049R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.di.C0415a;
import com.google.android.gms.location.DetectedActivity;

public interface dj extends IInterface {

    /* renamed from: com.google.android.gms.internal.dj.a */
    public static abstract class C0417a extends Binder implements dj {

        /* renamed from: com.google.android.gms.internal.dj.a.a */
        private static class C0416a implements dj {
            private IBinder dG;

            C0416a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void m1250a(di diVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1251a(di diVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1252a(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1253a(di diVar, int i, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.dG.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1254a(di diVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void m1255a(di diVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1256b(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1257c(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1258d(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1259e(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1260f(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1261g(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1262h(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1263i(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1264j(di diVar, int i, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(diVar != null ? diVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static dj m1265w(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dj)) ? new C0416a(iBinder) : (dj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle bundle = null;
            di v;
            int readInt;
            String readString;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m374a(C0415a.m1249v(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m372a(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m371a(C0415a.m1249v(data.readStrongBinder()), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m370a(C0415a.m1249v(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m376b(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m377c(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m378d(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m379e(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m375a(C0415a.m1249v(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray(), data.readString(), data.readStrongBinder(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m373a(C0415a.m1249v(data.readStrongBinder()), data.readInt(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m380f(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case ConnectionResult.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m381g(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case C0049R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m382h(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m383i(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case ViewDragHelper.EDGE_ALL /*15*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    v = C0415a.m1249v(data.readStrongBinder());
                    readInt = data.readInt();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    m384j(v, readInt, readString, bundle);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m370a(di diVar, int i) throws RemoteException;

    void m371a(di diVar, int i, String str) throws RemoteException;

    void m372a(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m373a(di diVar, int i, String str, String str2, String[] strArr) throws RemoteException;

    void m374a(di diVar, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) throws RemoteException;

    void m375a(di diVar, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) throws RemoteException;

    void m376b(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m377c(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m378d(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m379e(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m380f(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m381g(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m382h(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m383i(di diVar, int i, String str, Bundle bundle) throws RemoteException;

    void m384j(di diVar, int i, String str, Bundle bundle) throws RemoteException;
}
