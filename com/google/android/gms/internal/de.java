package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.internal.di.C0415a;
import com.google.android.gms.internal.dj.C0417a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public abstract class de<T extends IInterface> implements GooglePlayServicesClient {
    public static final String[] kO;
    private final String[] is;
    private T kD;
    private ArrayList<ConnectionCallbacks> kE;
    final ArrayList<ConnectionCallbacks> kF;
    private boolean kG;
    private ArrayList<OnConnectionFailedListener> kH;
    private boolean kI;
    private final ArrayList<C0135b<?>> kJ;
    private C0136e kK;
    boolean kL;
    boolean kM;
    private final Object kN;
    private final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.de.a */
    final class C0134a extends Handler {
        final /* synthetic */ de kP;

        public C0134a(de deVar, Looper looper) {
            this.kP = deVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what != 1 || this.kP.isConnecting()) {
                synchronized (this.kP.kN) {
                    this.kP.kM = false;
                }
                if (msg.what == 3) {
                    this.kP.m1242a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
                    return;
                } else if (msg.what == 4) {
                    synchronized (this.kP.kE) {
                        if (this.kP.kL && this.kP.isConnected() && this.kP.kE.contains(msg.obj)) {
                            ((ConnectionCallbacks) msg.obj).onConnected(this.kP.ba());
                        }
                    }
                    return;
                } else if (msg.what == 2 && !this.kP.isConnected()) {
                    C0135b c0135b = (C0135b) msg.obj;
                    c0135b.aF();
                    c0135b.unregister();
                    return;
                } else if (msg.what == 2 || msg.what == 1) {
                    ((C0135b) msg.obj).be();
                    return;
                } else {
                    Log.wtf("GmsClient", "Don't know how to handle this message.");
                    return;
                }
            }
            c0135b = (C0135b) msg.obj;
            c0135b.aF();
            c0135b.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.de.b */
    protected abstract class C0135b<TListener> {
        final /* synthetic */ de kP;
        private boolean kQ;
        private TListener mListener;

        public C0135b(de deVar, TListener tListener) {
            this.kP = deVar;
            this.mListener = tListener;
            this.kQ = false;
        }

        protected abstract void m346a(TListener tListener);

        protected abstract void aF();

        public void be() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.kQ) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    m346a(obj);
                } catch (RuntimeException e) {
                    aF();
                    throw e;
                }
            }
            aF();
            synchronized (this) {
                this.kQ = true;
            }
            unregister();
        }

        public void bf() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            bf();
            synchronized (this.kP.kJ) {
                this.kP.kJ.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.de.e */
    final class C0136e implements ServiceConnection {
        final /* synthetic */ de kP;

        C0136e(de deVar) {
            this.kP = deVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.kP.m1247u(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.kP.kD = null;
            this.kP.bb();
        }
    }

    /* renamed from: com.google.android.gms.internal.de.c */
    public abstract class C0412c<TListener> extends C0135b<TListener> {
        private final C0345d jf;
        final /* synthetic */ de kP;

        public C0412c(de deVar, TListener tListener, C0345d c0345d) {
            this.kP = deVar;
            super(deVar, tListener);
            this.jf = c0345d;
        }

        protected final void m1229a(TListener tListener) {
            m1230a(tListener, this.jf);
        }

        protected abstract void m1230a(TListener tListener, C0345d c0345d);

        protected void aF() {
            if (this.jf != null) {
                this.jf.close();
            }
        }

        public /* bridge */ /* synthetic */ void be() {
            super.be();
        }

        public /* bridge */ /* synthetic */ void bf() {
            super.bf();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.de.f */
    protected final class C0413f extends C0135b<Boolean> {
        final /* synthetic */ de kP;
        public final Bundle kS;
        public final IBinder kT;
        public final int statusCode;

        public C0413f(de deVar, int i, IBinder iBinder, Bundle bundle) {
            this.kP = deVar;
            super(deVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.kT = iBinder;
            this.kS = bundle;
        }

        protected void m1231a(Boolean bool) {
            if (bool != null) {
                switch (this.statusCode) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        try {
                            if (this.kP.ah().equals(this.kT.getInterfaceDescriptor())) {
                                this.kP.kD = this.kP.m1246p(this.kT);
                                if (this.kP.kD != null) {
                                    this.kP.aZ();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        df.m356s(this.kP.mContext).m358b(this.kP.ag(), this.kP.kK);
                        this.kP.kK = null;
                        this.kP.kD = null;
                        this.kP.m1242a(new ConnectionResult(8, null));
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                    default:
                        PendingIntent pendingIntent = this.kS != null ? (PendingIntent) this.kS.getParcelable("pendingIntent") : null;
                        if (this.kP.kK != null) {
                            df.m356s(this.kP.mContext).m358b(this.kP.ag(), this.kP.kK);
                            this.kP.kK = null;
                        }
                        this.kP.kD = null;
                        this.kP.m1242a(new ConnectionResult(this.statusCode, pendingIntent));
                }
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.de.d */
    public static final class C0579d extends C0415a {
        private de kR;

        public C0579d(de deVar) {
            this.kR = deVar;
        }

        public void m1822b(int i, IBinder iBinder, Bundle bundle) {
            dm.m388a((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.kR);
            this.kR.m1241a(i, iBinder, bundle);
            this.kR = null;
        }
    }

    static {
        kO = new String[]{"service_esmobile", "service_googleme"};
    }

    protected de(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.kF = new ArrayList();
        this.kG = false;
        this.kI = false;
        this.kJ = new ArrayList();
        this.kL = false;
        this.kM = false;
        this.kN = new Object();
        this.mContext = (Context) dm.m392e(context);
        this.kE = new ArrayList();
        this.kE.add(dm.m392e(connectionCallbacks));
        this.kH = new ArrayList();
        this.kH.add(dm.m392e(onConnectionFailedListener));
        this.mHandler = new C0134a(this, context.getMainLooper());
        m1245a(strArr);
        this.is = strArr;
    }

    protected void m1241a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0413f(this, i, iBinder, bundle)));
    }

    protected void m1242a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(4);
        synchronized (this.kH) {
            this.kI = true;
            ArrayList arrayList = this.kH;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.kL) {
                    if (this.kH.contains(arrayList.get(i))) {
                        ((OnConnectionFailedListener) arrayList.get(i)).onConnectionFailed(connectionResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.kI = false;
        }
    }

    public final void m1243a(C0135b<?> c0135b) {
        synchronized (this.kJ) {
            this.kJ.add(c0135b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c0135b));
    }

    protected abstract void m1244a(dj djVar, C0579d c0579d) throws RemoteException;

    protected void m1245a(String... strArr) {
    }

    public final String[] aY() {
        return this.is;
    }

    protected void aZ() {
        boolean z = true;
        synchronized (this.kE) {
            dm.m393k(!this.kG);
            this.mHandler.removeMessages(4);
            this.kG = true;
            if (this.kF.size() != 0) {
                z = false;
            }
            dm.m393k(z);
            Bundle ba = ba();
            ArrayList arrayList = this.kE;
            int size = arrayList.size();
            for (int i = 0; i < size && this.kL && isConnected(); i++) {
                this.kF.size();
                if (!this.kF.contains(arrayList.get(i))) {
                    ((ConnectionCallbacks) arrayList.get(i)).onConnected(ba);
                }
            }
            this.kF.clear();
            this.kG = false;
        }
    }

    protected abstract String ag();

    protected abstract String ah();

    protected Bundle ba() {
        return null;
    }

    protected final void bb() {
        this.mHandler.removeMessages(4);
        synchronized (this.kE) {
            this.kG = true;
            ArrayList arrayList = this.kE;
            int size = arrayList.size();
            for (int i = 0; i < size && this.kL; i++) {
                if (this.kE.contains(arrayList.get(i))) {
                    ((ConnectionCallbacks) arrayList.get(i)).onDisconnected();
                }
            }
            this.kG = false;
        }
    }

    protected final void bc() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T bd() {
        bc();
        return this.kD;
    }

    public void connect() {
        this.kL = true;
        synchronized (this.kN) {
            this.kM = true;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.kK != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.kD = null;
            df.m356s(this.mContext).m358b(ag(), this.kK);
        }
        this.kK = new C0136e(this);
        if (!df.m356s(this.mContext).m357a(ag(), this.kK)) {
            Log.e("GmsClient", "unable to connect to service: " + ag());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public void disconnect() {
        this.kL = false;
        synchronized (this.kN) {
            this.kM = false;
        }
        synchronized (this.kJ) {
            int size = this.kJ.size();
            for (int i = 0; i < size; i++) {
                ((C0135b) this.kJ.get(i)).bf();
            }
            this.kJ.clear();
        }
        this.kD = null;
        if (this.kK != null) {
            df.m356s(this.mContext).m358b(ag(), this.kK);
            this.kK = null;
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public boolean isConnected() {
        return this.kD != null;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.kN) {
            z = this.kM;
        }
        return z;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        dm.m392e(listener);
        synchronized (this.kE) {
            contains = this.kE.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        dm.m392e(listener);
        synchronized (this.kH) {
            contains = this.kH.contains(listener);
        }
        return contains;
    }

    protected abstract T m1246p(IBinder iBinder);

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        dm.m392e(listener);
        synchronized (this.kE) {
            if (this.kE.contains(listener)) {
                Log.w("GmsClient", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                if (this.kG) {
                    this.kE = new ArrayList(this.kE);
                }
                this.kE.add(listener);
            }
        }
        if (isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        dm.m392e(listener);
        synchronized (this.kH) {
            if (this.kH.contains(listener)) {
                Log.w("GmsClient", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                if (this.kI) {
                    this.kH = new ArrayList(this.kH);
                }
                this.kH.add(listener);
            }
        }
    }

    protected final void m1247u(IBinder iBinder) {
        try {
            m1244a(C0417a.m1265w(iBinder), new C0579d(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        dm.m392e(listener);
        synchronized (this.kE) {
            if (this.kE != null) {
                if (this.kG) {
                    this.kE = new ArrayList(this.kE);
                }
                if (!this.kE.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.kG && !this.kF.contains(listener)) {
                    this.kF.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        dm.m392e(listener);
        synchronized (this.kH) {
            if (this.kH != null) {
                if (this.kI) {
                    this.kH = new ArrayList(this.kH);
                }
                if (!this.kH.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionFailedListener(): listener " + listener + " not found");
                }
            }
        }
    }
}
