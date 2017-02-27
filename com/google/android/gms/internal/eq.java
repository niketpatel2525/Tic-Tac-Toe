package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface eq extends IInterface {

    /* renamed from: com.google.android.gms.internal.eq.a */
    public static abstract class C0433a extends Binder implements eq {

        /* renamed from: com.google.android.gms.internal.eq.a.a */
        private static class C0432a implements eq {
            private IBinder dG;

            C0432a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public void m1340M(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.dG.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1341N(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.dG.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1342O(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.dG.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1343P(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.dG.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1344a(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.dG.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1345a(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.dG.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1346a(C0345d c0345d, C0345d c0345d2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0345d2 != null) {
                        obtain.writeInt(1);
                        c0345d2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1347a(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public void m1348b(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1349b(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1350c(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.dG.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1351c(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1352c(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1353d(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1354d(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1355e(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1356e(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1357f(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1358f(C0345d c0345d, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.dG.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1359g(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1360h(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1361i(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1362j(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1363k(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1364l(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1365m(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1366n(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1367o(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAchievementUpdated(int statusCode, String achievementId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(achievementId);
                    this.dG.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.dG.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.dG.transact(GamesClient.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.dG.transact(6002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSignOutComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.dG.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1368p(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1369q(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1370r(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1371s(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1372t(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1373u(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1374v(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1375w(C0345d c0345d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (c0345d != null) {
                        obtain.writeInt(1);
                        c0345d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.dG.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0433a() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static eq m1376B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof eq)) ? new C0432a(iBinder) : (eq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            C0345d c0345d = null;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m468c(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m466b(c0345d);
                    reply.writeNoException();
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onAchievementUpdated(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m469c(c0345d);
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    C0345d h = data.readInt() != 0 ? C0345d.CREATOR.m46h(data) : null;
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m464a(h, c0345d);
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m471d(c0345d);
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m473e(c0345d);
                    reply.writeNoException();
                    return true;
                case 5008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m475f(c0345d);
                    reply.writeNoException();
                    return true;
                case 5009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m477g(c0345d);
                    reply.writeNoException();
                    return true;
                case 5010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m478h(c0345d);
                    reply.writeNoException();
                    return true;
                case 5011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m479i(c0345d);
                    reply.writeNoException();
                    return true;
                case 5012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m482l(c0345d);
                    reply.writeNoException();
                    return true;
                case 5013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m458M(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m483m(c0345d);
                    reply.writeNoException();
                    return true;
                case 5015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m459N(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onSignOutComplete();
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m480j(c0345d);
                    reply.writeNoException();
                    return true;
                case 5018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m484n(c0345d);
                    reply.writeNoException();
                    return true;
                case 5019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m485o(c0345d);
                    reply.writeNoException();
                    return true;
                case 5020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onLeftRoom(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m486p(c0345d);
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m487q(c0345d);
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m488r(c0345d);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m489s(c0345d);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m490t(c0345d);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m465a(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m467b(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m470c(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m472d(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m474e(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m476f(c0345d, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5032:
                    RealTimeMessage realTimeMessage;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        realTimeMessage = (RealTimeMessage) RealTimeMessage.CREATOR.createFromParcel(data);
                    }
                    onRealTimeMessageReceived(realTimeMessage);
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m462a(data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m463a(data.readInt(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m492v(c0345d);
                    reply.writeNoException();
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m460O(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m481k(c0345d);
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m491u(c0345d);
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        c0345d = C0345d.CREATOR.m46h(data);
                    }
                    m493w(c0345d);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    m461P(data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesClient.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PConnected(data.readString());
                    reply.writeNoException();
                    return true;
                case 6002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PDisconnected(data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m458M(int i) throws RemoteException;

    void m459N(int i) throws RemoteException;

    void m460O(int i) throws RemoteException;

    void m461P(int i) throws RemoteException;

    void m462a(int i, int i2, String str) throws RemoteException;

    void m463a(int i, String str, boolean z) throws RemoteException;

    void m464a(C0345d c0345d, C0345d c0345d2) throws RemoteException;

    void m465a(C0345d c0345d, String[] strArr) throws RemoteException;

    void m466b(C0345d c0345d) throws RemoteException;

    void m467b(C0345d c0345d, String[] strArr) throws RemoteException;

    void m468c(int i, String str) throws RemoteException;

    void m469c(C0345d c0345d) throws RemoteException;

    void m470c(C0345d c0345d, String[] strArr) throws RemoteException;

    void m471d(C0345d c0345d) throws RemoteException;

    void m472d(C0345d c0345d, String[] strArr) throws RemoteException;

    void m473e(C0345d c0345d) throws RemoteException;

    void m474e(C0345d c0345d, String[] strArr) throws RemoteException;

    void m475f(C0345d c0345d) throws RemoteException;

    void m476f(C0345d c0345d, String[] strArr) throws RemoteException;

    void m477g(C0345d c0345d) throws RemoteException;

    void m478h(C0345d c0345d) throws RemoteException;

    void m479i(C0345d c0345d) throws RemoteException;

    void m480j(C0345d c0345d) throws RemoteException;

    void m481k(C0345d c0345d) throws RemoteException;

    void m482l(C0345d c0345d) throws RemoteException;

    void m483m(C0345d c0345d) throws RemoteException;

    void m484n(C0345d c0345d) throws RemoteException;

    void m485o(C0345d c0345d) throws RemoteException;

    void onAchievementUpdated(int i, String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onSignOutComplete() throws RemoteException;

    void m486p(C0345d c0345d) throws RemoteException;

    void m487q(C0345d c0345d) throws RemoteException;

    void m488r(C0345d c0345d) throws RemoteException;

    void m489s(C0345d c0345d) throws RemoteException;

    void m490t(C0345d c0345d) throws RemoteException;

    void m491u(C0345d c0345d) throws RemoteException;

    void m492v(C0345d c0345d) throws RemoteException;

    void m493w(C0345d c0345d) throws RemoteException;
}
