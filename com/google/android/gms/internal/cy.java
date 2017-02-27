package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cx.C0409a;

public interface cy extends IInterface {

    /* renamed from: com.google.android.gms.internal.cy.a */
    public static abstract class C0411a extends Binder implements cy {

        /* renamed from: com.google.android.gms.internal.cy.a.a */
        private static class C0410a implements cy {
            private IBinder dG;

            C0410a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void m1219a(cx cxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    this.dG.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1220a(cx cxVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.dG.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1221a(cx cxVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.dG.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1222a(cx cxVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.dG.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1223b(cx cxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    this.dG.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1224b(cx cxVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.dG.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1225c(cx cxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(cxVar != null ? cxVar.asBinder() : null);
                    this.dG.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMaxNumKeys() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.dG.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getMaxStateSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.dG.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static cy m1226t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cy)) ? new C0410a(iBinder) : (cy) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int maxStateSize;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    maxStateSize = getMaxStateSize();
                    reply.writeNoException();
                    reply.writeInt(maxStateSize);
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    maxStateSize = getMaxNumKeys();
                    reply.writeNoException();
                    reply.writeInt(maxStateSize);
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m331a(C0409a.m1218s(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m329a(C0409a.m1218s(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m328a(C0409a.m1218s(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m330a(C0409a.m1218s(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m333b(C0409a.m1218s(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m332b(C0409a.m1218s(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    m334c(C0409a.m1218s(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m328a(cx cxVar) throws RemoteException;

    void m329a(cx cxVar, int i) throws RemoteException;

    void m330a(cx cxVar, int i, String str, byte[] bArr) throws RemoteException;

    void m331a(cx cxVar, int i, byte[] bArr) throws RemoteException;

    void m332b(cx cxVar) throws RemoteException;

    void m333b(cx cxVar, int i) throws RemoteException;

    void m334c(cx cxVar) throws RemoteException;

    int getMaxNumKeys() throws RemoteException;

    int getMaxStateSize() throws RemoteException;
}
