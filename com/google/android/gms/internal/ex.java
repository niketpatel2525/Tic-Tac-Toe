package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0049R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.ew.C0438a;
import com.google.android.gms.location.C0167a;
import com.google.android.gms.location.C0167a.C0472a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public interface ex extends IInterface {

    /* renamed from: com.google.android.gms.internal.ex.a */
    public static abstract class C0440a extends Binder implements ex {

        /* renamed from: com.google.android.gms.internal.ex.a.a */
        private static class C0439a implements ex {
            private IBinder dG;

            C0439a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void m1456a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void m1457a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void m1458a(PendingIntent pendingIntent, ew ewVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ewVar != null ? ewVar.asBinder() : null);
                    obtain.writeString(str);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1459a(ew ewVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(ewVar != null ? ewVar.asBinder() : null);
                    obtain.writeString(str);
                    this.dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1460a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void m1461a(LocationRequest locationRequest, C0167a c0167a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0167a != null ? c0167a.asBinder() : null);
                    this.dG.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1462a(LocationRequest locationRequest, C0167a c0167a, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0167a != null ? c0167a.asBinder() : null);
                    obtain.writeString(str);
                    this.dG.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1463a(C0167a c0167a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(c0167a != null ? c0167a.asBinder() : null);
                    this.dG.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1464a(List<fa> list, PendingIntent pendingIntent, ew ewVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ewVar != null ? ewVar.asBinder() : null);
                    obtain.writeString(str);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1465a(String[] strArr, ew ewVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(ewVar != null ? ewVar.asBinder() : null);
                    obtain.writeString(str);
                    this.dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public Location cl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.dG.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
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

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
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

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.dG.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ex m1466F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ex)) ? new C0439a(iBinder) : (ex) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            LocationRequest locationRequest = null;
            PendingIntent pendingIntent;
            Location cl;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    List createTypedArrayList = data.createTypedArrayList(fa.CREATOR);
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m581a(createTypedArrayList, pendingIntent, C0438a.m1455E(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m575a(pendingIntent, C0438a.m1455E(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m582a(data.createStringArray(), C0438a.m1455E(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m576a(C0438a.m1455E(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long readLong = data.readLong();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m573a(readLong, z, pendingIntent);
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    removeActivityUpdates(pendingIntent);
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    cl = cl();
                    reply.writeNoException();
                    if (cl != null) {
                        reply.writeInt(1);
                        cl.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        locationRequest = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m578a(locationRequest, C0472a.m1534D(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationRequest createFromParcel = data.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m577a(createFromParcel, pendingIntent);
                    reply.writeNoException();
                    return true;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m580a(C0472a.m1534D(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m574a(pendingIntent);
                    reply.writeNoException();
                    return true;
                case ConnectionResult.DATE_INVALID /*12*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMockMode(z);
                    reply.writeNoException();
                    return true;
                case C0049R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cl = (Location) Location.CREATOR.createFromParcel(data);
                    }
                    setMockLocation(cl);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        locationRequest = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m579a(locationRequest, C0472a.m1534D(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m573a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void m574a(PendingIntent pendingIntent) throws RemoteException;

    void m575a(PendingIntent pendingIntent, ew ewVar, String str) throws RemoteException;

    void m576a(ew ewVar, String str) throws RemoteException;

    void m577a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void m578a(LocationRequest locationRequest, C0167a c0167a) throws RemoteException;

    void m579a(LocationRequest locationRequest, C0167a c0167a, String str) throws RemoteException;

    void m580a(C0167a c0167a) throws RemoteException;

    void m581a(List<fa> list, PendingIntent pendingIntent, ew ewVar, String str) throws RemoteException;

    void m582a(String[] strArr, ew ewVar, String str) throws RemoteException;

    Location cl() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
