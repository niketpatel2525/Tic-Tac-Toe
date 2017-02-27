package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.Tile;

/* renamed from: com.google.android.gms.maps.model.internal.g */
public interface C0202g extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.g.a */
    public static abstract class C0538a extends Binder implements C0202g {

        /* renamed from: com.google.android.gms.maps.model.internal.g.a.a */
        private static class C0537a implements C0202g {
            private IBinder dG;

            C0537a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public Tile getTile(int x, int y, int zoom) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    obtain.writeInt(x);
                    obtain.writeInt(y);
                    obtain.writeInt(zoom);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Tile createFromParcel = obtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0538a() {
            attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        public static C0202g aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0202g)) ? new C0537a(iBinder) : (C0202g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    Tile tile = getTile(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (tile != null) {
                        reply.writeInt(1);
                        tile.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Tile getTile(int i, int i2, int i3) throws RemoteException;
}
