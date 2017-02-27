package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C0167a;
import com.google.android.gms.location.C0167a.C0472a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class ey {
    private final Context mContext;
    private final fc<ex> oO;
    private ContentProviderClient oP;
    private boolean oQ;
    private HashMap<LocationListener, C0586b> oR;

    /* renamed from: com.google.android.gms.internal.ey.a */
    private static class C0145a extends Handler {
        private final LocationListener oS;

        public C0145a(LocationListener locationListener) {
            this.oS = locationListener;
        }

        public C0145a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.oS = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    this.oS.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ey.b */
    private static class C0586b extends C0472a {
        private Handler oT;

        C0586b(LocationListener locationListener, Looper looper) {
            this.oT = looper == null ? new C0145a(locationListener) : new C0145a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.oT == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.oT.sendMessage(obtain);
        }

        public void release() {
            this.oT = null;
        }
    }

    public ey(Context context, fc<ex> fcVar) {
        this.oP = null;
        this.oQ = false;
        this.oR = new HashMap();
        this.mContext = context;
        this.oO = fcVar;
    }

    public void cm() {
        if (this.oQ) {
            setMockMode(false);
        }
    }

    public Location getLastLocation() {
        this.oO.bc();
        try {
            return ((ex) this.oO.bd()).cl();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.oR) {
                for (C0167a c0167a : this.oR.values()) {
                    if (c0167a != null) {
                        ((ex) this.oO.bd()).m580a(c0167a);
                    }
                }
                this.oR.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.oO.bc();
        try {
            ((ex) this.oO.bd()).m574a(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.oO.bc();
        dm.m388a((Object) listener, (Object) "Invalid null listener");
        synchronized (this.oR) {
            C0167a c0167a = (C0586b) this.oR.remove(listener);
            if (this.oP != null && this.oR.isEmpty()) {
                this.oP.release();
                this.oP = null;
            }
            if (c0167a != null) {
                c0167a.release();
                try {
                    ((ex) this.oO.bd()).m580a(c0167a);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.oO.bc();
        try {
            ((ex) this.oO.bd()).m577a(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.oO.bc();
        if (looper == null) {
            dm.m388a(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.oR) {
            C0167a c0586b;
            C0586b c0586b2 = (C0586b) this.oR.get(listener);
            if (c0586b2 == null) {
                c0586b = new C0586b(listener, looper);
            } else {
                Object obj = c0586b2;
            }
            this.oR.put(listener, c0586b);
            try {
                ((ex) this.oO.bd()).m579a(request, c0586b, this.mContext.getPackageName());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.oO.bc();
        try {
            ((ex) this.oO.bd()).setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.oO.bc();
        try {
            ((ex) this.oO.bd()).setMockMode(isMockMode);
            this.oQ = isMockMode;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
