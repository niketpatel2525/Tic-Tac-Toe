package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.de.C0135b;
import com.google.android.gms.internal.de.C0579d;
import com.google.android.gms.internal.fd.C0445a;
import com.google.android.gms.internal.fe.C0447a;
import com.google.android.gms.panorama.PanoramaClient.C0205a;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

public class ff extends de<fe> {

    /* renamed from: com.google.android.gms.internal.ff.a */
    final class C0448a extends C0135b<C0205a> {
        public final ConnectionResult qV;
        public final Intent qW;
        final /* synthetic */ ff qX;
        public final int type;

        public C0448a(ff ffVar, C0205a c0205a, ConnectionResult connectionResult, int i, Intent intent) {
            this.qX = ffVar;
            super(ffVar, c0205a);
            this.qV = connectionResult;
            this.type = i;
            this.qW = intent;
        }

        protected void m1477a(C0205a c0205a) {
            if (c0205a != null) {
                c0205a.m769a(this.qV, this.type, this.qW);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.c */
    final class C0449c extends C0135b<OnPanoramaInfoLoadedListener> {
        private final ConnectionResult qV;
        private final Intent qW;
        final /* synthetic */ ff qX;

        public C0449c(ff ffVar, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, ConnectionResult connectionResult, Intent intent) {
            this.qX = ffVar;
            super(ffVar, onPanoramaInfoLoadedListener);
            this.qV = connectionResult;
            this.qW = intent;
        }

        protected void m1479a(OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            if (onPanoramaInfoLoadedListener != null) {
                onPanoramaInfoLoadedListener.onPanoramaInfoLoaded(this.qV, this.qW);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.b */
    final class C0589b extends C0445a {
        final /* synthetic */ ff qX;
        private final C0205a qY;
        private final OnPanoramaInfoLoadedListener qZ;
        private final Uri ra;

        public C0589b(ff ffVar, OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri) {
            this.qX = ffVar;
            this.qY = null;
            this.qZ = onPanoramaInfoLoadedListener;
            this.ra = uri;
        }

        public void m1912a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.ra != null) {
                this.qX.getContext().revokeUriPermission(this.ra, 1);
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (this.qY != null) {
                this.qX.m1243a(new C0448a(this.qX, this.qY, connectionResult, i2, intent));
            } else {
                this.qX.m1243a(new C0449c(this.qX, this.qZ, connectionResult, intent));
            }
        }
    }

    public ff(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    protected void m1913a(dj djVar, C0579d c0579d) throws RemoteException {
        djVar.m372a(c0579d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m1914a(C0589b c0589b, Uri uri, Bundle bundle, boolean z) {
        bc();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((fe) bd()).m586a(c0589b, uri, bundle, z);
        } catch (RemoteException e) {
            c0589b.m1912a(8, null, 0, null);
        }
    }

    public void m1915a(OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, Uri uri, boolean z) {
        m1914a(new C0589b(this, onPanoramaInfoLoadedListener, z ? uri : null), uri, null, z);
    }

    protected String ag() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public fe am(IBinder iBinder) {
        return C0447a.al(iBinder);
    }

    public /* synthetic */ IInterface m1916p(IBinder iBinder) {
        return am(iBinder);
    }
}
