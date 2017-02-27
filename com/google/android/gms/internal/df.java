package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.de.C0136e;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class df implements Callback {
    private static final Object kU;
    private static df kV;
    private final Context kW;
    private final HashMap<String, C0138a> kX;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.df.a */
    final class C0138a {
        private final String kY;
        private final C0137a kZ;
        private final HashSet<C0136e> la;
        private boolean lb;
        private IBinder lc;
        private ComponentName ld;
        final /* synthetic */ df le;
        private int mState;

        /* renamed from: com.google.android.gms.internal.df.a.a */
        public class C0137a implements ServiceConnection {
            final /* synthetic */ C0138a lf;

            public C0137a(C0138a c0138a) {
                this.lf = c0138a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.lf.le.kX) {
                    this.lf.lc = binder;
                    this.lf.ld = component;
                    Iterator it = this.lf.la.iterator();
                    while (it.hasNext()) {
                        ((C0136e) it.next()).onServiceConnected(component, binder);
                    }
                    this.lf.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.lf.le.kX) {
                    this.lf.lc = null;
                    this.lf.ld = component;
                    Iterator it = this.lf.la.iterator();
                    while (it.hasNext()) {
                        ((C0136e) it.next()).onServiceDisconnected(component);
                    }
                    this.lf.mState = 2;
                }
            }
        }

        public C0138a(df dfVar, String str) {
            this.le = dfVar;
            this.kY = str;
            this.kZ = new C0137a(this);
            this.la = new HashSet();
            this.mState = 0;
        }

        public void m351a(C0136e c0136e) {
            this.la.add(c0136e);
        }

        public void m352b(C0136e c0136e) {
            this.la.remove(c0136e);
        }

        public C0137a bg() {
            return this.kZ;
        }

        public String bh() {
            return this.kY;
        }

        public boolean bi() {
            return this.la.isEmpty();
        }

        public boolean m353c(C0136e c0136e) {
            return this.la.contains(c0136e);
        }

        public IBinder getBinder() {
            return this.lc;
        }

        public ComponentName getComponentName() {
            return this.ld;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.lb;
        }

        public void m354l(boolean z) {
            this.lb = z;
        }
    }

    static {
        kU = new Object();
    }

    private df(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.kX = new HashMap();
        this.kW = context.getApplicationContext();
    }

    public static df m356s(Context context) {
        synchronized (kU) {
            if (kV == null) {
                kV = new df(context.getApplicationContext());
            }
        }
        return kV;
    }

    public boolean m357a(String str, C0136e c0136e) {
        boolean isBound;
        synchronized (this.kX) {
            C0138a c0138a = (C0138a) this.kX.get(str);
            if (c0138a != null) {
                this.mHandler.removeMessages(0, c0138a);
                if (!c0138a.m353c(c0136e)) {
                    c0138a.m351a((C0136e) c0136e);
                    switch (c0138a.getState()) {
                        case DetectedActivity.ON_BICYCLE /*1*/:
                            c0136e.onServiceConnected(c0138a.getComponentName(), c0138a.getBinder());
                            break;
                        case DetectedActivity.ON_FOOT /*2*/:
                            c0138a.m354l(this.kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0138a.bg(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0138a = new C0138a(this, str);
            c0138a.m351a((C0136e) c0136e);
            c0138a.m354l(this.kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0138a.bg(), 129));
            this.kX.put(str, c0138a);
            isBound = c0138a.isBound();
        }
        return isBound;
    }

    public void m358b(String str, C0136e c0136e) {
        synchronized (this.kX) {
            C0138a c0138a = (C0138a) this.kX.get(str);
            if (c0138a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0138a.m353c(c0136e)) {
                c0138a.m352b(c0136e);
                if (c0138a.bi()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0138a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                C0138a c0138a = (C0138a) msg.obj;
                synchronized (this.kX) {
                    if (c0138a.bi()) {
                        this.kW.unbindService(c0138a.bg());
                        this.kX.remove(c0138a.bh());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
