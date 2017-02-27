package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.internal.ay.C0384a;
import com.google.android.gms.location.DetectedActivity;

public interface ax extends IInterface {

    /* renamed from: com.google.android.gms.internal.ax.a */
    public static abstract class C0382a extends Binder implements ax {

        /* renamed from: com.google.android.gms.internal.ax.a.a */
        private static class C0381a implements ax {
            private IBinder dG;

            C0381a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void m1160a(C0071b c0071b, C0469v c0469v, String str, ay ayVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    if (c0469v != null) {
                        obtain.writeInt(1);
                        c0469v.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ayVar != null) {
                        iBinder = ayVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1161a(C0071b c0071b, C0470x c0470x, C0469v c0469v, String str, ay ayVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0071b != null ? c0071b.asBinder() : null);
                    if (c0470x != null) {
                        obtain.writeInt(1);
                        c0470x.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0469v != null) {
                        obtain.writeInt(1);
                        c0469v.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ayVar != null) {
                        iBinder = ayVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0071b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0071b z = C0354a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0382a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static ax m1162j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ax)) ? new C0381a(iBinder) : (ax) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            C0469v c0469v = null;
            C0071b view;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m189a(C0354a.m1114z(data.readStrongBinder()), data.readInt() != 0 ? C0470x.CREATOR.m701b(data) : null, data.readInt() != 0 ? C0469v.CREATOR.m698a(data) : null, data.readString(), C0384a.m1164k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0354a.m1114z(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c0469v = C0469v.CREATOR.m698a(data);
                    }
                    m188a(view, c0469v, data.readString(), C0384a.m1164k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m188a(C0071b c0071b, C0469v c0469v, String str, ay ayVar) throws RemoteException;

    void m189a(C0071b c0071b, C0470x c0470x, C0469v c0469v, String str, ay ayVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0071b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
